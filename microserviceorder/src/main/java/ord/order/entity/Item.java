package ord.order.entity;

import lombok.Data;

@Data
public class Item {

    private String itemId;     //商品id

    private String title;   //商品名

    private String pic;     //图片

    private String descs;    //描述

    private Long price;     //价格

}
