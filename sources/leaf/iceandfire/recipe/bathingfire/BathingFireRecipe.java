package leaf.iceandfire.recipe.bathingfire;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import leaf.iceandfire.recipe.ModRecipeBookCategories;
import leaf.iceandfire.recipe.ModRecipes;
import net.minecraft.class_10355;
import net.minecraft.class_1799;
import net.minecraft.class_1856;
import net.minecraft.class_1860;
import net.minecraft.class_1865;
import net.minecraft.class_1937;
import net.minecraft.class_3956;
import net.minecraft.class_7225;
import net.minecraft.class_9129;
import net.minecraft.class_9139;
import net.minecraft.class_9887;

public class BathingFireRecipe implements class_1860<BathingFireRecipeInput> {
    class_1799 originalItem;
    class_1799 result;

    public class_1799 getOriginalItem() {
        return this.originalItem;
    }

    public class_1799 getResult() {
        return this.result;
    }

    public BathingFireRecipe(class_1799 originalItem, class_1799 result) {
        this.originalItem = originalItem;
        this.result = result;
    }

    public boolean method_8115(BathingFireRecipeInput input, class_1937 world) {
        return this.originalItem.method_7909() == input.method_59984(0).method_7909();
    }

    public class_1799 method_8116(BathingFireRecipeInput input, class_7225.class_7874 registries) {
        return this.result.method_7972();
    }

    public class_1865<? extends class_1860<BathingFireRecipeInput>> method_8119() {
        return Serializer.INSTANCE;
    }

    public class_3956<? extends class_1860<BathingFireRecipeInput>> method_17716() {
        return ModRecipes.BATHING_FIRE_RECIPE_TYPE;
    }

    public class_9887 method_61671() {
        return class_9887.method_61686(List.of(class_1856.method_8101(this.originalItem.method_7909()), class_1856.method_8101(this.result.method_7909())));
    }

    public class_10355 method_64668() {
        return ModRecipeBookCategories.BATHING_FIRE_CATEGORY;
    }

    public String toString() {
        return "BathingFireRecipe{originalItem=" + String.valueOf(this.originalItem) + ", result=" + String.valueOf(this.result) + "}";
    }

    public static class Serializer implements class_1865<BathingFireRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        private final MapCodec<BathingFireRecipe> CODEC = RecordCodecBuilder.mapCodec(bathingFireRecipeInstance -> {
            return bathingFireRecipeInstance.group(class_1799.field_24671.fieldOf("originalItem").forGetter(recipe -> {
                return recipe.originalItem;
            }), class_1799.field_24671.fieldOf("result").forGetter(recipe2 -> {
                return recipe2.result;
            })).apply(bathingFireRecipeInstance, BathingFireRecipe::new);
        });
        private final class_9139<class_9129, BathingFireRecipe> PACKET_CODEC = class_9139.method_56435(class_1799.field_48349, recipe -> {
            return recipe.originalItem;
        }, class_1799.field_48349, recipe2 -> {
            return recipe2.result;
        }, BathingFireRecipe::new);

        public MapCodec<BathingFireRecipe> method_53736() {
            return this.CODEC;
        }

        public class_9139<class_9129, BathingFireRecipe> method_56104() {
            return this.PACKET_CODEC;
        }
    }
}
