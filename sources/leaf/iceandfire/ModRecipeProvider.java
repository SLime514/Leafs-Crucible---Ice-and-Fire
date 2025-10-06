package leaf.iceandfire;

import java.util.concurrent.CompletableFuture;
import leaf.iceandfire.block.ModBlocks;
import leaf.iceandfire.item.ModItems;
import leaf.iceandfire.recipe.BathingFireDropRecipeType;
import leaf.iceandfire.recipe.ModRecipes;
import leaf.iceandfire.recipe.bathingfire.BathingFireRecipe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2446;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7225;
import net.minecraft.class_7924;
import net.minecraft.class_8779;
import net.minecraft.class_8790;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<class_7225.class_7874> registriesFuture) {
        super(output, registriesFuture);
    }

    protected class_2446 method_62766(class_7225.class_7874 wrapperLookup, class_8790 recipeExporter) {
        return new ModRecipeGenerator(wrapperLookup, recipeExporter);
    }

    public String method_10321() {
        return "Leafs Crucible Recipes";
    }

    @Environment(EnvType.CLIENT)
    private static class ModRecipeGenerator extends class_2446 {
        protected ModRecipeGenerator(class_7225.class_7874 registries, class_8790 exporter) {
            super(registries, exporter);
        }

        public void method_10419() {
            generateBathingFireRecipe(class_1802.field_8600, ModItems.BATHING_FIRE_ROD, "bathing_fire_rod");
            generateBathingFireRecipe(class_1802.field_20412, ModBlocks.MAGMA_ROCK_ITEM, "magma_rock");
            generateBathingFireRecipe(class_1802.field_8634, ModItems.MAGMA_PEARL, "magma_pearl");
            generateBathingFireRecipe(class_1802.field_29025, class_1802.field_8281, "obsidian");
        }

        private void generateBathingFireRecipe(class_1792 originalItem, class_1792 result, String id) {
            generateBathingFireRecipe(this.field_53721, originalItem, result, id);
        }

        private void generateBathingFireDropRecipe(class_1792 firstItem, class_1792 secondItem, class_1792 result, float chance) {
            this.field_53721.method_53819(class_5321.method_29179(class_7924.field_52178, class_2960.method_60655(LeafsCrucible.MOD_ID, ModRecipes.BATHING_FIRE_DROP_RECIPE_ID)), new BathingFireDropRecipeType(new class_1799(firstItem), new class_1799(secondItem), new class_1799(result), chance), (class_8779) null);
        }

        private void generateBathingFireRecipe(class_8790 exporter, class_1792 originalItem, class_1792 result, String id) {
            generateBathingFireRecipe(exporter, originalItem, result, null, id);
        }

        private void generateBathingFireRecipe(class_8790 exporter, class_1792 originalItem, class_1792 result, @Nullable class_8779 advancementEntry, String id) {
            exporter.method_53819(class_5321.method_29179(class_7924.field_52178, class_2960.method_60655(LeafsCrucible.MOD_ID, "bathing_fire_recipe_" + id)), new BathingFireRecipe(new class_1799(originalItem), new class_1799(result)), advancementEntry);
        }
    }
}
