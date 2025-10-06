package leaf.iceandfire.entity.type;

import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1667;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_3218;

public class FrostArrowEntity extends class_1667 {
    public FrostArrowEntity(class_1299<? extends class_1667> entityType, class_1937 world) {
        super(entityType, world);
    }

    public FrostArrowEntity(class_1937 world, double x, double y, double z, class_1799 stack, class_1799 shotFrom) {
        super(world, x, y, z, stack, shotFrom);
    }

    public FrostArrowEntity(class_1937 world, class_1309 owner, class_1799 stack, class_1799 shotFrom) {
        super(world, owner, stack, shotFrom);
    }

    public FrostArrowEntity(class_1937 world, class_1309 owner, class_1799 stack) {
        this(world, owner, stack, class_1799.field_8037);
    }

    public FrostArrowEntity(class_1937 world, double x, double y, double z) {
        this(world, x, y, z, class_1799.field_8037, class_1799.field_8037);
    }

    public double getDamage() {
        return 2.0d;
    }

    public void method_7438(double damage) {
    }

    public void setPunch(int punch) {
    }

    protected void method_7450(class_1309 target) {
        super.method_7450(target);
        target.method_6092(new class_1293(class_1294.field_5909, 100, 2, false, true, true));
        if (method_37908().field_9236) {
            return;
        }
        class_3218 class_3218VarMethod_37908 = method_37908();
        if (class_3218VarMethod_37908 instanceof class_3218) {
            class_3218 serverWorld = class_3218VarMethod_37908;
            target.method_64397(serverWorld, method_48923().method_48836(), 2.0f);
        }
    }
}
