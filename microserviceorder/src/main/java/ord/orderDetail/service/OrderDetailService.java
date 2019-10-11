package ord.orderDetail.service;

import ord.orderDetail.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> queryOrderDetails(String orderId);
}
