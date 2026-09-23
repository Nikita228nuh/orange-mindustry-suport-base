package orangesupport;

import arc.graphics.Color;
import arc.graphics.g2d.Drawf;
import arc.math.geom.Rect;
import arc.struct.Seq;
import arc.util.Time;

import mindustry.Vars;
import mindustry.content.Category;
import mindustry.content.Items;
import mindustry.gen.Building;
import mindustry.mod.Mod;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class OrangeSupportMod extends Mod {

    public static OrangeAutoFiller autoFiller;

    public OrangeSupportMod() {
    }

    @Override
    public void loadContent() {

        autoFiller = new OrangeAutoFiller("orange-auto-filler");

        autoFiller.localizedName = "Orange Auto Filler";
        autoFiller.description =
                "Automatically supplies nearby buildings with accepted items, liquids and power.";

        autoFiller.size = 3;

        autoFiller.hasItems = true;
        autoFiller.hasLiquids = true;

        autoFiller.itemCapacity = 100000;
        autoFiller.liquidCapacity = 100000f;

        autoFiller.range = 40f * Vars.tilesize;

        autoFiller.health = 1000000;

        autoFiller.consumesPower = false;
        autoFiller.outputsPower = true;

        autoFiller.powerProduction = 100000f;

        autoFiller.buildType = autoFiller::new OrangeAutoFillerBuild;
    }

    public static class OrangeAutoFiller extends Block {

        public float range = 320f;

        public float powerProduction = 100000f;

        public OrangeAutoFiller(String name) {
            super(name);

            update = true;
            solid = true;
            destructible = true;

            hasItems = true;
            hasLiquids = true;

            itemCapacity = 100000;
            liquidCapacity = 100000f;

            configurable = false;
            canOverdrive = false;

            size = 3;
            health = 1000000;

            requirements(
                    Category.effect,
                    ItemStack.with(
                            Items.copper, 50,
                            Items.lead, 50,
                            Items.silicon, 25
                    )
            );
        }

        @Override
        public void setStats() {
            super.setStats();

            stats.add(
                    Stat.range,
                    range / Vars.tilesize,
                    StatUnit.blocks
            );
        }

        public class OrangeAutoFillerBuild extends mindustry.gen.Building {

            private final Seq<Building> targets = new Seq<>();

            private int lastTileChanges = -1;

            @Override
            public void updateTile() {

                if (Vars.world == null) return;

                if (lastTileChanges != Vars.world.tileChanges) {

                    lastTileChanges = Vars.world.tileChanges;

                    targets.clear();

                    Rect rect = new Rect(
                            x - range,
                            y - range,
                            range * 2f,
                            range * 2f
                    );

                    Vars.indexer.eachBlock(
                            team,
                            rect,
                            b -> b != this && b.block != autoFiller,
                            targets::add
                    );
                }

                // Process every 5 ticks.
                if (!timer.get(0, 5f)) return;

                for (int i = 0; i < targets.size; i++) {

                    Building target = targets.get(i);

                    if (target == null) continue;
                    if (target.dead