package orangesupport;

import mindustry.mod.Mod;

public class OrangeSupportMod extends Mod {

    @Override
    public void loadContent() {
        OrangeUnits.load();
        OrangeBlocks.load();
        OrangeTechTree.load();
    }
}
