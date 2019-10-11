package eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
* @author: lijinlong
* @Date: 2019/10/11 13:57
* @Description Eureka注册中心
*/
@SpringBootApplication
@EnableEurekaServer //申明为Eureka注册中心服务端
public class ApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class,args);
    }
}
