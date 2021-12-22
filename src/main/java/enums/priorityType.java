package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum priorityType {

    LOW("Baja"),
    MEDIUM("Media"),
    HIGH("Alta");

    @Getter
    private String value;
}
