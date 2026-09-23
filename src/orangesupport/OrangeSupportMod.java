package orangesupport;

import arc.Core;
import arc.graphics.Color;
import arc.math.geom.Rect;
import arc.struct.Seq;
import arc.util.Time;

import mindustry.Vars;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Building;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.Item;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;
import mindustry.graphics.Drawf;

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

        autoFiller.health = 1000000f;

        autoFiller.consumesPower = false;
        autoFiller.outputsPower = true;
        autoFiller.powerProduction = 100000f;

        autoFiller.buildType = () -> autoFiller.new OrangeAutoFillerBuild();
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
            health = 1000000f;

            requirements(
                    Category.effect,
                    ItemStack.with(
                            Items.copper, 50,
                            Items.lead, 50,
                            Items.silicon, 25
                    )
            );

            buildType = () -> new OrangeAutoFillerBuild();
        }

        @Override
        public void setStats() {
            super.setStats();

            stats.add(
                    Stat.range,
                    range / Vars.tilesize,
                    StatUnit.blocks
            );

            stats.add(
                    Stat.powerGeneration,
                    powerProduction,
                    StatUnit.powerSecond
            );
        }

        public class OrangeAutoFillerBuild extends mindustry.gen.Building {

            private final Seq<Building> targets = new Seq<>();

            private int lastTileChanges = -1;

            @Override
            public void updateTile() {

                if (Vars.world == null) return;

                // Rebuild nearby building list whenever the world changes.
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
                    if (target.dead) continue;
                    if (target.team != team) continue;

                    fillItems(target);
                    fillLiquids(target);
                    givePower(target);
                }
            }

            private void fillItems(Building target) {

                if (!target.block.hasItems) return;
                if (target.items == null) return;

                for (Item item : Vars.content.items()) {

                    if (!target.block.consumesItem(item))
                        continue;

                    float capacity = target.block.itemCapacity;

                    try {
                        capacity = target.getMaximumAccepted(item);
                    } catch (Throwable ignored) {
                    }

                    if (capacity <= 0f) {
                        capacity = target.block.itemCapacity;
                    }

                    float current = target.items.get(item);
                    float amount = capacity - current;

                    if (amount <= 0f)
                        continue;

                    amount = Math.min(amount, 1000f);

                    target.items.add(item, amount);
                }
            }

            private void fillLiquids(Building target) {

                if (!target.block.hasLiquids) return;
                if (target.liquids == null) return;

                for (Liquid liquid : Vars.content.liquids()) {

                    boolean accepted;

                    try {
                        accepted = target.block.consumesLiquid(liquid);
                    } catch (Throwable ignored) {
                        accepted = false;
                    }

                    if (!accepted)
                        continue;

                    float current = target.liquids.get(liquid);

                    float amount =
                            target.block.liquidCapacity - current;

                    if (amount <= 0.01f)
                        continue;

                    amount = Math.min(amount, 1000f);

                    try {
                        target.handleLiquid(
                                this,
                                liquid,
                                amount
                        );
                    } catch (Throwable ignored) {
                    }
                }
            }

            private void givePower(Building target) {

                if (!target.block.consumesPower)
                    return;

                if (target.power == null)
                    return;

                try {
                    target.power.status = 1f;

                    if (target.power.graph != null) {
                        target.power.graph.transferPower(
                                powerProduction * Time.delta
                        );
                    }

                } catch (Throwable ignored) {
                }
            }

            @Override
            public void drawSelect() {

                Drawf.dashSquare(
                        Color.valueOf("ff8a00"),
                        x,
                        y,
                        range * 2f
                );
            }

            @Override
            public void draw() {

                super.draw();

                Drawf.dashSquare(
                        Color.valueOf("ff8a00"),
                        x,
                        y,
                        range * 2f
                );
            }
        }
    }
}