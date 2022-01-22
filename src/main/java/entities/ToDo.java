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
    private DateRange Date_range;
    private stateType State;

    public ToDo() {
        Title = "";
        Description = "";
        Priority = priorityType.LOW ;
        Date_range = new DateRange();
        State = stateType.NOT_STARTED;
        //applying Replace Temp with Query refactoring method
        Id = assignUniqueId(Date_range.getInitDate().hashCode());
    }

    private String assignUniqueId(int hash){
        int tmpID = hash;

        if (tmpID < 1){
            tmpID = -1 * tmpID;
        }
        return String.valueOf( tmpID );
    }

}
