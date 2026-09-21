package orangesupport;

import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.TechTree;
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

            speed = 7.5f;
            health = 100000f;
            hitSize = 10f;

            playerControllable = true;
            logicControllable = true;

            canAttack = false;
            targetAir = false;
            targetGround = false;
            weapons.clear();

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

        orangeCore = new OrangeCoreBlock("orange-core") {{
            size = 3;
            health = 1000;
            itemCapacity = 1000000;
            unitCapModifier = 50;

            requirements = ItemStack.empty;
            buildVisibility = BuildVisibility.shown;
        }};

        // Put the Orange Core into the Serpulo tech tree.
        TechTree.node(Blocks.coreShard, () -> {

            TechTree.node(orangeCore, ItemStack.empty, () -> {

                // Orange unit is under the Orange Core.
                TechTree.node(orangeSupport, ItemStack.empty, () -> {});

            });
        });
    }
}