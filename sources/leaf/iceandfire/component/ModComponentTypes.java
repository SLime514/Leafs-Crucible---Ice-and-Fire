package leaf.iceandfire.component;

import java.util.function.UnaryOperator;
import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.recipe.ModRecipes;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5699;
import net.minecraft.class_7923;
import net.minecraft.class_9135;
import net.minecraft.class_9331;

public class ModComponentTypes {
    public static final class_9331<Integer> BATHING_FIRE = register(ModRecipes.BATHING_FIRE_RECIPE_ID, build -> {
        return build.method_57881(class_5699.method_48766(0, 1)).method_57882(class_9135.field_49675).method_59871();
    });
    public static final class_9331<Integer> FROST_ENERGY = register("frost_energy", build -> {
        return build.method_57881(class_5699.method_48766(0, 100)).method_57882(class_9135.field_49675).method_59871();
    });
    public static final class_9331<Integer> TEMPERATURE = register("temperature", build -> {
        return build.method_57881(class_5699.method_48766(-10, 10)).method_57882(class_9135.field_49675).method_59871();
    });
    public static final class_9331<Integer> FROST_REPAIRABLE = register("frost_repairable", build -> {
        return build.method_57881(class_5699.method_48766(0, 1)).method_57882(class_9135.field_49675).method_59871();
    });

    private static <T> class_9331<T> register(String id, UnaryOperator<class_9331.class_9332<T>> builderOperator) {
        return (class_9331) class_2378.method_10230(class_7923.field_49658, class_2960.method_60655(LeafsCrucible.MOD_ID, id), ((class_9331.class_9332) builderOperator.apply(class_9331.method_57873())).method_57880());
    }

    public static void initialize() {
    }
}
