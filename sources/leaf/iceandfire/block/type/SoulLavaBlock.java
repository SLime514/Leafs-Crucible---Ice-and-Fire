package leaf.iceandfire.block.type;

import leaf.iceandfire.fluid.ModFluids;
import net.minecraft.class_10774;
import net.minecraft.class_1282;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2404;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_4970;

public class SoulLavaBlock extends class_2404 {
    public SoulLavaBlock(class_4970.class_2251 settings) {
        super(ModFluids.SOUL_LAVA, settings);
    }

    public void method_9548(class_2680 state, class_1937 world, class_2338 pos, class_1297 entity, class_10774 handler) {
        if (entity instanceof class_1309) {
            class_1309 livingEntity = (class_1309) entity;
            boolean hasFireResistance = livingEntity.method_6059(class_1294.field_5918);
            float damage = hasFireResistance ? 2.0f : 10.0f;
            if (!world.field_9236) {
                class_1282 soulLavaDamage = hasFireResistance ? world.method_48963().method_48831() : world.method_48963().method_48817();
                livingEntity.method_64397((class_3218) world, soulLavaDamage, damage);
                if (!livingEntity.method_5753()) {
                    livingEntity.method_56073(300);
                }
            }
        }
        super.method_9548(state, world, pos, entity, handler);
    }
}
