package item.dao;


import item.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemDao {

    Item queryItemById(@Param("itemId") String itemId);
}
