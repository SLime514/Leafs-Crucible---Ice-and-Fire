package leaf.iceandfire.entity.p001ai.goal;

import java.util.EnumSet;
import leaf.iceandfire.entity.type.WildfireEntity;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1677;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3417;
import net.minecraft.class_3419;

public class SecondPhaseSpecialAttackGoal extends class_1352 {
    private final WildfireEntity wildfire;
    private int attackCooldown = 0;
    private int specialAttackTicks = 0;
    private boolean isSpecialAttacking = false;

    public SecondPhaseSpecialAttackGoal(WildfireEntity wildfire) {
        this.wildfire = wildfire;
        method_6265(EnumSet.of(class_1352.class_4134.field_18405, class_1352.class_4134.field_18406));
    }

    public boolean method_6264() {
        return this.wildfire.isInSecondPhase() && this.wildfire.method_5968() != null && this.wildfire.method_5968().method_5805() && !this.isSpecialAttacking && this.attackCooldown <= 0;
    }

    public boolean method_6266() {
        return this.isSpecialAttacking && this.specialAttackTicks < 100;
    }

    public void method_6269() {
        this.isSpecialAttacking = true;
        this.specialAttackTicks = 0;
        this.attackCooldown = 300;
        if (!this.wildfire.method_37908().field_9236) {
            this.wildfire.method_37908().method_43128((class_1297) null, this.wildfire.method_23317(), this.wildfire.method_23318(), this.wildfire.method_23321(), class_3417.field_14792, class_3419.field_15251, 1.0f, 1.0f);
        }
    }

    public void method_6268() {
        this.specialAttackTicks++;
        class_1309 target = this.wildfire.method_5968();
        if (target == null) {
            return;
        }
        this.wildfire.method_5988().method_6226(target, 10.0f, 10.0f);
        if (this.specialAttackTicks % 20 == 0) {
            shootSoulFireballs(target);
        }
        if (this.wildfire.method_37908().field_9236 && this.specialAttackTicks % 5 == 0) {
            this.wildfire.method_37908().method_8406(class_2398.field_23114, this.wildfire.method_23317() + ((this.wildfire.method_59922().method_43058() - 0.5d) * 2.0d), this.wildfire.method_23318() + (this.wildfire.method_59922().method_43058() * 2.0d), this.wildfire.method_23321() + ((this.wildfire.method_59922().method_43058() - 0.5d) * 2.0d), (this.wildfire.method_59922().method_43058() - 0.5d) * 0.1d, this.wildfire.method_59922().method_43058() * 0.1d, (this.wildfire.method_59922().method_43058() - 0.5d) * 0.1d);
        }
    }

    public void method_6270() {
        this.isSpecialAttacking = false;
        this.specialAttackTicks = 0;
    }

    private void shootSoulFireballs(class_1309 target) {
        if (this.wildfire.method_37908().field_9236) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            double angleOffset = (i - 2) * 0.3d;
            double dX = target.method_23317() - this.wildfire.method_23317();
            double dY = target.method_23323(0.5d) - this.wildfire.method_23323(0.5d);
            double dZ = target.method_23321() - this.wildfire.method_23321();
            double horizontalDistance = Math.sqrt((dX * dX) + (dZ * dZ));
            double angle = Math.atan2(dZ, dX) + angleOffset;
            double newDX = Math.cos(angle) * horizontalDistance;
            double newDZ = Math.sin(angle) * horizontalDistance;
            class_243 direction = new class_243(newDX, dY, newDZ).method_1029();
            class_1677 fireball = new class_1677(this.wildfire.method_37908(), this.wildfire, direction);
            fireball.method_5814(this.wildfire.method_23317(), this.wildfire.method_23323(0.5d) + 0.5d, this.wildfire.method_23321());
            this.wildfire.method_37908().method_8649(fireball);
        }
        if (!this.wildfire.method_5701()) {
            this.wildfire.method_37908().method_8444((class_1297) null, 1018, this.wildfire.method_24515(), 0);
        }
    }
}
