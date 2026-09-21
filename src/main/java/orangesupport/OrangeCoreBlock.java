package orangesupport;

import arc.util.Time;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        health = 1000;
        itemCapacity = 1000000;
        unitCapModifier = 50;

        // 3 x 3 core
        size = 3;

        update = true;

        buildType = OrangeCoreBuild::new;
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
