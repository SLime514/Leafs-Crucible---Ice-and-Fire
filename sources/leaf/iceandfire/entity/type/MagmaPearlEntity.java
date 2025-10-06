package leaf.iceandfire.entity.type;

import java.util.ArrayList;
import java.util.List;
import leaf.iceandfire.entity.ModEntities;
import leaf.iceandfire.item.ModItems;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2398;
import net.minecraft.class_2404;
import net.minecraft.class_2680;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3857;
import net.minecraft.class_5712;

public class MagmaPearlEntity extends class_3857 {
    private final List<class_2338> lavaPositions;
    private static final int LAVA_DURATION = 100;
    private int age;
    private boolean isDropped;

    public MagmaPearlEntity(class_1299<? extends MagmaPearlEntity> entityType, class_1937 world) {
        super(entityType, world);
        this.lavaPositions = new ArrayList();
        this.isDropped = false;
        this.age = 0;
    }

    public MagmaPearlEntity(class_1937 world, class_1309 owner) {
        super(ModEntities.MAGMA_PEARL_ENTITY, owner, world, ModItems.MAGMA_PEARL.method_7854());
        this.lavaPositions = new ArrayList();
        this.isDropped = false;
        this.age = 0;
    }

    protected class_1792 method_16942() {
        return ModItems.MAGMA_PEARL;
    }

    public void method_5773() {
        super.method_5773();
        if (method_37908().field_9236 && !this.isDropped) {
            for (int i = 0; i < 5; i++) {
                method_37908().method_8406(class_2398.field_11240, method_23317() + ((this.field_5974.method_43058() - 0.5d) * 0.2d), method_23318() + ((this.field_5974.method_43058() - 0.5d) * 0.2d), method_23321() + ((this.field_5974.method_43058() - 0.5d) * 0.2d), (this.field_5974.method_43058() - 0.5d) * 0.05d, (this.field_5974.method_43058() - 0.5d) * 0.05d, (this.field_5974.method_43058() - 0.5d) * 0.05d);
            }
        }
        if (this.isDropped) {
            this.age++;
            if (this.age >= LAVA_DURATION) {
                removeLava();
                method_31472();
            }
        }
    }

    protected void method_7488(class_239 hitResult) {
        if (this.isDropped) {
            return;
        }
        super.method_7488(hitResult);
        if (!method_37908().field_9236) {
            class_2338 hitPos = new class_2338((int) Math.floor(method_23317()), (int) Math.floor(method_23318()), (int) Math.floor(method_23321()));
            createLava(hitPos);
            createLava(hitPos.method_10084());
            createLava(hitPos.method_10069(1, 0, 0));
            createLava(hitPos.method_10069(-1, 0, 0));
            createLava(hitPos.method_10069(0, 0, 1));
            createLava(hitPos.method_10069(0, 0, -1));
            for (int i = 0; i < 30; i++) {
                method_37908().method_8406(class_2398.field_11239, method_23317() + (this.field_5974.method_43058() - 0.5d), method_23318() + (this.field_5974.method_43058() - 0.5d), method_23321() + (this.field_5974.method_43058() - 0.5d), (this.field_5974.method_43058() - 0.5d) * 0.1d, this.field_5974.method_43058() * 0.1d, (this.field_5974.method_43058() - 0.5d) * 0.1d);
            }
            this.isDropped = true;
        }
    }

    private void createLava(class_2338 pos) {
        if (method_37908().method_8320(pos).method_26204() != class_2246.field_10124) {
            return;
        }
        this.lavaPositions.add(pos.method_10062());
        method_37908().method_8501(pos, class_2246.field_10164.method_9564());
        method_37908().method_8396((class_1297) null, pos, class_3417.field_15021, class_3419.field_15245, 1.0f, 1.0f);
        method_37908().method_43276(class_5712.field_28166, pos, class_5712.class_7397.method_43287(class_2246.field_10164.method_9564()));
    }

    private void removeLava() {
        for (class_2338 pos : this.lavaPositions) {
            class_2680 blockState = method_37908().method_8320(pos);
            if (blockState.method_26204() == class_2246.field_10164 && (blockState.method_26204() instanceof class_2404)) {
                method_37908().method_8501(pos, class_2246.field_10124.method_9564());
                method_37908().method_8396((class_1297) null, pos, class_3417.field_19198, class_3419.field_15245, 1.0f, 1.0f);
                method_37908().method_43276(class_5712.field_28167, pos, class_5712.class_7397.method_43287(blockState));
            }
        }
        this.lavaPositions.clear();
    }
}
