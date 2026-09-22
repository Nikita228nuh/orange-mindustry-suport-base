package orangesupport;

import mindustry.world.Block;

public class OrangeBlocks {

    public static Block orangeCore;

    public static void load() {
        orangeCore = new OrangeCoreBlock("orange-core");

        // Make it usable even without normal build requirements.
        orangeCore.requirements = new mindustry.type.ItemStack[0];
        orangeCore.buildTime = 1f;
        orangeCore.buildCostMultiplier = 0f;

        // Allow it to function on normal terrestrial planets.
        orangeCore.envEnabled = mindustry.world.meta.Env.terrestrial;
    }
}