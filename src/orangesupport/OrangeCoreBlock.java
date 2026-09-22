package orangesupport;

import mindustry.type.ItemStack;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        size = 3;
        health = 5000;

        itemCapacity = 1000000;
        unitCapModifier = 50;

        requirements = ItemStack.empty;

        unitType = OrangeUnits.orangeSupport;
    }
}