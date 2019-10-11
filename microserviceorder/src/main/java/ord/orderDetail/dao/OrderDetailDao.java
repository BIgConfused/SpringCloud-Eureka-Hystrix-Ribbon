package ord.orderDetail.dao;

import ord.orderDetail.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDetailDao {
    List<OrderDetail> queryOrderDetails(@Param("orderId") String orderId);
}
