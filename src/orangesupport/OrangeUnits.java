package orangesupport;

import mindustry.content.StatusEffects;
import mindustry.entities.abilities.Ability;
import mindustry.type.UnitType;

public class OrangeUnits {

    public static UnitType orangeSupport;

    public static void load() {

        orangeSupport = new UnitType("orange-support");

        // =========================
        // MOVEMENT
        // =========================

        orangeSupport.flying = true;

        // Very fast
        orangeSupport.speed = 5.0f;

        orangeSupport.accel = 1.0f;
        orangeSupport.drag = 0.05f;
        orangeSupport.rotateSpeed = 20f;
        orangeSupport.baseRotateSpeed = 20f;

        orangeSupport.hitSize = 16f;

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
        // DEFENSIVE FORCE FIELD
        // =========================

        orangeSupport.abilities.add(
            new OrangeForceFieldAbility(
                80f,       // radius
                2.0f,      // shield regeneration
                500f,      // maximum shield
                60f * 5f   // cooldown
            )
        );

        // =========================
        // STATUS IMMUNITIES
        // =========================

        orangeSupport.immunities.add(StatusEffects.burning);
        orangeSupport.immunities.add(StatusEffects.melting);
        orangeSupport.immunities.add(StatusEffects.shocked);
        orangeSupport.immunities.add(StatusEffects.electrified);
        orangeSupport.immunities.add(StatusEffects.freezing);
        orangeSupport.immunities.add(StatusEffects.wet);
        orangeSupport.immunities.add(StatusEffects.sapped);
        orangeSupport.immunities.add(StatusEffects.slow);
        orangeSupport.immunities.add(StatusEffects.tarred);

        // =========================
        // CORE DOCKING
        // =========================

        orangeSupport.coreUnitDock = true;

        // =========================
        // ENVIRONMENT
        // =========================

        orangeSupport.envDisabled = 0;
        orangeSupport.fogRadius = 80f;
    }
}
