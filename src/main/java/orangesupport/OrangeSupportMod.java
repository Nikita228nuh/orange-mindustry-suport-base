package orangesupport;

import arc.graphics.Color;
import mindustry.content.TechTree;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Category;

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

            researchCostMultiplier = 0f;

            outlineColor = Color.valueOf("ff7a00");

            // Large shield
            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                360f
            ));

            // Repair nearby units/buildings
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

            // Free to build
            requirements = ItemStack.empty;

            // SHOW IN BUILD MENU
            buildVisibility = BuildVisibility.shown;

            // Put it in the Blocks > Units category
            category = Category.units;

            // No research needed
            alwaysUnlocked = true;

            // This core produces the Orange Support unit
            unitType = orangeSupport;
        }};


        // =========================
        // TECH TREE
        // =========================

        TechTree.node(orangeCore, ItemStack.empty, () -> {
            TechTree.node(orangeSupport, ItemStack.empty, () -> {});
        });
    }
}

            