package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Finance {
    private Integer id;
    private String admin;
    private String descs;
    private Double money;
    private Integer type;
    private String date;
}
