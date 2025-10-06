package leaf.iceandfire.item.type;

import leaf.iceandfire.entity.type.MagmaPearlEntity;
import leaf.iceandfire.item.ModItems;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3468;
import net.minecraft.class_9334;

public class MagmaWandItem extends class_1792 {
    private static final int MAX_CHARGE_TIME = 40;

    public MagmaWandItem() {
        super(new class_1792.class_1793().method_7895(128).method_24359().method_57349(class_9334.field_49641, true));
    }

    public MagmaWandItem(class_1792.class_1793 settings) {
        super(settings);
    }

    public boolean method_7840(class_1799 stack, class_1937 world, class_1309 user, int remainingUseTicks) {
        if (user instanceof class_1657) {
            class_1657 player = (class_1657) user;
            int chargeTime = method_7881(stack, user) - remainingUseTicks;
            float chargePower = getChargePower(chargeTime);
            int circleCount = getCircleCount(chargePower);
            if (!world.field_9236) {
                spawnMagmaPearlCircles(world, player, circleCount);
            }
            world.method_43128((class_1297) null, player.method_23317(), player.method_23318(), player.method_23321(), class_3417.field_14970, class_3419.field_15248, 1.0f, 1.0f);
            stack.method_7970(1, player, class_1309.method_56079(player.method_6058()));
            player.method_7259(class_3468.field_15372.method_14956(this));
            return true;
        }
        return true;
    }

    public class_1269 method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        user.method_5998(hand);
        user.method_6019(hand);
        return class_1269.field_5812;
    }

    public int method_7881(class_1799 stack, class_1309 user) {
        return 72000;
    }

    public class_1839 method_7853(class_1799 stack) {
        return class_1839.field_8953;
    }

    private float getChargePower(int chargeTime) {
        float power = chargeTime / 40.0f;
        float power2 = ((power * power) + (power * 2.0f)) / 3.0f;
        if (power2 > 1.0f) {
            power2 = 1.0f;
        }
        return power2;
    }

    private int getCircleCount(float chargePower) {
        if (chargePower >= 0.9f) {
            return 10;
        }
        if (chargePower >= 0.6f) {
            return 4;
        }
        return 1;
    }

    private void spawnMagmaPearlCircles(class_1937 world, class_1657 player, int circleCount) {
        class_243 lookVec = player.method_5828(1.0f);
        class_243 playerPos = player.method_5836(1.0f);
        class_243 spawnPos = playerPos.method_1019(lookVec.method_1021(1.5d));
        class_243 upVec = new class_243(0.0d, 1.0d, 0.0d);
        class_243 rightVec = lookVec.method_1036(upVec).method_1029();
        class_243 upVecCorrected = rightVec.method_1036(lookVec).method_1029();
        for (int circle = 0; circle < circleCount; circle++) {
            double circleRadius = 0.3d + (circle * 0.2d);
            double speed = 1.5d + (circle * 0.1d);
            int delay = circle * 3;
            for (int i = 0; i < 32; i++) {
                double angle = (6.283185307179586d * i) / 32;
                class_243 circleOffset = rightVec.method_1021(Math.cos(angle) * circleRadius).method_1019(upVecCorrected.method_1021(Math.sin(angle) * circleRadius));
                MagmaPearlEntity pearlEntity = new MagmaPearlEntity(world, (class_1309) player);
                pearlEntity.method_16940(ModItems.MAGMA_PEARL.method_7854());
                class_243 pearlPos = spawnPos.method_1019(circleOffset);
                pearlEntity.method_5814(pearlPos.field_1352, pearlPos.field_1351, pearlPos.field_1350);
                class_243 velocity = lookVec.method_1021(speed).method_1019(circleOffset.method_1021(0.5d));
                pearlEntity.method_18800(velocity.field_1352, velocity.field_1351, velocity.field_1350);
                if (delay > 0) {
                    pearlEntity.method_51850(delay);
                }
                world.method_8649(pearlEntity);
            }
        }
    }
}
