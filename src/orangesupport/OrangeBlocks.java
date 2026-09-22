package orangesupport;

import mindustry.content.ContentList;

public class OrangeBlocks implements ContentList {

    public static OrangeCoreBlock orangeCore;

    @Override
    public void load() {
        orangeCore = new OrangeCoreBlock("orange-core");
    }
}
