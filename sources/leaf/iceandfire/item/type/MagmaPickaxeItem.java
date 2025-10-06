package leaf.iceandfire.item.type;

import java.util.Optional;
import leaf.iceandfire.material.ModMaterials;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2398;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3481;
import net.minecraft.class_3861;
import net.minecraft.class_3956;
import net.minecraft.class_8786;
import net.minecraft.class_9696;

public class MagmaPickaxeItem extends class_1792 {
    public MagmaPickaxeItem(class_1792.class_1793 settings) {
        super(settings.method_66330(ModMaterials.MAGMA_TOOL, 10.0f, 5.0f));
    }

    public boolean method_7879(class_1799 stack, class_1937 world, class_2680 state, class_2338 pos, class_1309 miner) {
        if (!world.field_9236 && state.method_26214(world, pos) != 0.0f && (miner instanceof class_1657)) {
            class_1657 player = (class_1657) miner;
            if ((player.method_6047().method_7909() == this || player.method_6079().method_7909() == this) && isSmeltableOre(state)) {
                smeltDrops(world, pos, state, player);
            }
        }
        return super.method_7879(stack, world, state, pos, miner);
    }

    private void smeltDrops(class_1937 world, class_2338 pos, class_2680 state, class_1657 player) {
        if (world instanceof class_3218) {
            class_3218 serverWorld = (class_3218) world;
            class_1799 blockItem = new class_1799(state.method_26204());
            Optional<class_8786<class_3861>> recipe = serverWorld.method_64577().method_8132(class_3956.field_17546, new class_9696(blockItem), serverWorld);
            if (recipe.isPresent()) {
                class_1799 smeltedResult = recipe.get().comp_1933().method_59998(new class_9696(blockItem), serverWorld.method_30349());
                float exp = recipe.get().comp_1933().method_8171();
                if (exp > 0.0f && (player instanceof class_3222)) {
                    class_3222 serverPlayer = (class_3222) player;
                    serverPlayer.method_7255(Math.round(exp));
                }
                class_1542 itemEntity = new class_1542(world, pos.method_10263() + 0.5d, pos.method_10264() + 0.5d, pos.method_10260() + 0.5d, smeltedResult);
                world.method_8649(itemEntity);
                for (int i = 0; i < 5; i++) {
                    serverWorld.method_65096(class_2398.field_11237, pos.method_10263() + 0.5d + ((world.field_9229.method_43058() - 0.5d) * 0.5d), pos.method_10264() + 0.5d + ((world.field_9229.method_43058() - 0.5d) * 0.5d), pos.method_10260() + 0.5d + ((world.field_9229.method_43058() - 0.5d) * 0.5d), 1, 0.0d, 0.05d, 0.0d, 0.0d);
                }
            }
        }
    }

    private boolean isSmeltableOre(class_2680 state) {
        class_2248 block = state.method_26204();
        return block.method_8389() != null && (state.method_26164(class_3481.field_28988) || state.method_26164(class_3481.field_29195) || state.method_26164(class_3481.field_23062) || state.method_26164(class_3481.field_29193) || state.method_26164(class_3481.field_28990) || state.method_26164(class_3481.field_28991) || state.method_26164(class_3481.field_28989) || state.method_26164(class_3481.field_29194) || state.method_27852(class_2246.field_33508) || state.method_27852(class_2246.field_33509) || state.method_27852(class_2246.field_33510));
    }
}
