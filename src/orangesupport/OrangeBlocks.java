package orangesupport;

import mindustry.world.meta.BuildVisibility;
import mindustry.world.meta.Category;

public class OrangeBlocks {

    public static OrangeCoreBlock orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");

        orangeCore.category = Category.effect;
        orangeCore.buildVisibility = BuildVisibility.shown;
    }
}
