package leaf.iceandfire.block;

import com.google.common.collect.UnmodifiableIterator;
import java.util.function.Function;
import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.block.type.MagmaRockBlock;
import leaf.iceandfire.block.type.SoulLavaBlock;
import leaf.iceandfire.block.type.TemperatureFurnaceBlock;
import leaf.iceandfire.component.ModComponentTypes;
import leaf.iceandfire.recipe.ModRecipes;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2378;
import net.minecraft.class_2680;
import net.minecraft.class_2766;
import net.minecraft.class_2960;
import net.minecraft.class_3620;
import net.minecraft.class_4970;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;

public class ModBlocks {
    public static final class_2248 MAGMA_ROCK = register("magma_rock", (Function<class_4970.class_2251, class_2248>) MagmaRockBlock::new, class_4970.class_2251.method_9637().method_31710(class_3620.field_16023).method_51368(class_2766.field_12653).method_29292().method_9629(1.5f, 6.0f));
    public static final class_1792 MAGMA_ROCK_ITEM = class_1802.method_7992(MAGMA_ROCK, new class_1792.class_1793().method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(ModComponentTypes.TEMPERATURE, 1));
    public static final class_2248 TEMPERATURE_FURNACE = register(ModRecipes.TEMPERATURE_FURNACE_RECIPE_ID, (Function<class_4970.class_2251, class_2248>) TemperatureFurnaceBlock::new, class_4970.class_2251.method_9630(class_2246.field_10181));
    public static final class_1792 TEMPERATURE_FURNACE_ITEM = class_1802.method_7992(TEMPERATURE_FURNACE, new class_1792.class_1793().method_24359());
    public static final class_2248 NETHER_RUBY_ORE = register("nether_ruby_ore", class_4970.class_2251.method_9637().method_31710(class_3620.field_16012).method_29292().method_9629(3.0f, 3.0f));
    public static final class_1792 NETHER_RUBY_ORE_ITEM = class_1802.method_7992(NETHER_RUBY_ORE, new class_1792.class_1793().method_24359());
    public static final class_2248 RUBY_BLOCK = register("ruby_block", class_4970.class_2251.method_9637().method_31710(class_3620.field_16012).method_29292().method_9629(3.0f, 3.0f));
    public static final class_1792 RUBY_BLOCK_ITEM = class_1802.method_7992(RUBY_BLOCK, new class_1792.class_1793().method_24359());
    public static final class_2248 NETHER_IRON_ORE = register("nether_iron_ore", class_4970.class_2251.method_9637().method_31710(class_3620.field_16005).method_29292().method_9629(3.0f, 3.0f));
    public static final class_1792 NETHER_IRON_ORE_ITEM = class_1802.method_7992(NETHER_IRON_ORE, new class_1792.class_1793().method_24359());
    public static final class_2248 SOUL_LAVA = register("soul_lava", (Function<class_4970.class_2251, class_2248>) SoulLavaBlock::new, class_4970.class_2251.method_9630(class_2246.field_10164));

    static {
        for (class_2248 block : class_7923.field_41175) {
            UnmodifiableIterator it = block.method_9595().method_11662().iterator();
            while (it.hasNext()) {
                class_2680 blockState = (class_2680) it.next();
                class_2248.field_10651.method_10205(blockState);
                blockState.method_26200();
            }
        }
    }

    public static class_2248 register(class_5321<class_2248> key, Function<class_4970.class_2251, class_2248> factory, class_4970.class_2251 settings) {
        class_2248 block = factory.apply(settings.method_63500(key));
        return (class_2248) class_2378.method_39197(class_7923.field_41175, key, block);
    }

    public static class_2248 register(class_5321<class_2248> key, class_4970.class_2251 settings) {
        return register(key, (Function<class_4970.class_2251, class_2248>) class_2248::new, settings);
    }

    private static class_5321<class_2248> keyOf(String id) {
        return class_5321.method_29179(class_7924.field_41254, class_2960.method_60655(LeafsCrucible.MOD_ID, id));
    }

    private static class_2248 register(String id, Function<class_4970.class_2251, class_2248> factory, class_4970.class_2251 settings) {
        return register(keyOf(id), factory, settings);
    }

    private static class_2248 register(String id, class_4970.class_2251 settings) {
        return register(id, (Function<class_4970.class_2251, class_2248>) class_2248::new, settings);
    }

    public static void initialize() {
        LeafsCrucible.LOGGER.info("模组方块正在加载...");
    }
}
