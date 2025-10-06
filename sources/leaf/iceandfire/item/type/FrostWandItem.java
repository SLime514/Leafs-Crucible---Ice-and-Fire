package leaf.iceandfire.item.type;

import java.util.List;
import leaf.iceandfire.component.ModComponentTypes;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_238;

public class FrostWandItem extends class_1792 {
    public FrostWandItem(class_1792.class_1793 settings) {
        super(settings.method_57349(ModComponentTypes.FROST_ENERGY, 100).method_57349(ModComponentTypes.FROST_REPAIRABLE, 1).method_7895(10));
    }

    public class_1269 method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        class_1799 stack = user.method_5998(hand);
        if (user.method_7357().method_7904(stack)) {
            return class_1269.field_5814;
        }
        List<class_1297> monsters = world.method_8333(user, new class_238(user.method_23317() - 15, user.method_23318() - 15, user.method_23321() - 15, user.method_23317() + 15, user.method_23318() + 15, user.method_23321() + 15), entity -> {
            return (entity == user || entity.method_7325() || !(entity instanceof class_1309)) ? false : true;
        });
        for (class_1297 entity2 : monsters) {
            if (entity2 instanceof class_1309) {
                class_1309 livingEntity = (class_1309) entity2;
                applyFrostEffect(livingEntity, stack);
                if (!user.method_37908().field_9236) {
                    livingEntity.method_64397(user.method_37908(), user.method_37908().method_48963().method_48831(), 5.0f);
                }
            }
        }
        user.method_7357().method_62835(stack, 50);
        if ((stack.method_7936() - stack.method_7919()) - 1 > 0) {
            stack.method_61653(1, user);
        } else {
            stack.method_7934(1);
        }
        return class_1269.field_5812;
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
}
