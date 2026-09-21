package orangesupport;

import arc.util.Time;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);
        update = true;

        // Explicitly use the custom CoreBuild implementation.
        buildType = OrangeCoreBuild::new;
    }

    public class OrangeCoreBuild extends CoreBuild {

        @Override
        public void updateTile() {
            super.updateTile();

            // 10 HP per second.
            if(health < maxHealth) {
                heal(10f * Time.delta / 60f);
            }
        }
    }
}
