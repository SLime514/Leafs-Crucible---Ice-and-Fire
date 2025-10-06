package leaf.iceandfire.rei;

import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.recipe.ModRecipes;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1802;

@Environment(EnvType.CLIENT)
public class LeafsCrucibleREIPlugin implements REIClientPlugin {
    public static final CategoryIdentifier<BathingFireDropDisplay> BATHING_FIRE_DROP = CategoryIdentifier.of(LeafsCrucible.MOD_ID, ModRecipes.BATHING_FIRE_DROP_RECIPE_ID);

    public void registerCategories(CategoryRegistry registry) {
        registry.add(new BathingFireDropCategory());
        registry.addWorkstations(BATHING_FIRE_DROP, new EntryStack[]{EntryStacks.of(class_1802.field_8465)});
    }

    public void registerDisplays(DisplayRegistry registry) {
    }
}
