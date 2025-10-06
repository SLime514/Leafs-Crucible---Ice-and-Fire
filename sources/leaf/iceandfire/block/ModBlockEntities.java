package leaf.iceandfire.block;

import java.util.Objects;
import java.util.function.BiFunction;
import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.block.type.TemperatureFurnaceBlockEntity;
import leaf.iceandfire.recipe.ModRecipes;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2378;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;

public class ModBlockEntities {
    public static class_2591<TemperatureFurnaceBlockEntity> TEMPERATURE_FURNACE_BLOCK_ENTITY;

    public static <T extends class_2586> class_2591<T> register(String id, BiFunction<class_2338, class_2680, T> factory, class_2248 block) {
        class_2378 class_2378Var = class_7923.field_41181;
        class_5321 class_5321VarMethod_29179 = class_5321.method_29179(class_7924.field_41255, class_2960.method_60655(LeafsCrucible.MOD_ID, id));
        Objects.requireNonNull(factory);
        return (class_2591) class_2378.method_39197(class_2378Var, class_5321VarMethod_29179, FabricBlockEntityTypeBuilder.create((v1, v2) -> {
            return r2.apply(v1, v2);
        }, new class_2248[]{block}).build());
    }

    public static void initialize() {
        System.out.println("模组方块实体正在加载...");
        if (TEMPERATURE_FURNACE_BLOCK_ENTITY == null) {
            TEMPERATURE_FURNACE_BLOCK_ENTITY = register(ModRecipes.TEMPERATURE_FURNACE_RECIPE_ID, TemperatureFurnaceBlockEntity::new, ModBlocks.TEMPERATURE_FURNACE);
        }
    }
}
