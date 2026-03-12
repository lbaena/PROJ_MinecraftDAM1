package lbaena.projecteminecraft.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalType {
    MAMMAL("Mamífer"),
    BIRD("Ocell"),
    AQUATIC("Peix");

    private final String displayName;
}
