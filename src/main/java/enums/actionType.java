package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum actionType {

    NEW("Nuevo"),
    UPDATE("Actualizando");

    @Getter
    private String value;

}
