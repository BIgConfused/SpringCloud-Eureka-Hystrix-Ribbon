package ord.orderDetail.entity;

import lombok.Data;
import ord.order.entity.Item;

@Data
public class OrderDetail {

    private String orderDetailId; //订单详情id

    private String orderId; //订单id

    private String itemId; //商品id

    private Item items; //商品信息
}
