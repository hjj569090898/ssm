package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)//属性为空时不序列化


@Data
public class ProjectCount {   //工程统计
    private Integer projectid; //工程编号
    private Integer progressnum; //任务数
    private Integer planday;    //计划总时长
    private Integer acday;    //实际总时长
    private Double plancost; //计划总花费
    private Double accost;    //实际当前总花费
    private Double delayday;  //延期天使
    private Double planworking; //计划人工
    private Double acworking;  //实际人工
    private Double subcost;  //额外总花费
    private Double allpercent; //总完成比
}
