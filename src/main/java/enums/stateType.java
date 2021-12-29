package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum stateType {

    NOT_STARTED("No Comenzado"),
    IN_PROCESS("En Proceso"),
    FINISHED("Finalizado");

    @Getter
    private String value;



}
