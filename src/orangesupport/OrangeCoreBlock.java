package orangesupport;

import mindustry.game.Team;
import mindustry.type.ItemStack;
import mindustry.world.Tile;
import mindustry.world.blocks.storage.CoreBlock;

public class OrangeCoreBlock extends CoreBlock {

    public OrangeCoreBlock(String name) {
        super(name);

        size = 3;
        health = 5000f;

        itemCapacity = 1000000;

        unitCapModifier = 50;

        // No resources required to place it.
        requirements = ItemStack.empty;

        // Use our own support unit instead of Alpha.
        unitType = OrangeUnits.orangeSupport;
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        // Allow the Orange Core to be placed on normal buildable terrain.
        return tile != null && tile.block().isAir();
    }
}
