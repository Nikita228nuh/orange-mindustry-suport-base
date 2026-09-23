package orangesupport;

import mindustry.type.ItemStack;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        // 6x6 core
        size = 6;

        // Core settings
        health = 10000;
        itemCapacity = 1000000;
        unitCapModifier = 50;

        // Free to build
        requirements = ItemStack.empty;

        // This core produces the Orange Support unit.
        unitType = OrangeUnits.orangeSupport;
    }
}