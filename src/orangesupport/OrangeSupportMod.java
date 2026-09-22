package orangesupport;

import mindustry.mod.Mod;

public class OrangeSupportMod extends Mod {

    public static OrangeCoreBlock orangeCore;

    public OrangeSupportMod() {
    }

    @Override
    public void loadContent() {
        OrangeBlocks.load();
    }
}