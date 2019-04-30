package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Attence {
    private Integer id;
    private String name;
    private String groups;
    private Integer Mattence; //应出勤
    private Integer Rattence; //实出勤
    private Double leave; //请假
    private Double Outwork; //加班
    private String month;
}
