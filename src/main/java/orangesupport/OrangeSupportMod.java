package orangesupport;

import arc.graphics.Color;
import mindustry.content.TechTree;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;
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

            // 100,000 HP
            health = 100000f;

            // Very fast movement
            speed = 7.5f;

            // 10-block size
            hitSize = 10f;

            // Player controlled
            playerControllable = true;
            logicControllable = true;

            // No attacking
            canAttack = false;
            targetAir = false;
            targetGround = false;
            weapons.clear();

            // Very fast building
            buildSpeed = 1000f;
            buildRange = 80f;

            // Very fast mining
            mineSpeed = 1000f;
            mineTier = 999;
            mineRange = 80f;
            mineWalls = true;
            mineFloor = true;

            // 1,000,000 inventory
            itemCapacity = 1000000;

            // Orange
            outlineColor = Color.valueOf("ff7a00");

            // Free research
            researchCostMultiplier = 0f;

            // 1,000,000 shield
            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                360f
            ));

            // Repair field
            abilities.add(
                new OrangeRepairFieldAbility(100f, 80f)
            );

            // Always unlocked
            alwaysUnlocked = true;
        }};


        // =========================
        // ORANGE CORE
        // =========================

        orangeCore = new OrangeCoreBlock("orange-core") {{

            // 3 x 3
            size = 3;

            // 1000 HP
            health = 1000;

            // 1,000,000 storage
            itemCapacity = 1000000;

            // +50 unit capacity
            unitCapModifier = 50;

            // FREE
            requirements = ItemStack.empty;

            // Show in build menu
            buildVisibility = BuildVisibility.shown;

            // Always unlocked
            alwaysUnlocked = true;

            // The Orange Support unit comes from this core
            unitType = orangeSupport;
        }};


        // =========================
        // RESEARCH TREE
        // =========================

        TechTree.node(orangeCore, ItemStack.empty, () -> {
            TechTree.node(orangeSupport, ItemStack.empty, () -> {});
        });
    }
}

            