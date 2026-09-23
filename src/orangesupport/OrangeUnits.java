package orangesupport;

import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // =========================
        // MOVEMENT
        // =========================

        orangeSupport.flying = true;
        orangeSupport.speed = 2.0f;
        orangeSupport.hitSize = 8f;

        // =========================
        // HEALTH
        // =========================

        orangeSupport.health = 2000f;

        // =========================
        // BUILDING
        // =========================

        orangeSupport.buildSpeed = 120f;
        orangeSupport.buildRange = 300f;

        // =========================
        // MINING
        // =========================

        // High enough for the normal mineable resources.
        orangeSupport.mineTier = 10;
        orangeSupport.mineSpeed = 10f;

        orangeSupport.mineFloor = true;
        orangeSupport.mineWalls = true;

        orangeSupport.itemCapacity = 1000;

        // =========================
        // REPAIR FIELD
        // =========================

        orangeSupport.abilities.add(
            new OrangeRepairFieldAbility(
                100f,
                200f
            )
        );
    }
}