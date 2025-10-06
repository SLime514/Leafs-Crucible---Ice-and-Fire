package leaf.iceandfire.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.class_10355;
import net.minecraft.class_1799;
import net.minecraft.class_1856;
import net.minecraft.class_1860;
import net.minecraft.class_1865;
import net.minecraft.class_1937;
import net.minecraft.class_3956;
import net.minecraft.class_7225;
import net.minecraft.class_9129;
import net.minecraft.class_9135;
import net.minecraft.class_9139;
import net.minecraft.class_9887;

public class BathingFireDropRecipeType implements class_1860<BathingFireDropRecipeInput> {
    class_1799 result;
    class_1799 firstInput;
    class_1799 secondInput;
    float chance;

    public BathingFireDropRecipeType(class_1799 input_1, class_1799 input_2, class_1799 result, float chance) {
        this.result = result;
        this.firstInput = input_1;
        this.secondInput = input_2;
        this.chance = chance;
    }

    public class_1799 getFirstInput() {
        return this.firstInput;
    }

    public class_1799 getSecondInput() {
        return this.secondInput;
    }

    public class_1799 getResult() {
        return this.result;
    }

    public boolean method_8115(BathingFireDropRecipeInput input, class_1937 world) {
        class_1799 input1 = input.method_59984(0);
        class_1799 input2 = input.method_59984(1);
        boolean match1 = class_1799.method_7984(input1, this.firstInput) && class_1799.method_7984(input2, this.secondInput);
        boolean match2 = class_1799.method_7984(input1, this.secondInput) && class_1799.method_7984(input2, this.firstInput);
        return match1 || match2;
    }

    public class_1799 method_8116(BathingFireDropRecipeInput input, class_7225.class_7874 registries) {
        return this.result.method_7972();
    }

    public class_1865<? extends class_1860<BathingFireDropRecipeInput>> method_8119() {
        return Serializer.INSTANCE;
    }

    public class_3956<? extends class_1860<BathingFireDropRecipeInput>> method_17716() {
        return ModRecipes.BATHING_FIRE_DROP_RECIPE_TYPE;
    }

    public class_9887 method_61671() {
        return class_9887.method_61686(List.of(class_1856.method_8101(this.firstInput.method_7909()), class_1856.method_8101(this.secondInput.method_7909())));
    }

    public class_10355 method_64668() {
        return ModRecipeBookCategories.BATHING_FIRE_DROP_CATEGORY;
    }

    public Float getChance() {
        return Float.valueOf(this.chance);
    }

    public static class Serializer implements class_1865<BathingFireDropRecipeType> {
        public static final Serializer INSTANCE = new Serializer();
        private MapCodec<BathingFireDropRecipeType> CODEC = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(class_1799.field_24671.fieldOf("firstInput").forGetter(recipe -> {
                return recipe.firstInput;
            }), class_1799.field_24671.fieldOf("secondInput").forGetter(recipe2 -> {
                return recipe2.secondInput;
            }), class_1799.field_24671.fieldOf("result").forGetter(recipe3 -> {
                return recipe3.result;
            }), Codec.FLOAT.fieldOf("chance").forGetter(recipe4 -> {
                return Float.valueOf(recipe4.chance);
            })).apply(instance, (v1, v2, v3, v4) -> {
                return new BathingFireDropRecipeType(v1, v2, v3, v4);
            });
        });
        private class_9139<class_9129, BathingFireDropRecipeType> PACKET_CODEC = class_9139.method_56905(class_1799.field_48349, recipe -> {
            return recipe.firstInput;
        }, class_1799.field_48349, recipe2 -> {
            return recipe2.secondInput;
        }, class_1799.field_48349, recipe3 -> {
            return recipe3.result;
        }, class_9135.field_48552, recipe4 -> {
            return Float.valueOf(recipe4.chance);
        }, (v1, v2, v3, v4) -> {
            return new BathingFireDropRecipeType(v1, v2, v3, v4);
        });

        public MapCodec<BathingFireDropRecipeType> method_53736() {
            return this.CODEC;
        }

        public class_9139<class_9129, BathingFireDropRecipeType> method_56104() {
            return this.PACKET_CODEC;
        }
    }
}
