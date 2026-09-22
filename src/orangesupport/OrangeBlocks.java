package orangesupport;

import mindustry.world.Block;

public class OrangeBlocks {

    public static Block orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");
    }
}