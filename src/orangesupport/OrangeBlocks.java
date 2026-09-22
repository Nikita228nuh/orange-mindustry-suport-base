package orangesupport;

import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeBlocks {

    public static CoreBlock orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");
    }
}