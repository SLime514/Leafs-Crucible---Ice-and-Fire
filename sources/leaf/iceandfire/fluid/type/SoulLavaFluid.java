package leaf.iceandfire.fluid.type;

import java.util.Optional;
import leaf.iceandfire.block.ModBlocks;
import leaf.iceandfire.fluid.ModFluids;
import leaf.iceandfire.item.ModItems;
import net.minecraft.class_10774;
import net.minecraft.class_10776;
import net.minecraft.class_1297;
import net.minecraft.class_1792;
import net.minecraft.class_1922;
import net.minecraft.class_1928;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2404;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3486;
import net.minecraft.class_3609;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_4538;
import net.minecraft.class_5819;

public abstract class SoulLavaFluid extends class_3609 {
    public static final float MIN_HEIGHT_TO_REPLACE = 0.44444445f;

    public class_3611 method_15750() {
        return ModFluids.FLOWING_SOUL_LAVA;
    }

    public class_3611 method_15751() {
        return ModFluids.SOUL_LAVA;
    }

    public class_1792 method_15774() {
        return ModItems.SOUL_LAVA_BUCKET;
    }

    public void method_15776(class_1937 world, class_2338 pos, class_3610 state, class_5819 random) {
        class_2338 blockPos = pos.method_10084();
        if (world.method_8320(blockPos).method_26215() && !world.method_8320(blockPos).method_26216()) {
            if (random.method_43048(100) == 0) {
                double d = pos.method_10263() + random.method_43058();
                double e = pos.method_10264() + 1.0d;
                double f = pos.method_10260() + random.method_43058();
                world.method_8406(class_2398.field_11239, d, e, f, 0.0d, 0.0d, 0.0d);
                world.method_8486(d, e, f, class_3417.field_14576, class_3419.field_15256, 0.2f + (random.method_43057() * 0.2f), 0.9f + (random.method_43057() * 0.15f), false);
            }
            if (random.method_43048(200) == 0) {
                world.method_8486(pos.method_10263(), pos.method_10264(), pos.method_10260(), class_3417.field_15021, class_3419.field_15256, 0.2f + (random.method_43057() * 0.2f), 0.9f + (random.method_43057() * 0.15f), false);
            }
        }
    }

    public void method_15792(class_3218 world, class_2338 pos, class_3610 state, class_5819 random) {
        if (world.method_64395().method_8355(class_1928.field_19387)) {
            if (world.method_64395().method_8355(class_1928.field_56559) || world.method_67506(pos)) {
                int i = random.method_43048(3);
                if (i > 0) {
                    class_2338 blockPos = pos;
                    for (int j = 0; j < i; j++) {
                        blockPos = blockPos.method_10069(random.method_43048(3) - 1, 1, random.method_43048(3) - 1);
                        if (!world.method_8477(blockPos)) {
                            return;
                        }
                        class_2680 blockState = world.method_8320(blockPos);
                        if (blockState.method_26215()) {
                            if (canLightFire(world, blockPos)) {
                                world.method_8501(blockPos, ModBlocks.SOUL_LAVA.method_9564());
                                return;
                            }
                        } else if (blockState.method_51366()) {
                            return;
                        }
                    }
                    return;
                }
                for (int k = 0; k < 3; k++) {
                    class_2338 blockPos2 = pos.method_10069(random.method_43048(3) - 1, 0, random.method_43048(3) - 1);
                    if (!world.method_8477(blockPos2)) {
                        return;
                    }
                    if (world.method_22347(blockPos2.method_10084()) && hasBurnableBlock(world, blockPos2)) {
                        world.method_8501(blockPos2.method_10084(), ModBlocks.SOUL_LAVA.method_9564());
                    }
                }
            }
        }
    }

    protected void method_67694(class_1937 world, class_2338 pos, class_1297 entity, class_10774 handler) {
        handler.method_67638(class_10776.field_56644);
        handler.method_67640(class_10776.field_56644, (v0) -> {
            v0.method_5730();
        });
    }

