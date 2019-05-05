package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Contract {
    private Integer id; //合同编号
    private Double stuff; //
    private Double outstuff;
    private Double work;
    private Double outwork;
    private Double others;
    private String pjstate;
    private String ctstate;
    private Double allmoney;
    private String admin;
    private String date;
}
