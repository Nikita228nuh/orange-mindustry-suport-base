package orangesupport;

import mindustry.mod.Mod;

public class OrangeSupportMod extends Mod {

    public OrangeSupportMod() {
    }

    @Override
    public void loadContent() {
        OrangeBlocks.load();
    }
}
