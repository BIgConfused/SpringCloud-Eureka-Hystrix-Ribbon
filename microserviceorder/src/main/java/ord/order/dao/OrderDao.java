package ord.order.dao;

import ord.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    Order queryOrderById(String orderId);
}
