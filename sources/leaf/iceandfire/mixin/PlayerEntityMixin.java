package leaf.iceandfire.mixin;

import leaf.iceandfire.item.ModItems;
import net.minecraft.class_1282;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_8103;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1657.class})
public abstract class PlayerEntityMixin extends class_1309 {
    protected PlayerEntityMixin(class_1299<? extends class_1309> entityType, class_1937 world) {
        super(entityType, world);
    }

    @Inject(method = {"isInvulnerableTo"}, at = {@At("HEAD")}, cancellable = true)
    private void onIsInvulnerableTo(class_3218 world, class_1282 source, CallbackInfoReturnable<Boolean> cir) {
        if (isWearingFullBathingFireArmor() && source.method_48789(class_8103.field_42246)) {
            cir.setReturnValue(true);
        }
    }

    @Unique
    private boolean isWearingFullBathingFireArmor() {
        int count = 0;
        class_1799 helmet = method_6118(class_1304.field_6169);
        if (helmet.method_7909() == ModItems.BATHING_FIRE_HELMET) {
            count = 0 + 1;
        } else if (!helmet.method_7960()) {
            return false;
        }
        class_1799 chestplate = method_6118(class_1304.field_6174);
        if (chestplate.method_7909() == ModItems.BATHING_FIRE_CHESTPLATE) {
            count++;
        } else if (!chestplate.method_7960()) {
            return false;
        }
        class_1799 leggings = method_6118(class_1304.field_6172);
        if (leggings.method_7909() == ModItems.BATHING_FIRE_LEGGINGS) {
            count++;
        } else if (!leggings.method_7960()) {
            return false;
        }
        class_1799 boots = method_6118(class_1304.field_6166);
        if (boots.method_7909() == ModItems.BATHING_FIRE_BOOTS) {
            count++;
        } else if (!boots.method_7960()) {
            return false;
        }
        return count == 4;
    }
}
