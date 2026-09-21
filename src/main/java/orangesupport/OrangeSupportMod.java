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

            speed = 1f;
            hitSize = 10f;
            health = 100000f;

            playerControllable = true;
            logicControllable = true;

            canAttack = false;
            targetAir = false;
            targetGround = false;

            buildSpeed = 1000f;
            buildRange = 80f;

            mineSpeed = 1000f;
            mineTier = 999;
            mineRange = 80f;

            itemCapacity = 1000000;

            outlineColor = Color.valueOf("ff7a00");

            immunities = mindustry.content.StatusEffects.values();

            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                360f
            ));

            abilities.add(
                new OrangeRepairFieldAbility(100f, 80f)
            );
        }};
    }
}
