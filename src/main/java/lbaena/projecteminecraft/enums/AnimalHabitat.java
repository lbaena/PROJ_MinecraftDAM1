package lbaena.projecteminecraft.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalHabitat {
    FOREST("Bosc"),
    DESERT("Dessert"),
    OCEAN("Oceà"),
    MOUNTAIN("Muntanya"),
    GRASSLAND("Pradera"),
    WETLAND("Zona humida"),
    URBAN("Zona urbana"),
    TUNDRA("Tundra"),
    JUNGLE("Jungla"),
    OTHER("Altra");

    private final String displayName;
}
