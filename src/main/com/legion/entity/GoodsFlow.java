package legion.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class GoodsFlow {
    private Integer id;
    private Integer goodsid ;
    private String date ;
    private String admin;
    private int num;
    private String descs;
}
