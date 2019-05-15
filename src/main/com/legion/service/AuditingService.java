package legion.service;
import legion.entity.Auditing;

import java.util.ArrayList;

public interface AuditingService {
     Integer add(Auditing auditing);

     Integer update(String admin,String advice,String state,String adate,Integer id);

    ArrayList<Auditing> listAuditing(String type,String state,Integer page);

    Auditing QueryAuditing (Integer id);

    Integer countListAuditing(String type,String state);
}
