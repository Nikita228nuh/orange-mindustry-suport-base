package orangesupport;

import arc.graphics.Color;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

public class OrangeSupportMod extends Mod {

    public static UnitType orangeSupport;
    public static Block orangeCore;

    @Override
    public void loadContent() {

        orangeSupport = new UnitType("orange-support") {{
            constructor = UnitEntity::create;

            speed = 60f / 8f;
            health = 100000f;
            hitSize = 10f;

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
            mineWalls = true;
            mineFloor = true;

            itemCapacity = 1000000;

            outlineColor = Color.valueOf("ff7a00");

            // Free research.
            researchCostMultiplier = 0f;

            // Large shield.
            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                360f
            ));

            // Repairs nearby friendly units/buildings.
            abilities.add(new OrangeRepairFieldAbility(100f, 80f));

            // Make unit immediately available.
            hidden = false;
        }};

        orangeCore = new OrangeCoreBlock("orange-core") {{
            size = 3;

            health = 1000;
            itemCapacity = 1000000;
            unitCapModifier = 50;

            // Completely free to build.
            requirements = ItemStack.empty;

            // Show in build menu.
            buildVisibility = BuildVisibility.shown;

            // No research required.
            alwaysUnlocked = true;
        }};
    }
}