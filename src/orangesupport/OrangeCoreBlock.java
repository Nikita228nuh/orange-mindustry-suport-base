package orangesupport;

import mindustry.type.ItemStack;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        size = 3;
        health = 5000;

        // No custom healing here.
        // The normal Mindustry CoreBlock handles core behavior.

        unitType = OrangeUnits.orangeSupport;

        requirements = ItemStack.empty;
    }
}
