package legion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Progress {
    private Integer id; //
    private Integer projectid; //合同编号
    private String prname;
    private String planstart; //计划和实际的时间
    private String planend;
    private String actualstart;
    private String actualend;
    private Double planworking;
    private Double actualworking;
    private Double subcontractcost;
    private Double plancost;
    private Double actualcost;
    private String state;
    private String date;
    private String admin;  //负责人
    private String percent;
}
