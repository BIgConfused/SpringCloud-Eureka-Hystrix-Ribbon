package item;

import item.utils.ApiDocket;
import item.utils.ApiOverview;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }

    @Bean
    public Docket apiItem(){
        ApiOverview apiOverview = new ApiOverview("商品","商品");
        apiOverview.setContact("LJL");
        ApiDocket apiDocket = new ApiDocket("商品api","/cloud/item.*");
        return apiDocket.build(apiOverview);
    }
}
