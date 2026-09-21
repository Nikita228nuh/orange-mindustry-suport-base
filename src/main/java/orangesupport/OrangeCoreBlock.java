package orangesupport;

import arc.util.Time;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        update = true;
        health = 1000;
        itemCapacity = 1000000;
        unitCapModifier = 50;
    }

    @Override
    public Building createBuilding() {
        return new OrangeCoreBuild();
    }

    public class OrangeCoreBuild extends CoreBuild {

        @Override
        public void updateTile() {
            super.updateTile();

            // Regenerates 10 HP every second.
            if (health < maxHealth) {
                heal(10f * Time.delta / 60f);
            }
        }
    }
}
