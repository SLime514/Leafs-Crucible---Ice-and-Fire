package leaf.iceandfire.fluid;

import com.google.common.collect.UnmodifiableIterator;
import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.fluid.type.SoulLavaFluid;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3609;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;

public class ModFluids {
    public static class_3609 SOUL_LAVA = register("soul_lava", new SoulLavaFluid.Still());
    public static class_3609 FLOWING_SOUL_LAVA = register("flowing_soul_lava", new SoulLavaFluid.Flowing());

    static {
        for (class_3611 fluid : class_7923.field_41173) {
            UnmodifiableIterator it = fluid.method_15783().method_11662().iterator();
            while (it.hasNext()) {
                class_3610 fluidState = (class_3610) it.next();
                class_3611.field_15904.method_10205(fluidState);
            }
        }
    }

    private static class_5321<class_3611> keyOf(String id) {
        return class_5321.method_29179(class_7924.field_41270, class_2960.method_60655(LeafsCrucible.MOD_ID, id));
    }

    private static <T extends class_3611> T register(String id, T value) {
        return (T) class_2378.method_39197(class_7923.field_41173, keyOf(id), value);
    }

    public static void initialize() {
        LeafsCrucible.LOGGER.info("模组流体正在加载...");
    }
}
