package legion.dao;
import legion.entity.Attence;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AttenceDao {

    ArrayList<Attence> ListAttend(@Param("begin") String begin,
                                  @Param("end") String end,
                                  @Param("name")String name,
                                  @Param("page") Integer page);





}
