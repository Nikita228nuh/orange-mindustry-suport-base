package orangesupport;

import mindustry.content.Category;

public class OrangeBlocks {

    public static OrangeCoreBlock orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");

        // Make the block available in the build menu.
        orangeCore.category = Category.effect;
    }
}
