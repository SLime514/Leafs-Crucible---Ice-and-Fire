package leaf.iceandfire.item.type;

import leaf.iceandfire.entity.type.MagmaPearlEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3468;
import net.minecraft.class_5712;

public class MagmaPearlItem extends class_1792 {
    public MagmaPearlItem(class_1792.class_1793 settings) {
        super(settings);
    }

    public class_1269 method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        class_1799 itemStack = user.method_5998(hand);
        if (!world.field_9236) {
            MagmaPearlEntity pearlEntity = new MagmaPearlEntity(world, (class_1309) user);
            pearlEntity.method_16940(itemStack);
            pearlEntity.method_24919(user, user.method_36455(), user.method_36454(), 0.0f, 1.5f, 1.0f);
            world.method_8649(pearlEntity);
            world.method_43128((class_1297) null, user.method_23317(), user.method_23318(), user.method_23321(), class_3417.field_14757, class_3419.field_15254, 0.5f, 0.4f / ((world.method_8409().method_43057() * 0.4f) + 0.8f));
        }
        world.method_43275(user, class_5712.field_28161, user.method_19538());
        if (!user.method_31549().field_7477) {
            itemStack.method_7934(1);
        }
        user.method_7259(class_3468.field_15372.method_14956(this));
        return class_1269.field_5812;
    }
}
