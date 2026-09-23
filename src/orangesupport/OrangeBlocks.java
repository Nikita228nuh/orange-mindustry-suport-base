package orangesupport;

import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

public class OrangeBlocks {

    public static Block orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");

        // Make it appear in the build menu.
        orangeCore.buildVisibility = BuildVisibility.shown;
    }
}