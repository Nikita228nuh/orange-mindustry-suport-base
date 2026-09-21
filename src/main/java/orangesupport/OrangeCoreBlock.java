package orangesupport;

import arc.util.Time;
import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        health = 1000;
        itemCapacity = 1000000;
        unitCapModifier = 50;

        size = 3;
        update = true;

        buildType = OrangeCoreBuild::new;
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        return tile != null;
    }

    public class OrangeCoreBuild extends CoreBuild {

        @Override
        public void updateTile() {
            super.updateTile();

            // 10 HP per second regeneration.
            if (health < maxHealth) {
                heal(10f * Time.delta / 60f);
            }
        }
    }
}