package leaf.iceandfire.recipe;

import leaf.iceandfire.block.ModBlocks;
import net.minecraft.class_10355;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1856;
import net.minecraft.class_1865;
import net.minecraft.class_1874;
import net.minecraft.class_1937;
import net.minecraft.class_314;
import net.minecraft.class_3956;
import net.minecraft.class_5455;
import net.minecraft.class_7709;
import net.minecraft.class_9696;

public class TemperatureFurnaceRecipe extends class_1874 {
    private final int temperature;
    public class_1799 result;
    public class_1856 input;

    public static class Type implements class_3956<TemperatureFurnaceRecipe> {
        public static final Type INSTANCE = new Type();
    }

    public TemperatureFurnaceRecipe(String group, class_1856 input, class_1799 output, float experience, int temperature) {
        super(group, class_7709.field_40244, input, output, experience, 0);
        this.result = output;
        this.input = input;
        this.temperature = temperature;
    }

    public class_3956<? extends class_1874> method_17716() {
        return ModRecipes.TEMPERATURE_FURNACE_RECIPE_TYPE;
    }

    public class_10355 method_64668() {
        return class_314.field_17112;
    }

    protected class_1792 method_64663() {
        return ModBlocks.TEMPERATURE_FURNACE_ITEM;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public class_1865<? extends class_1874> method_8119() {
        return TemperatureFurnaceRecipeSerializer.INSTANCE;
    }

    public Object getOutput(class_5455 registryManager) {
        return this.result;
    }

    public boolean equals(Object o) {
        return super/*java.lang.Object*/.equals(o);
    }

    public boolean method_8115(class_9696 inventory, class_1937 world) {
        class_1799 inputStack = inventory.method_59984(0);
        boolean result = method_64720().method_8093(inputStack);
        return result;
    }
}
