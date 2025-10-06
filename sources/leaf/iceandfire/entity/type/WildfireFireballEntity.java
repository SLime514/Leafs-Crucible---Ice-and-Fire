package leaf.iceandfire.entity.type;

import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1677;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3966;
import net.minecraft.class_8111;

public class WildfireFireballEntity extends class_1677 {
    public WildfireFireballEntity(class_1299<? extends class_1677> entityType, class_1937 world) {
        super(entityType, world);
    }

    public WildfireFireballEntity(class_1937 world, double directionX, double directionY, double directionZ, class_243 vec3d) {
        super(world, directionX, directionY, directionZ, vec3d);
    }

    public WildfireFireballEntity(class_1937 world, class_1309 owner, class_243 velocity) {
        super(world, owner, velocity);
    }

    protected void method_7454(class_3966 entityHitResult) {
        super.method_7454(entityHitResult);
        if (!method_37908().field_9236) {
            class_1309 class_1309VarMethod_17782 = entityHitResult.method_17782();
            if (class_1309VarMethod_17782 instanceof class_1309) {
                class_1309 livingEntity = class_1309VarMethod_17782;
                livingEntity.method_64397(method_37908(), method_37908().method_48963().method_48797(class_8111.field_42337, this, method_24921()), 20.0f);
                if (!livingEntity.method_5753()) {
                    livingEntity.method_56073(100);
                }
            }
        }
    }

    protected void method_7488(class_239 hitResult) {
        super.method_7488(hitResult);
        if (!method_37908().field_9236) {
            method_37908().method_8437(this, method_23317(), method_23318(), method_23321(), 1.0f, class_1937.class_7867.field_40888);
            method_37908().method_65096(class_2398.field_11240, method_23317(), method_23318(), method_23321(), 20, 0.5d, 0.5d, 0.5d, 0.1d);
            method_31472();
        }
    }
}
