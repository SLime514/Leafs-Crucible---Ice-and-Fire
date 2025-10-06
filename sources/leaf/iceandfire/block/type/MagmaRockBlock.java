package leaf.iceandfire.block.type;

import leaf.iceandfire.item.ModItems;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2398;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5712;
import org.jetbrains.annotations.Nullable;

public class MagmaRockBlock extends class_2248 {
    public MagmaRockBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    public void method_9591(class_1937 world, class_2338 pos, class_2680 state, class_1297 entity) {
        if (!entity.method_21749() && (entity instanceof class_1309)) {
            entity.method_56073(10000);
        }
        super.method_9591(world, pos, state, entity);
    }

    public class_1269 method_55766(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_3965 hit) {
        if (!world.field_9236) {
            if (player.method_6047().method_31574(ModItems.BATHING_FIRE_ROD)) {
                world.method_8396((class_1297) null, pos, class_3417.field_15026, class_3419.field_15245, 1.0f, 1.0f);
                world.method_43276(class_5712.field_28165, pos, class_5712.class_7397.method_43286(player, state));
                world.method_8650(pos, false);
                method_9577(world, pos, new class_1799(ModItems.MAGMA_PEARL));
                return class_1269.field_5812;
            }
        } else if (player.method_6047().method_31574(ModItems.BATHING_FIRE_ROD)) {
            addDestroyEffects(world, pos, state);
        }
        return class_1269.field_5811;
    }

    private void addDestroyEffects(class_1937 world, class_2338 pos, class_2680 state) {
        for (int i = 0; i < 20; i++) {
            double x = pos.method_10263() + world.field_9229.method_43058();
            double y = pos.method_10264() + world.field_9229.method_43058();
            double z = pos.method_10260() + world.field_9229.method_43058();
            world.method_8406(class_2398.field_11205, x, y, z, (world.field_9229.method_43058() - 0.5d) * 0.5d, (world.field_9229.method_43058() - 0.5d) * 0.5d, (world.field_9229.method_43058() - 0.5d) * 0.5d);
        }
        for (int i2 = 0; i2 < 10; i2++) {
            double x2 = pos.method_10263() + world.field_9229.method_43058();
            double y2 = pos.method_10264() + world.field_9229.method_43058();
            double z2 = pos.method_10260() + world.field_9229.method_43058();
            world.method_8406(class_2398.field_11240, x2, y2, z2, (world.field_9229.method_43058() - 0.5d) * 0.1d, world.field_9229.method_43058() * 0.1d, (world.field_9229.method_43058() - 0.5d) * 0.1d);
        }
    }

    public void method_9556(class_1937 world, class_1657 player, class_2338 pos, class_2680 state, @Nullable class_2586 blockEntity, class_1799 tool) {
        super.method_9556(world, player, pos, state, blockEntity, tool);
        if (!world.field_9236) {
            world.method_8501(pos, class_2246.field_10164.method_9564());
            world.method_43276(class_5712.field_28167, pos, class_5712.class_7397.method_43287(class_2246.field_10164.method_9564()));
        }
    }
}
