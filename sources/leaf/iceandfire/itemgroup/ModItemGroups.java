package leaf.iceandfire.itemgroup;

import leaf.iceandfire.LeafsCrucible;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7923;

public class ModItemGroups {
    public static void initialize() {
        LeafsCrucible.LOGGER.info("模组物品分类正在加载...");
        class_2378.method_10230(class_7923.field_44687, class_2960.method_60655(LeafsCrucible.MOD_ID, "bathing_fire_group"), BathingFireItemGroup.BATHING_FIRE_GROUP);
        class_2378.method_10230(class_7923.field_44687, class_2960.method_60655(LeafsCrucible.MOD_ID, "ice_group"), IceItemGroup.IceItemGroup);
        class_2378.method_10230(class_7923.field_44687, class_2960.method_60655(LeafsCrucible.MOD_ID, "obsidian_group"), ObsidianItemGroup.ObsidianItemGroup);
        class_2378.method_10230(class_7923.field_44687, class_2960.method_60655(LeafsCrucible.MOD_ID, "ruby_group"), RubyItemGroup.RUBY_GROUP);
    }
}
