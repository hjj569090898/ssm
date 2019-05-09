package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化


@Data
public class ProGoods {   //工程统计
    private Integer id; //编号
    private Integer projectid; //工程编号
    private Double plannum;
    private Double actualnum;
    private int goodsid;
    private String date;
}
