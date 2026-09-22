package orangesupport;

import arc.util.Time;
import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        // Core stats
        health = 1000;
        size = 3;

        // Storage
        itemCapacity = 1000000;

        // Unit capacity
        unitCapModifier = 50;

        // Allow the block to update every tick
        update = true;

        // Use our custom building class
        buildType = OrangeCoreBuild::new;
    }

    /*
     * Allow placement on any valid tile.
     * There is no Serpulo-only restriction here.
     */
    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        return tile != null;
    }

    public class OrangeCoreBuild extends CoreBuild {

        @Override
        public void updateTile() {
            super.updateTile();

            // Regenerate 10 HP per second.
            if (health < maxHealth) {
                heal(10f * Time.delta / 60f);
            }
        }
    }
}
