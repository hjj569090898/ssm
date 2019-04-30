package legion.entity;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)//属性为空时不序列化


@Data
public class User {
    private Integer id; //工号(子增）
    private String password;
    private String username; //账户名
    private String birthday;
    private String credit;
    private String mobile;
    private String email;
    private String name; //真实姓名
    private Integer groupid;//部门编号
}
