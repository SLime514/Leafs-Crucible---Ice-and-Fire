package leaf.iceandfire.recipe.bathingfire;

import net.minecraft.class_1799;
import net.minecraft.class_9695;

public class BathingFireRecipeInput implements class_9695 {
    private final class_1799 originalItem;
    public static final int SIZE = 1;

    public BathingFireRecipeInput(class_1799 originalItem) {
        this.originalItem = originalItem;
    }

    public class_1799 method_59984(int slot) {
        return slot == 0 ? this.originalItem : class_1799.field_8037;
    }

    public int method_59983() {
        return 1;
    }

    public String toString() {
        return "BathingFireRecipeInput{originalItem=" + String.valueOf(this.originalItem) + "}";
    }
}
