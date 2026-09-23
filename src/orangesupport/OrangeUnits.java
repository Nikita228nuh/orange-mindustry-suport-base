package orangesupport;

import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // Basic stats
        orangeSupport.health = 300f;
        orangeSupport.speed = 1.2f;
        orangeSupport.hitSize = 8f;

        // Flying
        orangeSupport.flying = true;
        orangeSupport.lowAltitude = false;

        // Building
        orangeSupport.buildSpeed = 1f;
        orangeSupport.buildRange = 120f;

        // Mining
        // High tier = can mine very hard ores.
        orangeSupport.mineTier = 100;
        orangeSupport.mineSpeed = 5f;

        // Allow mining from both floor and walls.
        orangeSupport.mineFloor = true;
        orangeSupport.mineWalls = true;

        // Carry mined resources.
        orangeSupport.itemCapacity = 100;

        // Repair nearby friendly units/buildings.
        orangeSupport.abilities.add(
            new OrangeRepairFieldAbility(
                20f,
                80f
            )
        );
    }
}