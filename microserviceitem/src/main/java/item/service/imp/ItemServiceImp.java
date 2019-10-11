package item.service.imp;

import item.dao.ItemDao;
import item.entity.Item;
import item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public Item queryItemById(String itemId) {
        return itemDao.queryItemById(itemId);
    }
}
