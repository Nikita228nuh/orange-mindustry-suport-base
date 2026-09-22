package orangesupport;

import arc.graphics.Color;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

public class OrangeSupportMod extends Mod {

    public static UnitType orangeSupport;
    public static Block orangeCore;

    @Override
    public void loadContent() {

        // =========================
        // ORANGE SUPPORT UNIT
        // =========================

        orangeSupport = new UnitType("orange-support") {{
            constructor = UnitEntity::create;

            health = 100000f;
            speed = 7.5f;
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

            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                360f
            ));

            abilities.add(
                new OrangeRepairFieldAbility(100f, 80f)
            );

            alwaysUnlocked = true;
        }};


        // =========================
        // ORANGE CORE
        // =========================

        orangeCore = new OrangeCoreBlock("orange-core") {{
            size = 3;

            health = 1000;

            itemCapacity = 1000000;
            unitCapModifier = 50;

            // FREE TO PLACE
            requirements = ItemStack.empty;

            // SHOW IN BUILD MENU
            buildVisibility = BuildVisibility.shown;

            // PUT IT IN THE EFFECT / ETC. MENU
            category = Category.effect;

            // NO RESEARCH REQUIRED
            alwaysUnlocked = true;

            // PRODUCES THE ORANGE SUPPORT UNIT
            unitType = orangeSupport;
        }};
    }
}

            