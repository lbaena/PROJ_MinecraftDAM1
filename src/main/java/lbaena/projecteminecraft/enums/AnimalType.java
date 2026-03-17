package lbaena.projecteminecraft.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum AnimalType {
    MAMMAL("Mamífer"),
    BIRD("Ocell"),
    AQUATIC("Peix");

    private final String displayName;

    AnimalType(String displayName) {
        this.displayName = displayName;
    }
}
