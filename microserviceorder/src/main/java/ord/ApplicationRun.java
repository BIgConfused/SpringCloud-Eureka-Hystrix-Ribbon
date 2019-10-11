package ord;


import ord.utils.ApiDocket;
import ord.utils.ApiOverview;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import sun.net.www.http.HttpClient;

@SpringBootApplication//启动类
@EnableSwagger2//swagger
@EnableEurekaClient//注册客户端
@EnableHystrix//容错
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }

    @Bean
    public Docket apiItem(){
        ApiOverview apiOverview = new ApiOverview("订单模块","订单");
        apiOverview.setContact("LJL");
        ApiDocket apiDocket = new ApiDocket("订单api","/cloud/order.*");
        return apiDocket.build(apiOverview);
    }

    /*向Spring容器中定义RestTemplate对象*/
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        /*RestTemplate底层使用jdk实现，可以使用okhttp在pom中导入依赖文件后直接new一个就可以替换*/
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
