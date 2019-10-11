package ord.order.service;

import ord.order.entity.Order;

public interface OrderService {
    Order queryOrderById(String orderId);
}
