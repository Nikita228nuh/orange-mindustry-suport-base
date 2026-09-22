package orangesupport;

import mindustry.type.Category;

public class OrangeBlocks {

    public static OrangeCoreBlock orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");

        // Put the core in the build menu.
        orangeCore.category = Category.effect;

        // No items required to build it.
        orangeCore.requirements = new mindustry.type.ItemStack[0];

        // Make it visible without research.
        orangeCore.alwaysUnlocked = true;
    }
}
