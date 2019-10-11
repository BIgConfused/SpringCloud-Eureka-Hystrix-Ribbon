package ord.order.service.imp;

import ord.order.service.OrderService;
import ord.order.dao.OrderDao;
import ord.order.entity.Item;
import ord.order.entity.Order;
import ord.orderDetail.entity.OrderDetail;
import ord.orderDetail.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ItemServiceImp itemServiceImp;

    @Autowired
    private OrderDetailService orderDetailService;
    @Override
    public Order queryOrderById(String orderId) {
        Order order = orderDao.queryOrderById(orderId);
        List<OrderDetail> orderDetails = orderDetailService.queryOrderDetails(orderId);
        orderDetails.forEach(orderDetail->{
            /*通过微服务查询商品数据*/
            Item item = itemServiceImp.queryItemById(orderDetail.getItemId());
            if(item!=null){
                orderDetail.setItems(item);
            }
        });
        order.setOrderDetails(orderDetails);
        return order;
    }
}
