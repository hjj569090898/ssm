package legion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class StockOut {
    private Integer id;
    private Integer num;
    private String state;
    private String admin;
    private Integer goodsid;
    private Integer progressid;
    private Integer projectid;
    private String applicant;
    private String time;
    private String reason;
//    private List<Goods> goods;
//    private String number;
    private String name;
    private String pjname;
    private String prname;
}
