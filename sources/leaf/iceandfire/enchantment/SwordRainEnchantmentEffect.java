package leaf.iceandfire.enchantment;

import leaf.iceandfire.entity.type.SwordRainEntity;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_3218;

public class SwordRainEnchantmentEffect {
    public static boolean shouldTriggerSwordRain(class_1799 bowStack, int useTime) {
        return useTime >= 30;
    }

    public static void triggerSwordRain(class_1937 world, class_1657 player, class_243 targetPos) {
        if (world.field_9236) {
            return;
        }
        spawnSwordRainAtPosition((class_3218) world, targetPos, player);
    }

    private static void spawnSwordRainAtPosition(class_3218 world, class_243 position, class_1657 owner) {
        for (int i = 0; i < 8; i++) {
            double offsetX = (world.field_9229.method_43058() - 0.5d) * 6.0d;
            double offsetZ = (world.field_9229.method_43058() - 0.5d) * 6.0d;
            SwordRainEntity swordRainEntity = new SwordRainEntity(world, owner, position.field_1352 + offsetX, position.field_1350 + offsetZ);
            swordRainEntity.method_5814(position.field_1352 + offsetX, position.field_1351 + 15.0d, position.field_1350 + offsetZ);
            world.method_8649(swordRainEntity);
        }
    }
}
