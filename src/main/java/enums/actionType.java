package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum actionType {

    NEW("New"),
    UPDATE("Updating");

    @Getter
    private String value;

}
