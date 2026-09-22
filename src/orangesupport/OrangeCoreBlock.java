package orangesupport;

import mindustry.type.ItemStack;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        // 6x6 core
        size = 6;

        // Core health
        health = 5000;

        // Large storage
        itemCapacity = 1000000;

        // Extra unit capacity
        unitCapModifier = 50;

        // Free to place
        requirements = ItemStack.empty;

        // Units produced/spawned by this core
        unitType = OrangeUnits.orangeSupport;
    }
}