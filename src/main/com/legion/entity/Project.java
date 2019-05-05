package legion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Project {
    private Integer id; //
    private Integer ctid; //合同编号
    private String pnow;
    private String state;
    private String pjname;
    private String planstart; //计划和实际的时间
    private String planend;
    private String actualstart;
    private String actualend;
    private String leader;  //负责人
}
