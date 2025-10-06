package leaf.iceandfire.entity.p001ai.goal;

import java.util.EnumSet;
import java.util.List;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1545;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_3218;
import net.minecraft.class_3730;
import net.minecraft.class_5819;

public class SummonBlazeGoal extends class_1352 {
    private final class_1314 entity;
    private final int maxBlazes;
    private final int minBlazes;
    private final int cooldownTicks;
    private final float summonRange;
    private int cooldown = 0;
    private final class_5819 random = class_5819.method_43047();

    public SummonBlazeGoal(class_1314 entity, int minBlazes, int maxBlazes, int cooldownTicks, float summonRange) {
        this.entity = entity;
        this.minBlazes = minBlazes;
        this.maxBlazes = maxBlazes;
        this.cooldownTicks = cooldownTicks;
        this.summonRange = summonRange;
        method_6265(EnumSet.of(class_1352.class_4134.field_18405, class_1352.class_4134.field_18406));
    }

    public boolean method_6264() {
        if (this.cooldown > 0) {
            this.cooldown--;
            return false;
        }
        class_1309 target = this.entity.method_5968();
        if (target == null || !target.method_5805()) {
            return false;
        }
        class_3218 world = this.entity.method_37908();
        class_238 box = new class_238(this.entity.method_24515()).method_1009(this.summonRange, 4.0d, this.summonRange);
        List<class_1545> nearbyBlazes = world.method_18023(class_1299.field_6099, box, blaze -> {
            return true;
        });
        return nearbyBlazes.size() < 5;
    }

    public boolean method_6266() {
        return false;
    }

    public void method_6269() {
        summonBlazes();
        this.cooldown = this.cooldownTicks;
    }

    private void summonBlazes() {
        class_3218 world = this.entity.method_37908();
        class_1309 target = this.entity.method_5968();
        if (target == null) {
            return;
        }
        int blazeCount = this.random.method_39332(this.minBlazes, this.maxBlazes);
        for (int i = 0; i < blazeCount; i++) {
            double angle = this.random.method_43058() * 2.0d * 3.141592653589793d;
            double distance = 2.0d + (this.random.method_43058() * 3.0d);
            double x = this.entity.method_23317() + (Math.cos(angle) * distance);
            double z = this.entity.method_23321() + (Math.sin(angle) * distance);
            double y = this.entity.method_23318();
            class_2338 spawnPos = new class_2338((int) x, (int) y, (int) z);
            if (!world.method_22347(spawnPos)) {
                spawnPos = spawnPos.method_10084();
            }
            class_1545 blaze = class_1299.field_6099.method_5883(world, class_3730.field_16471);
            if (blaze != null) {
                blaze.method_5808(spawnPos.method_10263() + 0.5d, spawnPos.method_10264(), spawnPos.method_10260() + 0.5d, this.random.method_43057() * 360.0f, 0.0f);
                world.method_8649(blaze);
                blaze.method_5980(target);
            }
        }
    }
}
