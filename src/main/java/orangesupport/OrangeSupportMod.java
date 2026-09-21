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

        // Orange player-controlled support unit.
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

            // FREE research.
            researchCostMultiplier = 0f;

            outlineColor = Color.valueOf("ff7a00");

            abilities.add(new ForceFieldAbility(
                80f,
                1666.6667f,
                1000000f,
                360f
            ));

            abilities.add(new OrangeRepairFieldAbility(100f, 80f));
        }};

        // Orange Core.
        orangeCore = new OrangeCoreBlock("orange-core") {{
            health = 1000;
            itemCapacity = 1000000;
            unitCapModifier = 50;

            // FREE to place.
            requirements = ItemStack.empty;

            buildVisibility = BuildVisibility.shown;
            alwaysUnlocked = true;

            size = 3;
        }};
    }

    @Override
    public void init() {
        super.init();

        // Put both items into the Serpulo tech tree.
        TechTree.node(Blocks.coreShard, () -> {
            TechTree.node(orangeCore, ItemStack.empty, () -> {
                TechTree.node(orangeSupport, ItemStack.empty, () -> {});
            });
        });
    }
}