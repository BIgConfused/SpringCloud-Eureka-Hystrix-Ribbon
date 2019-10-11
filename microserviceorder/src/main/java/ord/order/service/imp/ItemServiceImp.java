package ord.order.service.imp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import ord.order.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemServiceImp {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mycloud.item.url}")
    private String itemUrl;
    /*@HystrixCommand进行容错处理，fallbackMethod是容错的处理方法，方法的参数必须和原方法一致*/
    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemById(String itemId){
        /*Spring框架对restful方式的http请求做了封装，来简化操作*/
        return this.restTemplate.getForObject(itemUrl+itemId,Item.class);
    }
    /*容错处理方法*/
    public Item queryItemByIdFallbackMethod(String itemId){
        Item item = new Item();
        item.setItemId(itemId);
        item.setDescs("查询商品信息出错");
        item.setPic("查询商品信息出错");
        item.setPrice(null);
        item.setTitle("查询商品信息出错");
        return item;
    }
}
