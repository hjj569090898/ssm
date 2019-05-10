package legion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)//属性为空时不序列化

@Data
public class Pimage {
    private Integer id;
    private Integer projectid;
    private String imageurl;
}
