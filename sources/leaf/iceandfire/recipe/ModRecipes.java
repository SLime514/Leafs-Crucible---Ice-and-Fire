package leaf.iceandfire.recipe;

import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.recipe.BathingFireDropRecipeType;
import leaf.iceandfire.recipe.bathingfire.BathingFireRecipe;
import net.minecraft.class_1860;
import net.minecraft.class_1865;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3956;
import net.minecraft.class_7923;

public class ModRecipes {
    public static final String TEMPERATURE_FURNACE_RECIPE_ID = "temperature_furnace";
    public static final class_3956<TemperatureFurnaceRecipe> TEMPERATURE_FURNACE_RECIPE_TYPE = registerRecipeType(TEMPERATURE_FURNACE_RECIPE_ID);
    public static final class_1865<TemperatureFurnaceRecipe> TEMPERATURE_FURNACE_RECIPE_SERIALIZER = registerRecipeSerializer(TEMPERATURE_FURNACE_RECIPE_ID, TemperatureFurnaceRecipeSerializer.INSTANCE);
    public static final String BATHING_FIRE_DROP_RECIPE_ID = "bathing_fire_drop";
    public static final class_3956<BathingFireDropRecipeType> BATHING_FIRE_DROP_RECIPE_TYPE = registerRecipeType(BATHING_FIRE_DROP_RECIPE_ID);
    public static final class_1865<BathingFireDropRecipeType> BATHING_FIRE_DROP_RECIPE_SERIALIZER = registerRecipeSerializer(BATHING_FIRE_DROP_RECIPE_ID, BathingFireDropRecipeType.Serializer.INSTANCE);
    public static final String BATHING_FIRE_RECIPE_ID = "bathing_fire";
    public static final class_3956<BathingFireRecipe> BATHING_FIRE_RECIPE_TYPE = registerRecipeType(BATHING_FIRE_RECIPE_ID);
    public static final class_1865<BathingFireRecipe> BATHING_FIRE_RECIPE_SERIALIZER = registerRecipeSerializer(BATHING_FIRE_RECIPE_ID, BathingFireRecipe.Serializer.INSTANCE);

    public static <T extends class_1860<?>> class_3956<T> registerRecipeType(final String name) {
        return (class_3956) class_2378.method_10230(class_7923.field_41188, class_2960.method_60655(LeafsCrucible.MOD_ID, name), new class_3956<T>() {
            public String toString() {
                return class_2960.method_60655(LeafsCrucible.MOD_ID, name).toString();
            }
        });
    }

    public static <T extends class_1860<?>> class_1865<T> registerRecipeSerializer(String name, class_1865<T> serializer) {
        return class_1865.method_17724(class_2960.method_60655(LeafsCrucible.MOD_ID, name).toString(), serializer);
    }

    public static void initialize() {
        LeafsCrucible.LOGGER.info("模组配方加载中...");
    }
}
