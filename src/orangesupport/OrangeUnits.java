package orangesupport;

import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // ========================================
        // HEALTH
        // ========================================

        orangeSupport.health = 10000f;
        orangeSupport.hitSize = 16f;

        // ========================================
        // MOVEMENT
        // ========================================

        orangeSupport.flying = true;
        orangeSupport.lowAltitude = false;

        // Very fast movement.
        orangeSupport.speed = 8.0f;
        orangeSupport.accel = 1.0f;
        orangeSupport.drag = 0.05f;

        // ========================================
        // BUILDING
        // ========================================

        // Extremely fast construction.
        orangeSupport.buildSpeed = 120f;
        orangeSupport.buildRange = 300f;

        // ========================================
        // MINING
        // ========================================

        // Extremely high mining tier.
        orangeSupport.mineTier = 100;
        orangeSupport.mineSpeed = 20f;

        // Mine floor and wall resources.
        orangeSupport.mineFloor = true;
        orangeSupport.mineWalls = true;

        // Large inventory.
        orangeSupport.itemCapacity = 9999;

        // ========================================
        // REPAIR FIELD
        // ========================================

        orangeSupport.abilities.add(
            new OrangeRepairFieldAbility(
                100f,
                300f
            )
        );

        // ========================================
        // FORCE FIELD
        // ========================================

        orangeSupport.abilities.add(
            new OrangeForceFieldAbility(
                200f,       // field radius
                1000f,      // shield regeneration
                100000f,    // maximum shield
                1f          // cooldown
            )
        );
    }
}