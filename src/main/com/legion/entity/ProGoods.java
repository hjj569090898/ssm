package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化


@Data
public class ProGoods {   //工程物资
    private Integer id; //编号
    private Integer projectid; //工程编号
    private int plannum;
    private int actualnum;
    private int applynum;
    private int goodsid;
    private String name;
    private String date;
}
