package orangesupport;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.abilities.RepairFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.UnitType;

public class OrangeSupportMod extends Mod {

    public static UnitType orangeSupport;

    @Override
    public void loadContent() {

        orangeSupport = new UnitType("orange-support") {{
            constructor = UnitEntity::create;

            // 60 blocks per second.
            speed = 1f;

            // 10 blocks wide.
            hitSize = 80f;

            // Health.
            health = 100000f;

            // Very fast building.
            buildSpeed = 1000f;
            buildRange = 80f;

            // Very fast mining.
            mineSpeed = 1000f;
            mineTier = 999;
            mineWalls = true;
            mineFloor = true;
            mineRange = 80f;

            // Player controlled.
            playerControllable = true;
            logicControllable = true;

            // Cannot attack.
            canAttack = false;
            weapons.clear();
            targetAir = false;
            targetGround = false;

            // Large inventory.
            itemCapacity = 1000000;

            // Orange colour.
            outlineColor = Color.valueOf("ff7a00");

            // 10-block shield:
            // 1,000,000 shield HP
            // 100,000 HP/s regeneration.
            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                0f
            ));

            // Repairs friendly units and buildings
            // within 10 blocks for 100 HP/s.
            abilities.add(new RepairFieldAbility(
                100f,
                80f,
                1f
            ));
        }};
    }
}
