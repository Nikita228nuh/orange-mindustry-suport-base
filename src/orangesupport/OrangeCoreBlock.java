package orangesupport;

import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        size = 3;
        health = 1000;
        itemCapacity = 1000000;
        unitCapModifier = 50;

        // Free to place for testing.
        requirements = new mindustry.type.ItemStack[0];
    }
}