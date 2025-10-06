package leaf.iceandfire.item.type;

import leaf.iceandfire.material.ModMaterials;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;

public class MagmaSwordItem extends class_1792 {
    public MagmaSwordItem(class_1792.class_1793 settings) {
        super(settings.method_66333(ModMaterials.MAGMA_TOOL, 5.0f, -2.4f));
    }

    public void method_7873(class_1799 stack, class_1309 target, class_1309 attacker) {
        applyFlameEffect(target);
        super.method_7873(stack, target, attacker);
    }

    private void applyFlameEffect(class_1309 target) {
        if (target.method_5809()) {
            int fireTicks = target.method_20802();
            if (fireTicks > 0 && fireTicks > 0) {
                target.method_64397(target.method_37908(), target.method_48923().method_48794(), fireTicks / 20.0f);
                return;
            }
            return;
        }
        target.method_56073(40);
    }
}
