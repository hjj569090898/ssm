package legion.dao;
import legion.entity.Auditing;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AuditingDao {

    ArrayList<Auditing> ListAuditing(@Param("type") String type,
                                     @Param("state") String state,
                                     @Param("page") Integer page);

    Integer update(@Param("admin") String admin,@Param("advice") String advice,
                   @Param("state") String state, @Param("adate") String adate,
                   @Param("id") Integer id);

    Integer countListAuditing(@Param("type") String type,
                              @Param("state") String state);

    Integer add(Auditing auditing);

    Auditing QueryAuditing(@Param("id") Integer id);

}
