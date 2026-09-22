package orangesupport;

import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // Basic stats
        orangeSupport.health = 300f;
        orangeSupport.speed = 3.0f;
        orangeSupport.hitSize = 8f;

        // Make the unit fly
        orangeSupport.flying = true;

        // Building
        orangeSupport.buildSpeed = 1f;
        orangeSupport.buildRange = 120f;

        // Mining
        orangeSupport.mineTier = 1;
        orangeSupport.mineSpeed = 2f;

        // Support/healing ability
        orangeSupport.abilities.add(
            new OrangeRepairFieldAbility(
                20f,
                80f
            )
        );
    }
}