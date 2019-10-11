package ord.order.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import ord.order.entity.Order;
import ord.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("订单Controller")
@RestController
@RequestMapping("/cloud/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("根据订单id查询订单商品信息")
    @GetMapping("/{orderId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId",value = "订单id",paramType = "path")
    })
    public Order queryOrderById(@PathVariable("orderId") String orderId){
        return orderService.queryOrderById(orderId);
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;//自动注入

    /**
     * @Description 测试Ribbon负载均衡
     * @Author lijinlong
     * @Date   2019/10/11 17:05
     * @Param  []
     * @Return void
     * @Exception
     */
    @GetMapping("test")
    public void test() {
        String serviceId = "app-item";
        for (int i = 0; i < 100; i++) {
            ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
            System.out.println("第" + (i + 1) + "次：" + serviceInstance.getHost() + ": " + serviceInstance.getPort());
        }
    }
}
