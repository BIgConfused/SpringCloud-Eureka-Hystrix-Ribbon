package item.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import item.entity.Item;
import item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("商品Controller")
@RestController
@RequestMapping("/cloud/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{itemId}")
    @ApiOperation("根据商品id查询商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId",value = "商品id",paramType = "path")
    })
    public Item queryItemById(@PathVariable("itemId") String itemId){
        if("".equals(itemId)||itemId == null){
            return null;
        }
        return itemService.queryItemById(itemId);
    }
}
