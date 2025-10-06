package leaf.iceandfire.rei;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import leaf.iceandfire.recipe.BathingFireDropRecipeType;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_8786;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class BathingFireDropDisplay extends BasicDisplay {
    private final EntryIngredient firstInput;
    private final EntryIngredient secondInput;
    private final float chance;

    public BathingFireDropDisplay(class_8786<BathingFireDropRecipeType> recipe) {
        super(List.of(EntryIngredients.of(((BathingFireDropRecipeType) recipe.comp_1933()).getFirstInput().method_7909(), ((BathingFireDropRecipeType) recipe.comp_1933()).getFirstInput().method_7947()), EntryIngredients.of(((BathingFireDropRecipeType) recipe.comp_1933()).getSecondInput().method_7909(), ((BathingFireDropRecipeType) recipe.comp_1933()).getSecondInput().method_7947())), Collections.singletonList(EntryIngredients.of(((BathingFireDropRecipeType) recipe.comp_1933()).getResult().method_7909(), ((BathingFireDropRecipeType) recipe.comp_1933()).getResult().method_7947())), Optional.of(recipe.comp_1932().method_29177()));
        this.firstInput = EntryIngredients.of(((BathingFireDropRecipeType) recipe.comp_1933()).getFirstInput().method_7909(), ((BathingFireDropRecipeType) recipe.comp_1933()).getFirstInput().method_7947());
        this.secondInput = EntryIngredients.of(((BathingFireDropRecipeType) recipe.comp_1933()).getSecondInput().method_7909(), ((BathingFireDropRecipeType) recipe.comp_1933()).getSecondInput().method_7947());
        this.chance = ((BathingFireDropRecipeType) recipe.comp_1933()).getChance().floatValue();
    }

    public EntryIngredient getFirstInput() {
        return this.firstInput;
    }

    public EntryIngredient getSecondInput() {
        return this.secondInput;
    }

    public float getChance() {
        return this.chance;
    }

    public CategoryIdentifier<?> getCategoryIdentifier() {
        return LeafsCrucibleREIPlugin.BATHING_FIRE_DROP;
    }

    @Nullable
    public DisplaySerializer<? extends Display> getSerializer() {
        return null;
    }
}
