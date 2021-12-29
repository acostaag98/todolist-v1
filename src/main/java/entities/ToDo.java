package entities;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import enums.priorityType;
import enums.stateType;

@Data
public class ToDo implements Serializable {
    private String Id;
    private String Title;
    private String Description;
    private priorityType Priority;
    private Date InitDate;
    private Date EndDate;
    private stateType State;

    public ToDo( String title, String description, priorityType priority, Date initDate, Date endDate, stateType state) {
        Title = title;
        Description = description;
        Priority = priorityType.LOW ;
        InitDate = initDate;
        EndDate = endDate;
        State = stateType.NOT_STARTED;
        Id = assignUniqueId(InitDate.hashCode());
    }

    private String assignUniqueId(int hash){
        int tmpID = hash;

        if (tmpID < 1){
            tmpID = -1 * tmpID;
        }
        return String.valueOf( tmpID );
    }

}
