package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化
//资金申用审核
@Data
public class Auditing {
    private Integer id;
    private Integer linked; //关联编号
    private String reason;
    private Double money;
    private String type;
    private String date;
    private String state;
    private String applicant;
    private String adate;
    private String admin;
    private String advice;
}
