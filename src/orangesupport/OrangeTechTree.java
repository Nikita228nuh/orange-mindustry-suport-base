package orangesupport;

import mindustry.content.Items;
import mindustry.content.TechTree;
import mindustry.type.ItemStack;

public class OrangeTechTree {

    public static void load() {

        // Add Orange Core to the Serpulo research tree.
        //
        // It appears after researching the Core Foundation.
        // Change the requirements below if you want a different cost.

        TechTree.node(
            mindustry.content.Blocks.coreFoundation,
            () -> {
                TechTree.node(
                    OrangeBlocks.orangeCore,
                    ItemStack.with(
                        Items.copper, 500,
                        Items.lead, 500,
                        Items.silicon, 200
                    ),
                    () -> {
                    }
                );
            }
        );
    }
}
