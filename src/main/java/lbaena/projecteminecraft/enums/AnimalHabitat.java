package lbaena.projecteminecraft.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalHabitat {
    GROUND("Terra"),
    AIR("Aire"),
    WATER("Aigua");

    private final String displayName;
}
