package orangesupport;

import arc.graphics.Color;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.UnitType;

public class OrangeSupportMod extends Mod {

    public static UnitType orangeSupport;

    @Override
    public void loadContent() {

        orangeSupport = new UnitType("orange-support") {{
            constructor = UnitEntity::create;

            // Movement
            speed = 60f / 8f;

            // Health
            health = 100000f;

            // Player controlled
            playerControllable = true;
            logicControllable = true;

            // Cannot attack
            canAttack = false;
            targetAir = false;
            targetGround = false;
            weapons.clear();

            // Fast building
            buildSpeed = 1000f;
            buildRange = 80f;

            // Fast mining
            mineSpeed = 1000f;
            mineTier = 999;
            mineRange = 80f;
            mineWalls = true;
            mineFloor = true;

            // Large inventory
            itemCapacity = 1000000;

            // Orange
            outlineColor = Color.valueOf("ff7a00");

            // 10-block shield
            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                0f
            ));

            // Repair nearby units and buildings
            abilities.add(
                new OrangeRepairFieldAbility(100f, 80f)
            );
        }};
    }
}
