package orangesupport;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.UnitEntity;
import mindustry.mod.Mod;
import mindustry.type.UnitType;
import mindustry.world.blocks.storage.CoreBlock;

import static mindustry.Vars.content;
import static mindustry.Vars.tilesize;

public class OrangeSupportMod extends Mod {

    public static UnitType orangeSupport;
    public static CoreBlock orangeCore;

    @Override
    public void loadContent() {
        orangeSupport = new UnitType("orange-support") {{
            constructor = UnitEntity::create;

            // 60 blocks/second = 60 * 8 world-units/second / 60 ticks = 8 world-units/tick.
            speed = 8f;

            // Ten tiles across as the requested large unit size.
            hitSize = 10f * tilesize;

            health = 100_000f;

            // Very fast building and mining.
            buildSpeed = 1000f;
            buildRange = 10f * tilesize;
            mineSpeed = 1000f;
            mineRange = 10f * tilesize;
            mineTier = 999;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;

            // No attacking.
            canAttack = false;
            weapons.clear();
            targetAir = false;
            targetGround = false;
            autoFindTarget = false;

            playerControllable = true;
            logicControllable = true;
            useUnitCap = true;

            itemCapacity = 10_000;

            // Orange visuals.
            outlineColor = Color.valueOf("ff7a00");
            shieldColor = Color.valueOf("ff7a00");
            healColor = Color.valueOf("ff7a00");

            // 10-block radius; 1,000,000 shield HP; 100,000 HP/s regeneration.
            abilities.add(new ForceFieldAbility(
                10f * tilesize,
                100_000f / 60f,
                1_000_000f,
                0f
            ));

            // Repairs units AND buildings.
            abilities.add(new OrangeRepairFieldAbility(
                100f,
                10f * tilesize
            ));

            // Fill the mine target list with every item available in this game build.
            // Only actual mineable ores will be usable by the mining system.
            mineItems = new Seq<>();
            mineItems.addAll(content.items());
        }};

        orangeCore = new OrangeCoreBlock("orange-core");
        orangeCore.unitType = orangeSupport;
        orangeCore.health = 1000f;
        orangeCore.itemCapacity = 1_000_000;
        orangeCore.unitCapModifier = 50;
        orangeCore.size = 3;
        orangeCore.requirements = new mindustry.type.ItemStack[] {
            new mindustry.type.ItemStack(Items.copper, 1)
        };
        orangeCore.buildVisibility = mindustry.world.meta.BuildVisibility.shown;
        orangeCore.category = mindustry.world.meta.Category.effect;
        orangeCore.alwaysUnlocked = true;
        orangeCore.localizedName = "Orange Support Core";
        orangeCore.description = "Spawns the player-controlled Orange Support unit.";
    }
}
