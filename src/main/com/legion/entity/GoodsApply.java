package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化


@Data
public class GoodsApply {   //工程统计
    private Integer id; //编号
    private Integer goodsid;
    private Integer applynum;
    private int projectid;
    private String  reason;
    private String state;
    private String date;
    private String admin;
    private Integer progoodsid; //申请编号的id
}
