package orangesupport;

import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        // Custom stats
        health = 1000;
        itemCapacity = 1000000;
        unitCapModifier = 50;
        size = 3;
    }
}