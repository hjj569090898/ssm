package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class StockIn {
    private Integer id;
    private Integer num;
    private Double price;
    private Double allprice;
    private String state;
    private String admin;
    private Integer goodsid;
    private String applicant;
    private String date;
    private String reason;
//    private List<Goods> goods;
    private String number;
    private String name;
}
