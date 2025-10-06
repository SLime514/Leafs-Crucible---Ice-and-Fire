package leaf.iceandfire.item.type;

import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1743;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2398;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3481;
import net.minecraft.class_9886;

public class MagmaAxeItem extends class_1743 {
    public MagmaAxeItem(class_9886 material, float attackDamage, float attackSpeed, class_1792.class_1793 settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public boolean method_7879(class_1799 stack, class_1937 world, class_2680 state, class_2338 pos, class_1309 miner) {
        if (!world.field_9236 && state.method_26214(world, pos) != 0.0f && (miner instanceof class_1657)) {
            class_1657 player = (class_1657) miner;
            if ((player.method_6047().method_7909() == this || player.method_6079().method_7909() == this) && isLog(state)) {
                if (world.field_9229.method_43057() < 0.3f) {
                    class_1542 itemEntity = new class_1542(world, pos.method_10263() + 0.5d, pos.method_10264() + 0.5d, pos.method_10260() + 0.5d, new class_1799(class_1802.field_8713));
                    world.method_8649(itemEntity);
                }
                for (int i = 0; i < 5; i++) {
                    ((class_3218) world).method_65096(class_2398.field_11237, pos.method_10263() + 0.5d + ((world.field_9229.method_43058() - 0.5d) * 0.5d), pos.method_10264() + 0.5d + ((world.field_9229.method_43058() - 0.5d) * 0.5d), pos.method_10260() + 0.5d + ((world.field_9229.method_43058() - 0.5d) * 0.5d), 1, 0.0d, 0.05d, 0.0d, 0.0d);
                }
            }
        }
        return super.method_7879(stack, world, state, pos, miner);
    }

    private boolean isLog(class_2680 state) {
        class_2248 block = state.method_26204();
        return block.method_8389() != null && (state.method_26164(class_3481.field_15482) || state.method_26164(class_3481.field_15498) || state.method_26164(class_3481.field_15489) || state.method_26164(class_3481.field_15474) || state.method_26164(class_3481.field_15458) || state.method_26164(class_3481.field_15485) || state.method_26164(class_3481.field_37401) || state.method_26164(class_3481.field_21955));
    }
}
