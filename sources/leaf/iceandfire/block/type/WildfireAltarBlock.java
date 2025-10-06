package leaf.iceandfire.block.type;

import leaf.iceandfire.entity.ModEntities;
import leaf.iceandfire.entity.type.WildfireEntity;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_3730;
import net.minecraft.class_3965;
import net.minecraft.class_4970;

public class WildfireAltarBlock extends class_2248 {
    public WildfireAltarBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    public class_1269 method_55766(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_3965 hit) {
        if (!world.field_9236) {
            transformRoom(world, pos);
            class_2338 spawnPos = pos.method_10086(3);
            WildfireEntity wildfire = ModEntities.WILDFIRE_ENTITY.method_5883(world, class_3730.field_16461);
            if (wildfire != null) {
                wildfire.method_5725(spawnPos, 0.0f, 0.0f);
                world.method_8649(wildfire);
                player.method_7353(class_2561.method_43470("Wildfire Boss has been summoned!"), true);
            }
            world.method_8501(pos, class_2246.field_10124.method_9564());
        }
        return class_1269.field_5812;
    }

    private void transformRoom(class_1937 world, class_2338 altarPos) {
        for (int x = -8; x <= 8; x++) {
            for (int y = -2; y <= 4; y++) {
                for (int z = -8; z <= 8; z++) {
                    class_2338 pos = altarPos.method_10069(x, y, z);
                    class_2680 state = world.method_8320(pos);
                    if (state.method_27852(class_2246.field_10364) || state.method_27852(class_2246.field_10390) || state.method_27852(class_2246.field_9974)) {
                        world.method_8501(pos, class_2246.field_10124.method_9564());
                    }
                    if (y == -2 && state.method_27852(class_2246.field_10266) && Math.abs(x) > 2 && Math.abs(z) > 2 && world.field_9229.method_43048(3) == 0) {
                        world.method_8501(pos.method_10084(), class_2246.field_10164.method_9564());
                    }
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            double angle = (i * 3.141592653589793d) / 2.0d;
            int x2 = (int) Math.round(Math.cos(angle) * 3.0d);
            int z2 = (int) Math.round(Math.sin(angle) * 3.0d);
            class_2338 torchPos = altarPos.method_10069(x2, 1, z2);
            if (world.method_8320(torchPos).method_26215()) {
                world.method_8501(torchPos, class_2246.field_10099.method_9564());
            }
        }
    }
}
