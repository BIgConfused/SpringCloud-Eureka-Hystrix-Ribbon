# SpringCloud-Eureka-Hystrix-Ribbon
练习SpringCloud项目集成Eureka(注册中心)、Hystrix(断路器)、Ribbon(负载均衡)

# 说明:
```
eurekaserver、eurekservercp1、eurekservercp2为注册中心Server<br/>
microserviceitem为提供者;microserviceorder为消费者------提供者和消费者均集成了swagger

与Springboot的区别就在于要将服务注册到注册中心。
服务在调用另一个服务时这里采用的是restTemplate底层使用了okHttp进行了替换。
调用和断路器在microserviceorder项目中的ItemServiceImp中进行了使用,里面有相关注释。
主要就是进行了application.yml的配置，然后在注册中心server中添加了认证及配置类WebSecurityConfig

负载均衡也是在消费者里进行了配置：
在microseviceorder的application.yml中进行了配置
请求路径里的ip要换成提供者的应用名
mycloud:
  item:
    url: http://app-item/cloud/item/

#添加ribbon负载均衡策略
#com.netflix.loadbalancer.RandomRule随机
#com.netflix.loadbalancer.RoundRobinRule轮询
#com.netflix.loadbalancer.PredicateBasedRule默认策略，综合判断server所在的区的性能和server的可用性
#serviceid.ribbon.NFLoadBalancerRuleClassName=负载均衡策略
app-item:
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
    
```
