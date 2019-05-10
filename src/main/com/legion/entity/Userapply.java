package legion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Userapply {
    private Integer id;
    private Integer userid;
    private Double money;
    private String state;
    private String date;
    private String reason;
    private String audidate;
}
