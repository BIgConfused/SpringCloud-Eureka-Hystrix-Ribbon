package ord.orderDetail.service.imp;

import ord.orderDetail.dao.OrderDetailDao;
import ord.orderDetail.entity.OrderDetail;
import ord.orderDetail.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<OrderDetail> queryOrderDetails(String orderId) {
        return orderDetailDao.queryOrderDetails(orderId);
    }
}
