package item.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

public class ApiDocket {
    @Autowired(
            required = false
    )
    private ApiOverview apiOverview;
    private String name;
    private String filteringRule;

    public ApiDocket(String name, String filteringRule) {
        this.name = name;
        this.filteringRule = filteringRule;
    }

    private ApiInfo apiInfo(ApiOverview apiOverview) {
        if (apiOverview == null) {
            return ApiInfo.DEFAULT;
        } else {
            ApiInfo apiInfo = new ApiInfo(apiOverview.getTitle(), apiOverview.getDescription(), apiOverview.getVersion(), "", new Contact(apiOverview.getContact(), "", ""), "", "", new ArrayList());
            return apiInfo;
        }
    }

    public Docket build() {
        return this.build(this.apiOverview);
    }

    public Docket build(ApiOverview apiOverview) {
        return (new Docket(DocumentationType.SWAGGER_2)).groupName(this.name).genericModelSubstitutes(new Class[]{ResponseEntity.class}).useDefaultResponseMessages(true).forCodeGeneration(false).select().paths(PathSelectors.regex(this.filteringRule)).build().apiInfo(this.apiInfo(apiOverview));
    }
}
