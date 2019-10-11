package ord.order.entity;

import lombok.Data;
import ord.orderDetail.entity.OrderDetail;

import java.util.Date;
import java.util.List;

@Data
public class Order {

    private String orderId; //订单id

    private String userId;    //用户id

    private Date createDate;    //创建时间

    private Date updateDate;    //更新时间

    private List<OrderDetail> orderDetails; //订单详情

}
