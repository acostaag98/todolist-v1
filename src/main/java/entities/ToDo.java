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

    public ToDo() {
        Title = "";
        Description = "";
        Priority = priorityType.LOW ;
        InitDate = new Date();
        EndDate = new Date();
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
