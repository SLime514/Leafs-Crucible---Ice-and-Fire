package leaf.iceandfire.recipe;

import leaf.iceandfire.LeafsCrucible;
import net.minecraft.class_10355;
import net.minecraft.class_2378;
import net.minecraft.class_7923;

public class ModRecipeBookCategories {
    public static final class_10355 BATHING_FIRE_DROP_CATEGORY = register("bathing_fire_drop_category");
    public static final class_10355 BATHING_FIRE_CATEGORY = register("bathing_fire_category");

    public static class_10355 register(String id) {
        return (class_10355) class_2378.method_10226(class_7923.field_54927, id, new class_10355());
    }

    public static void initialize() {
        LeafsCrucible.LOGGER.info("模组配方分类正在加载...");
    }
}
