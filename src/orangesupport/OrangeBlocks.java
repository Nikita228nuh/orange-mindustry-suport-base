package orangesupport;

import mindustry.content.Blocks;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeBlocks {

    public static CoreBlock orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");

        // Put the Orange Core in the same category as vanilla cores.
        orangeCore.category = Blocks.coreShard.category;
    }
}