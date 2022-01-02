package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum stateType {

    NOT_STARTED("Not Started"),
    IN_PROCESS("In Progress"),
    FINISHED("Finished");

    @Getter
    private String value;



}
