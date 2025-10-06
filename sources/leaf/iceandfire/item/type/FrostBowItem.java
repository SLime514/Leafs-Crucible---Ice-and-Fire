package leaf.iceandfire.item.type;

import leaf.iceandfire.entity.type.FrostArrowEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1753;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3468;
import net.minecraft.class_6880;
import net.minecraft.class_7924;

public class FrostBowItem extends class_1753 {
    public FrostBowItem(class_1792.class_1793 settings) {
        super(settings);
    }

    public boolean method_7840(class_1799 stack, class_1937 world, class_1309 user, int remainingUseTicks) {
        if (user instanceof class_1657) {
            class_1297 class_1297Var = (class_1657) user;
            boolean bl = class_1297Var.method_31549().field_7477 || class_1890.method_8225(class_6880.method_40223((class_1887) world.method_30349().method_30530(class_7924.field_41265).method_63535(class_1893.field_9125.method_29177())), stack) > 0;
            class_1799 itemStack = class_1297Var.method_18808(stack);
            int i = method_7881(stack, class_1297Var) - remainingUseTicks;
            float f = getPullProgress(i);
            if (f >= 0.1d) {
                if (!world.field_9236) {
                    FrostArrowEntity frostArrowEntity = new FrostArrowEntity(world, (class_1309) class_1297Var, stack, itemStack);
                    frostArrowEntity.method_24919(class_1297Var, class_1297Var.method_36455(), class_1297Var.method_36454(), 0.0f, f * 3.0f, 1.0f);
                    if (f == 1.0f) {
                        frostArrowEntity.method_7439(true);
                    }
                    int powerLevel = class_1890.method_8225(class_6880.method_40223((class_1887) world.method_30349().method_30530(class_7924.field_41265).method_63535(class_1893.field_9103.method_29177())), stack);
                    if (powerLevel > 0) {
                        frostArrowEntity.method_7438(frostArrowEntity.getDamage() + (powerLevel * 0.5d) + 0.5d);
                    }
                    if (class_1890.method_8225(class_6880.method_40223((class_1887) world.method_30349().method_30530(class_7924.field_41265).method_63535(class_1893.field_9126.method_29177())), stack) > 0) {
                        frostArrowEntity.method_5639(100.0f);
                    }
                    if (bl || class_1297Var.method_31549().field_7477) {
                        frostArrowEntity.field_7572 = class_1665.class_1666.field_7594;
                    }
                    world.method_8649(frostArrowEntity);
                }
                world.method_43128((class_1297) null, class_1297Var.method_23317(), class_1297Var.method_23318(), class_1297Var.method_23321(), class_3417.field_14600, class_3419.field_15248, 1.0f, (1.0f / ((world.method_8409().method_43057() * 0.4f) + 1.2f)) + (f * 0.5f));
                if (!bl && !class_1297Var.method_31549().field_7477) {
                    itemStack.method_7934(1);
                    if (itemStack.method_7960()) {
                        class_1297Var.method_31548().method_7378(itemStack);
                    }
                }
                class_1297Var.method_7259(class_3468.field_15372.method_14956(this));
                return true;
            }
            return true;
        }
        return true;
    }

    public class_1269 method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        class_1799 itemStack = user.method_5998(hand);
        boolean hasAmmo = !user.method_18808(itemStack).method_7960();
        if (!user.method_31549().field_7477 && !hasAmmo) {
            return class_1269.field_5814;
        }
        user.method_6019(hand);
        return class_1269.field_5812;
    }

    public static float getPullProgress(int useTicks) {
        float f = useTicks / 20.0f;
        float f2 = ((f * f) + (f * 2.0f)) / 3.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return f2;
    }

    private class_243 calculateTargetPosition(class_1657 player, float pullProgress) {
        class_243 lookVec = player.method_5828(1.0f);
        double distance = 20.0d * pullProgress;
        class_243 targetPos = player.method_33571().method_1019(lookVec.method_1021(distance));
        return targetPos;
    }

    public int method_7881(class_1799 stack, class_1309 user) {
        return 72000;
    }
}
