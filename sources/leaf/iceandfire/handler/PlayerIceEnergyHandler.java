package leaf.iceandfire.handler;

import java.util.Iterator;
import leaf.iceandfire.item.ModItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_3532;

public class PlayerIceEnergyHandler {
    public static void initialize() {
        ServerTickEvents.START_WORLD_TICK.register(world -> {
            for (class_1657 player : world.method_18456()) {
                handlePlayerIceEnergy(player);
            }
        });
    }

    private static void handlePlayerIceEnergy(class_1657 player) {
        int iceSoulCount;
        if (!player.method_7325() && !player.method_68878() && (iceSoulCount = countIceSouls(player)) > 0 && player.method_7344().method_7586() < 20 && player.field_6012 % 60 == 0) {
            int restoreAmount = class_3532.method_15340(iceSoulCount, 0, 3);
            player.method_7344().method_7585(restoreAmount, 0.1f);
        }
    }

    private static int countIceSouls(class_1657 player) {
        int count = 0;
        Iterator it = player.method_31548().method_67533().iterator();
        while (it.hasNext()) {
            class_1799 stack = (class_1799) it.next();
            if (stack.method_31574(ModItems.ICE_SOUL)) {
                count += stack.method_7947();
            }
        }
        class_1799 offhandStack = player.method_6079();
        if (offhandStack.method_31574(ModItems.ICE_SOUL)) {
            count += offhandStack.method_7947();
        }
        return count;
    }
}
