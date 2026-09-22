package orangesupport;

import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

public class OrangeSupportMod extends Mod {

    public static Block orangeTest;

    @Override
    public void loadContent() {

        orangeTest = new Block("orange-test") {{
            size = 3;
            health = 1000;

            category = Category.effect;
            buildVisibility = BuildVisibility.shown;

            requirements = new mindustry.type.ItemStack[0];
        }};
    }
}