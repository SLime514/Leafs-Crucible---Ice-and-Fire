package leaf.iceandfire.recipe;

import leaf.iceandfire.recipe.bathingfire.BathingFireRecipeInput;
import net.minecraft.class_1799;
import net.minecraft.class_9695;

public class BathingFireDropRecipeInput implements class_9695 {
    private final class_1799 firstDrop;
    private final class_1799 secondDrop;

    public BathingFireDropRecipeInput(class_1799 firstDrop, class_1799 secondDrop) {
        this.firstDrop = firstDrop;
        this.secondDrop = secondDrop;
    }

    public class_1799 method_59984(int slot) {
        switch (slot) {
            case 0:
                return this.firstDrop;
            case BathingFireRecipeInput.SIZE:
                return this.secondDrop;
            default:
                return class_1799.field_8037;
        }
    }

    public int method_59983() {
        return 2;
    }
}
