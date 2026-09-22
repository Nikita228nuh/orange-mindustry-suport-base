

package orangesupport;

import arc.graphics.Color;
import mindustry.mod.Mod;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;

public class OrangeSupportMod extends Mod {

    public static Block orangeCore;

    @Override
    public void loadContent() {

        orangeCore = new Block("orange-core") {{
            size = 3;
            health = 1000;

            requirements = ItemStack.empty;

            category = Category.units;
            buildVisibility = BuildVisibility.shown;

            alwaysUnlocked = true;

            update = true;
        }};
    }
}

            