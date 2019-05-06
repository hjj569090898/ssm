package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Data
public class Goods {
    private Integer id;
    private String name;
    private int number;
    private String units;
    private int type;
    private int latelynum;
    private String latelydate;
    private String admin;
}
