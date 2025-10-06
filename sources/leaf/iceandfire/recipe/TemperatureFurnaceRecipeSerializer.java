package leaf.iceandfire.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_1799;
import net.minecraft.class_1856;
import net.minecraft.class_1865;
import net.minecraft.class_9129;
import net.minecraft.class_9135;
import net.minecraft.class_9139;

public class TemperatureFurnaceRecipeSerializer implements class_1865<TemperatureFurnaceRecipe> {
    public static final TemperatureFurnaceRecipeSerializer INSTANCE = new TemperatureFurnaceRecipeSerializer();
    public static final MapCodec<TemperatureFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.STRING.optionalFieldOf("group", "").forGetter((v0) -> {
            return v0.method_8112();
        }), class_1856.field_46095.fieldOf("ingredient").forGetter(recipe -> {
            return recipe.input;
        }), class_1799.field_24671.fieldOf("result").forGetter(recipe2 -> {
            return recipe2.result;
        }), Codec.FLOAT.optionalFieldOf("experience", Float.valueOf(0.0f)).forGetter((v0) -> {
            return v0.method_8171();
        }), Codec.INT.optionalFieldOf("temperature", 2).forGetter((v0) -> {
            return v0.method_8167();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new TemperatureFurnaceRecipe(v1, v2, v3, v4, v5);
        });
    });
    public static final class_9139<class_9129, TemperatureFurnaceRecipe> PACKET_CODEC = class_9139.method_56906(class_9135.field_48554, (v0) -> {
        return v0.method_8112();
    }, class_1856.field_48355, recipe -> {
        return recipe.input;
    }, class_1799.field_48349, recipe2 -> {
        return recipe2.result;
    }, class_9135.field_48552, (v0) -> {
        return v0.method_8171();
    }, class_9135.field_49675, (v0) -> {
        return v0.getTemperature();
    }, (v1, v2, v3, v4, v5) -> {
        return new TemperatureFurnaceRecipe(v1, v2, v3, v4, v5);
    });

    public MapCodec<TemperatureFurnaceRecipe> method_53736() {
        return CODEC;
    }

    public class_9139<class_9129, TemperatureFurnaceRecipe> method_56104() {
        return PACKET_CODEC;
    }
}
