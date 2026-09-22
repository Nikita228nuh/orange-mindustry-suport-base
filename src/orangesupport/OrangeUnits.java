package orangesupport;

import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // Basic unit stats
        orangeSupport.health = 300f;
        orangeSupport.speed = 0.6f;
        orangeSupport.hitSize = 8f;

        // Can build
        orangeSupport.buildSpeed = 1f;
        orangeSupport.buildRange = 120f;

        // Can mine
        orangeSupport.mineTier = 1;
        orangeSupport.mineSpeed = 2f;

        // Repair nearby friendly units/buildings
        orangeSupport.abilities.add(
            new OrangeRepairFieldAbility(
                20f,  // healing per second
                80f   // range
            )
        );
    }
}
