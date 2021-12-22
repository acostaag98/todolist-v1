package entities;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;
import enums.priorityType;
import enums.stateType;

@Data
@AllArgsConstructor
public class ToDo implements Serializable {
    private int Id;
    private String Title;
    private String Description;
    private priorityType Priority;
    private Date initDate;
    private Date EndDate;
    private stateType State;
}
