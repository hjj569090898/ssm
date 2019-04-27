package legion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Project {
    private Integer id; //
    private String state;
    private String name;
    private String plan_start;
    private String plan_end;
    private String actual_start;
    private String actual_end;
    private String leader;  //负责人
}
