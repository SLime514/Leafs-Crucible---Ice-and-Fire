package leaf.iceandfire.screen;

import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.recipe.ModRecipes;
import leaf.iceandfire.screen.type.TemperatureFurnaceScreenHandler;
import net.minecraft.class_1703;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3917;
import net.minecraft.class_5321;
import net.minecraft.class_7701;
import net.minecraft.class_7923;
import net.minecraft.class_7924;

public class ModScreenHandlers {
    public static class_3917<TemperatureFurnaceScreenHandler> TEMPERATURE_FURNACE_SCREEN_HANDLER = register(ModRecipes.TEMPERATURE_FURNACE_RECIPE_ID, TemperatureFurnaceScreenHandler::new);

    public static <T extends class_1703> class_3917<T> register(String id, class_3917.class_3918<T> factory) {
        return (class_3917) class_2378.method_39197(class_7923.field_41187, class_5321.method_29179(class_7924.field_41207, class_2960.method_60655(LeafsCrucible.MOD_ID, id)), new class_3917(factory, class_7701.field_40182));
    }

    public static void initialize() {
        System.out.println("模组ScreenHandler正在加载...");
        if (TEMPERATURE_FURNACE_SCREEN_HANDLER == null) {
            System.out.println("模组ScreenHandler正在注册...");
            TEMPERATURE_FURNACE_SCREEN_HANDLER = register(ModRecipes.TEMPERATURE_FURNACE_RECIPE_ID, TemperatureFurnaceScreenHandler::new);
        }
    }
}
