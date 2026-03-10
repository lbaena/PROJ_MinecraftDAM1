package lbaena.projecteminecraft.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AnimalType {
    MAMMAL("Mamífer"),
    BIRD("Ocell"),
    FISH("Peix"),
    REPTILE("Rèptil"),
    AMPHIBIAN("Amfibi"),
    INSECT("Insecte"),
    ARACHNID("Aràcnid"),
    CRUSTACEAN("Crustaci"),
    MOLLUSK("Mol·lusc"),
    OTHER("Altra");

    private final String displayName;
}
