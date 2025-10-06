package leaf.iceandfire.block.type;

import com.mojang.serialization.MapCodec;
import leaf.iceandfire.block.ModBlockEntities;
import net.minecraft.class_1264;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2343;
import net.minecraft.class_2350;
import net.minecraft.class_2363;
import net.minecraft.class_2415;
import net.minecraft.class_2470;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3468;
import net.minecraft.class_3908;
import net.minecraft.class_4970;
import net.minecraft.class_5558;

public class TemperatureFurnaceBlock extends class_2363 implements class_2343 {
    public static final class_2769<class_2350> FACING = class_2741.field_12481;
    public static final MapCodec<TemperatureFurnaceBlock> CODEC = method_54094(TemperatureFurnaceBlock::new);

    public TemperatureFurnaceBlock(class_4970.class_2251 settings) {
        super(settings);
        method_9590((class_2680) ((class_2680) this.field_10647.method_11664().method_11657(FACING, class_2350.field_11043)).method_11657(field_11105, false));
    }

    protected MapCodec<? extends class_2363> method_53969() {
        return CODEC;
    }

    protected void method_17025(class_1937 world, class_2338 pos, class_1657 player) {
        TemperatureFurnaceBlockEntity temperatureFurnaceBlockEntityMethod_8321 = world.method_8321(pos);
        if (temperatureFurnaceBlockEntityMethod_8321 instanceof TemperatureFurnaceBlockEntity) {
            player.method_17355(temperatureFurnaceBlockEntityMethod_8321);
            player.method_7281(class_3468.field_15379);
        }
    }

    public class_3908 method_17454(class_2680 state, class_1937 world, class_2338 pos) {
        TemperatureFurnaceBlockEntity temperatureFurnaceBlockEntityMethod_8321 = world.method_8321(pos);
        if (temperatureFurnaceBlockEntityMethod_8321 instanceof TemperatureFurnaceBlockEntity) {
            return temperatureFurnaceBlockEntityMethod_8321;
        }
        return null;
    }

    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new TemperatureFurnaceBlockEntity(pos, state);
    }

    public void method_66388(class_2680 state, class_3218 world, class_2338 pos, boolean moved) {
        TemperatureFurnaceBlockEntity temperatureFurnaceBlockEntityMethod_8321 = world.method_8321(pos);
        if (temperatureFurnaceBlockEntityMethod_8321 instanceof TemperatureFurnaceBlockEntity) {
            class_1264.method_5451(world, pos, temperatureFurnaceBlockEntityMethod_8321);
            world.method_8455(pos, this);
        }
        super.method_66388(state, world, pos, moved);
    }

    public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
        if (type == ModBlockEntities.TEMPERATURE_FURNACE_BLOCK_ENTITY && !world.field_9236) {
            return TemperatureFurnaceBlockEntity::tick;
        }
        return null;
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{FACING});
        builder.method_11667(new class_2769[]{field_11105});
    }

    public class_2680 method_9605(class_1750 ctx) {
        class_2350 direction;
        class_2350 direction2 = ctx.method_7715();
        if (direction2.method_10166() == class_2350.class_2351.field_11052) {
            direction2 = ctx.method_8042().method_10153();
        }
        if (direction2.method_10166() != class_2350.class_2351.field_11052) {
            direction = direction2.method_10153();
        } else {
            direction = ctx.method_8042().method_10153();
        }
        return (class_2680) method_9564().method_11657(FACING, direction);
    }

    public class_2680 method_9598(class_2680 state, class_2470 rotation) {
        return (class_2680) state.method_11657(FACING, rotation.method_10503(state.method_11654(FACING)));
    }

    public class_2680 method_9569(class_2680 state, class_2415 mirror) {
        return state.method_26186(mirror.method_10345(state.method_11654(FACING)));
    }
}
