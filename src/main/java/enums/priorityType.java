package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum priorityType {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    @Getter
    private String value;




}
