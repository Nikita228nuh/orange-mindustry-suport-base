package orangesupport;

import mindustry.content.StatusEffects;
import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // =========================
        // MOVEMENT
        // =========================

        orangeSupport.flying = true;

        // Very fast movement
        orangeSupport.speed = 5.0f;

        orangeSupport.accel = 1.0f;
        orangeSupport.drag = 0.05f;

        orangeSupport.rotateSpeed = 20f;
        orangeSupport.baseRotateSpeed = 20f;

        orangeSupport.hitSize = 16f;

        // =========================
        // HEALTH
        // =========================

        orangeSupport.health = 5000f;

        // =========================
        // BUILDING
        // =========================

        orangeSupport.buildSpeed = 120f;
        orangeSupport.buildRange = 300f;

        // =========================
        // MINING
        // =========================

        orangeSupport.mineSpeed = 10f;
        orangeSupport.mineTier = 100;

        orangeSupport.mineWalls = true;
        orangeSupport.mineFloor = true;

        orangeSupport.itemCapacity = 9999;

        // =========================
        // REPAIR FIELD
        // =========================

        orangeSupport.abilities.add(
            new OrangeRepairFieldAbility(
                100f,
                200f
            )
        );

        // =========================
        // STRONG FORCE FIELD
        // =========================

        orangeSupport.abilities.add(
            new OrangeForceFieldAbility(
                100f,      // shield radius
                20f,       // shield regeneration
                2000f,     // maximum shield
                60f * 2f   // cooldown: 2 seconds
            )
        );

       