package leaf.iceandfire.handler;

import leaf.iceandfire.item.ModItems;
import leaf.iceandfire.item.type.FrostSwordItem;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;

public class FrostSwordDropHandler {
    public static void initialize() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((world, entity, killedEntity) -> {
            if ((world instanceof class_3218) && (killedEntity instanceof class_1309)) {
                handleEntityDeath(world, entity, killedEntity);
            }
        });
    }

    private static void handleEntityDeath(class_3218 world, class_1297 killer, class_1309 killedEntity) {
        if (killer instanceof class_1309) {
            class_1309 livingKiller = (class_1309) killer;
            class_1799 mainHandStack = livingKiller.method_6047();
            if ((mainHandStack.method_7909() instanceof FrostSwordItem) && world.method_8409().method_43057() < 0.15f) {
                dropIceSoul(world, killedEntity);
            }
        }
    }

    private static void dropIceSoul(class_3218 world, class_1309 killedEntity) {
        class_1799 iceSoulStack = new class_1799(ModItems.ICE_SOUL);
        class_243 pos = killedEntity.method_19538();
        class_1542 itemEntity = new class_1542(world, pos.field_1352, pos.field_1351 + 0.5d, pos.field_1350, iceSoulStack);
        itemEntity.method_18800((world.method_8409().method_43058() - 0.5d) * 0.2d, world.method_8409().method_43058() * 0.2d, (world.method_8409().method_43058() - 0.5d) * 0.2d);
        itemEntity.method_6982(10);
        world.method_8649(itemEntity);
        playIceEffect(world, pos);
    }

    private static void playIceEffect(class_3218 world, class_243 pos) {
        world.method_43128((class_1297) null, pos.field_1352, pos.field_1351, pos.field_1350, class_3417.field_15081, class_3419.field_15248, 0.8f, 1.5f);
        world.method_65096(class_2398.field_11228, pos.field_1352, pos.field_1351 + 0.5d, pos.field_1350, 15, 0.3d, 0.3d, 0.3d, 0.1d);
    }
}
