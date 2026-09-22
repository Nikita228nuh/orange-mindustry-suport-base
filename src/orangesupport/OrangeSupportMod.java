package orangesupport;

import mindustry.mod.Mod;

public class OrangeSupportMod extends Mod {

    public static OrangeCoreBlock orangeCore;

    @Override
    public void loadContent() {
        orangeCore = new OrangeCoreBlock("orange-core");
    }
}