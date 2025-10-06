package leaf.iceandfire.entity.type;

import leaf.iceandfire.entity.ModEntities;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1665;
import net.minecraft.class_1675;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_2398;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3965;
import net.minecraft.class_3966;

public class SwordRainEntity extends class_1665 {
    private int duration;
    private double targetX;
    private double targetZ;

    public SwordRainEntity(class_1299<? extends SwordRainEntity> entityType, class_1937 world) {
        super(entityType, world);
        this.duration = 20;
    }

    public SwordRainEntity(class_1937 world, class_1309 owner, double targetX, double targetZ) {
        super(ModEntities.SWORD_RAIN_ENTITY, owner, world, class_1802.field_8371.method_7854(), class_1802.field_8371.method_7854());
        this.targetX = targetX;
        this.targetZ = targetZ;
        this.duration = 20;
        method_5814(targetX, owner.method_23318() + 15.0d, targetZ);
    }

    public void method_5773() {
        super.method_5773();
        if (!method_37908().field_9236) {
            class_3218 class_3218VarMethod_37908 = method_37908();
            if (class_3218VarMethod_37908 instanceof class_3218) {
                class_3218 serverWorld = class_3218VarMethod_37908;
                serverWorld.method_65096(class_2398.field_11204, method_23317(), method_23318(), method_23321(), 1, 0.1d, 0.1d, 0.1d, 0.0d);
                return;
            }
            return;
        }
        this.duration--;
        if (this.duration <= 0) {
            method_31472();
            return;
        }
        method_18800(0.0d, -1.0d, 0.0d);
        class_239 hitResult = class_1675.method_49997(this, x$0 -> {
            return this.method_26958(x$0);
        });
        if (hitResult.method_17783() != class_239.class_240.field_1333) {
            method_7488(hitResult);
        }
    }

    protected void method_7454(class_3966 entityHitResult) {
        super.method_7454(entityHitResult);
        class_1309 class_1309VarMethod_17782 = entityHitResult.method_17782();
        if (class_1309VarMethod_17782 instanceof class_1309) {
            class_1309 livingEntity = class_1309VarMethod_17782;
            if (!livingEntity.method_37908().field_9236) {
                livingEntity.method_64397(livingEntity.method_37908(), method_37908().method_48963().method_48831(), 6.0f);
            }
        }
    }

    protected void method_24920(class_3965 blockHitResult) {
        super.method_24920(blockHitResult);
        method_31472();
        method_5783(class_3417.field_14833, 1.0f, 1.0f);
    }

    protected class_1799 method_7445() {
        return class_1802.field_8371.method_7854();
    }

    protected class_1799 method_57314() {
        return class_1802.field_8371.method_7854();
    }
}
