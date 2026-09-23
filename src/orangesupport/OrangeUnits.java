package orangesupport;

import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // =========================
        // BASIC STATS
        // =========================

        orangeSupport.health = 2000f;
        orangeSupport.hitSize = 8f;

        // Fast flying unit
        orangeSupport.flying = true;
        orangeSupport.lowAltitude = false;
        orangeSupport.speed = 2.0f;
        orangeSupport.accel = 0.5f;
        orangeSupport.drag = 0.1f;

        // =========================
        // BUILDING
        // =========================

        orangeSupport.buildSpeed = 120f;
        orangeSupport.buildRange = 300f;

        // =========================
        // MINING
        // =========================

        orangeSupport.mineTier = 100;
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

       