    private boolean canLightFire(class_4538 world, class_2338 pos) {
        for (class_2350 direction : class_2350.values()) {
            if (hasBurnableBlock(world, pos.method_10093(direction))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasBurnableBlock(class_4538 world, class_2338 pos) {
        return (!world.method_62871(pos.method_10264()) || world.method_22340(pos)) && world.method_8320(pos).method_50011();
    }

    public class_2394 method_15787() {
        return class_2398.field_11223;
    }

    protected void method_15730(class_1936 world, class_2338 pos, class_2680 state) {
        playExtinguishEvent(world, pos);
    }

    public int method_15733(class_4538 world) {
        return world.method_8597().comp_644() ? 4 : 2;
    }

    protected class_2680 method_15790(class_3610 state) {
        return (class_2680) ModBlocks.SOUL_LAVA.method_9564().method_11657(class_2404.field_11278, Integer.valueOf(method_15741(state)));
    }

    public boolean method_15780(class_3611 fluid) {
        return fluid == ModFluids.SOUL_LAVA || fluid == ModFluids.FLOWING_SOUL_LAVA;
    }

    public int method_15739(class_4538 world) {
        return world.method_8597().comp_644() ? 1 : 2;
    }

    public boolean method_15777(class_3610 state, class_1922 world, class_2338 pos, class_3611 fluid, class_2350 direction) {
        return state.method_15763(world, pos) >= 0.44444445f && fluid.method_15791(class_3486.field_15517);
    }

    public int method_15789(class_4538 world) {
        return world.method_8597().comp_644() ? 10 : 30;
    }

    public int method_15753(class_1937 world, class_2338 pos, class_3610 oldState, class_3610 newState) {
        int i = method_15789(world);
        if (!oldState.method_15769() && !newState.method_15769() && !((Boolean) oldState.method_11654(field_15902)).booleanValue() && !((Boolean) newState.method_11654(field_15902)).booleanValue() && newState.method_15763(world, pos) > oldState.method_15763(world, pos) && world.method_8409().method_43048(4) != 0) {
            i *= 4;
        }
        return i;
    }

    private void playExtinguishEvent(class_1936 world, class_2338 pos) {
        world.method_20290(1501, pos, 0);
    }

    protected boolean method_15737(class_3218 world) {
        return world.method_64395().method_8355(class_1928.field_40885);
    }

    protected void method_15745(class_1936 world, class_2338 pos, class_2680 state, class_2350 direction, class_3610 fluidState) {
        if (direction == class_2350.field_11033) {
            class_3610 fluidState2 = world.method_8316(pos);
            if (method_15791(class_3486.field_15518) && fluidState2.method_15767(class_3486.field_15517)) {
                if (state.method_26204() instanceof class_2404) {
                    world.method_8652(pos, ModBlocks.SOUL_LAVA.method_9564(), 3);
                }
                playExtinguishEvent(world, pos);
                return;
            }
        }
        super.method_15745(world, pos, state, direction, fluidState);
    }

    protected boolean method_15795() {
        return true;
    }

    protected float method_15784() {
        return 100.0f;
    }

    public Optional<class_3414> method_32359() {
        return Optional.of(class_3417.field_15202);
    }

    public static class Flowing extends SoulLavaFluid {
        protected void method_15775(class_2689.class_2690<class_3611, class_3610> builder) {
            super.method_15775(builder);
            builder.method_11667(new class_2769[]{class_2741.field_12490});
        }

        public int method_15779(class_3610 state) {
            return ((Integer) state.method_11654(class_2741.field_12490)).intValue();
        }

        public boolean method_15793(class_3610 state) {
            return false;
        }
    }

    public static class Still extends SoulLavaFluid {
        public int method_15779(class_3610 state) {
            return 8;
        }

        public boolean method_15793(class_3610 state) {
            return true;
        }
    }
}
