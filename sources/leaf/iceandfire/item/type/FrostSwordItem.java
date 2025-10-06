package leaf.iceandfire.item.type;

import leaf.iceandfire.component.ModComponentTypes;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2398;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;

public class FrostSwordItem extends class_1792 {
    public FrostSwordItem(class_1792.class_1793 settings) {
        super(settings.method_57349(ModComponentTypes.FROST_REPAIRABLE, 1));
    }

    public void method_7873(class_1799 stack, class_1309 target, class_1309 attacker) {
        applyFrostEffect(target, stack);
        playFrostEffects(target.method_37908(), target, attacker);
        super.method_7873(stack, target, attacker);
    }

    private void applyFrostEffect(class_1309 target, class_1799 stack) {
        int amplifier;
        int duration;
        float damagePercent = stack.method_7919() / stack.method_7936();
        if (damagePercent < 0.3f) {
            amplifier = 2;
            duration = 80;
        } else if (damagePercent < 0.6f) {
            amplifier = 1;
            duration = 60;
        } else {
            amplifier = 0;
            duration = 40;
        }
        target.method_6092(new class_1293(class_1294.field_5909, duration, amplifier, false, true, true));
        if (Math.random() < 0.3d) {
            target.method_6092(new class_1293(class_1294.field_5911, 40, 0, false, true, true));
        }
    }

    private void playFrostEffects(class_1937 world, class_1309 target, class_1309 attacker) {
        world.method_43128((class_1297) null, target.method_23317(), target.method_23318(), target.method_23321(), class_3417.field_15081, class_3419.field_15248, 0.8f, 1.5f);
        if (world instanceof class_3218) {
            class_3218 serverWorld = (class_3218) world;
            serverWorld.method_65096(class_2398.field_11228, target.method_23317(), target.method_23323(0.5d), target.method_23321(), 15, 0.3d, 0.3d, 0.3d, 0.1d);
        }
    }
}
