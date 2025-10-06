package leaf.iceandfire.material;

import java.util.Map;
import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.recipe.ModRecipes;
import net.minecraft.class_10191;
import net.minecraft.class_1741;
import net.minecraft.class_2960;
import net.minecraft.class_3417;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;
import net.minecraft.class_8051;
import net.minecraft.class_9886;

public class ModMaterials {
    public static final class_9886 MAGMA_TOOL = new class_9886(class_6862.method_40092(class_7924.field_41254, class_2960.method_60655(LeafsCrucible.MOD_ID, "incorrect_for_magma_tool")), 1500, 8.0f, 5.0f, 1, class_6862.method_40092(class_7924.field_41197, class_2960.method_60655(LeafsCrucible.MOD_ID, "magma_tool_repair_items")));
    public static final class_9886 FROST_TOOL = new class_9886(class_6862.method_40092(class_7924.field_41254, class_2960.method_60655(LeafsCrucible.MOD_ID, "incorrect_for_frost_tool")), 5000, 10.0f, 3.0f, 6, class_6862.method_40092(class_7924.field_41197, class_2960.method_60655(LeafsCrucible.MOD_ID, "frost_tool_repair_items")));
    public static final class_9886 RUBY_TOOL = new class_9886(class_6862.method_40092(class_7924.field_41254, class_2960.method_60655(LeafsCrucible.MOD_ID, "incorrect_for_ruby_tool")), 10000, 12.0f, 5.0f, 15, class_6862.method_40092(class_7924.field_41197, class_2960.method_60655(LeafsCrucible.MOD_ID, "ruby_tool_repair_items")));
    public static final class_1741 OBSIDIAN_ARMOR = new class_1741(50000, Map.of(class_8051.field_41937, 4, class_8051.field_41936, 8, class_8051.field_41935, 11, class_8051.field_41934, 6), 10, class_3417.field_14862, 4.0f, 10.0f, class_6862.method_40092(class_7924.field_41197, class_2960.method_60655(LeafsCrucible.MOD_ID, "obsidian_armor_repair_items")), class_5321.method_29179(class_10191.field_55214, class_2960.method_60655(LeafsCrucible.MOD_ID, "obsidian")));
    public static final class_1741 BATHING_FIRE_ARMOR = new class_1741(15, Map.of(class_8051.field_41937, 3, class_8051.field_41936, 6, class_8051.field_41935, 8, class_8051.field_41934, 4), 25, class_3417.field_14761, 1.0f, 0.0f, class_6862.method_40092(class_7924.field_41197, class_2960.method_60655(LeafsCrucible.MOD_ID, "magma_tool_repair_items")), class_5321.method_29179(class_10191.field_55214, class_2960.method_60655(LeafsCrucible.MOD_ID, ModRecipes.BATHING_FIRE_RECIPE_ID)));
    public static final class_1741 RUBY_ARMOR = new class_1741(5000, Map.of(class_8051.field_41937, 2, class_8051.field_41936, 5, class_8051.field_41935, 7, class_8051.field_41934, 3), 10, class_3417.field_14862, 1.0f, 0.0f, class_6862.method_40092(class_7924.field_41197, class_2960.method_60655(LeafsCrucible.MOD_ID, "ruby_armor_repair_items")), class_5321.method_29179(class_10191.field_55214, class_2960.method_60655(LeafsCrucible.MOD_ID, "ruby")));

    public static void initialize() {
    }
}
