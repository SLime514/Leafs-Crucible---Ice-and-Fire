package leaf.iceandfire.mixin;

import java.util.List;
import java.util.Optional;
import leaf.iceandfire.component.ModComponentTypes;
import leaf.iceandfire.item.ModItems;
import leaf.iceandfire.recipe.BathingFireDropRecipeInput;
import leaf.iceandfire.recipe.BathingFireDropRecipeType;
import leaf.iceandfire.recipe.ModRecipes;
import leaf.iceandfire.recipe.bathingfire.BathingFireRecipe;
import leaf.iceandfire.recipe.bathingfire.BathingFireRecipeInput;
import net.minecraft.class_10215;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1863;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_8103;
import net.minecraft.class_8786;
import net.minecraft.class_9334;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1542.class})
public class ItemEntityMixin {

    @Unique
    boolean wasInLava = false;

    @Unique
    class_1863.class_7266<BathingFireDropRecipeInput, BathingFireDropRecipeType> bathingFireDropRecipeGetter;

    @Unique
    class_1863.class_7266<BathingFireRecipeInput, BathingFireRecipe> bathingFireRecipeGetter;

    @Inject(method = {"tick"}, at = {@At("HEAD")})
    private void onTick(CallbackInfo ci) {
        if (this.bathingFireDropRecipeGetter == null) {
            this.bathingFireDropRecipeGetter = class_1863.method_42302(ModRecipes.BATHING_FIRE_DROP_RECIPE_TYPE);
        }
        if (this.bathingFireRecipeGetter == null) {
            this.bathingFireRecipeGetter = class_1863.method_42302(ModRecipes.BATHING_FIRE_RECIPE_TYPE);
        }
        class_1542 entity = (class_1542) this;
        class_1937 world = entity.method_37908();
        class_2338 pos = entity.method_24515();
        boolean isInLava = world.method_8320(pos).method_27852(class_2246.field_10164);
        class_1799 stack = entity.method_6983();
        bathingFire(entity, world, pos, isInLava);
        checkBathingFireComponent(entity, world, stack, isInLava);
        processBathingFireRecipes(entity, world);
        transformInSpecialEnvironment(entity, world, pos, stack, new class_1792[]{class_1802.field_8155, class_1802.field_27063}, ModItems.FROST_CRYSTAL, 10, class_3417.field_15081, 1.5f, class_2398.field_11228);
        transformInSpecialEnvironment(entity, world, pos, stack, new class_1792[]{ModItems.FROST_CRYSTAL}, ModItems.ICE_SOUL, 1, class_3417.field_15081, 1.5f, class_2398.field_11228);
        transformInSpecialEnvironment(entity, world, pos, stack, new class_1792[]{class_1802.field_8600}, ModItems.FROST_STICK, 1, class_3417.field_15081, 1.5f, class_2398.field_11228);
        transformInSpecialEnvironment(entity, world, pos, stack, new class_1792[]{class_1802.field_8543}, ModItems.FROST_PEARL, 1, class_3417.field_15081, 1.5f, class_2398.field_11228);
        transformInSpecialEnvironment(entity, world, pos, stack, new class_1792[]{class_1802.field_8477}, ModItems.FROST_DIAMOND, 1, class_3417.field_15081, 1.5f, class_2398.field_11228);
        restoreDurabilityWithComponent(entity, world);
    }

    @Unique
    private void bounceInLava(class_1542 entity, class_1937 world) {
        entity.method_18800((world.field_9229.method_43057() * 0.2f) - 0.1f, 0.800000011920929d, (world.field_9229.method_43057() * 0.2f) - 0.1f);
    }

    @Unique
    private void bathingFire(class_1542 entity, class_1937 world, class_2338 pos, boolean isInLava) {
        if (world.field_9236) {
            return;
        }
        class_1799 stack = entity.method_6983();
        if (isInLava) {
            Optional<class_8786<BathingFireRecipe>> optional = this.bathingFireRecipeGetter.method_42303(new BathingFireRecipeInput(stack), (class_3218) world);
            if (optional.isPresent()) {
                class_1799 newItemStack = ((BathingFireRecipe) optional.get().comp_1933()).getResult();
                if (world.field_9229.method_43048(10) >= 5) {
                    newItemStack.method_57379(class_9334.field_54273, new class_10215(class_8103.field_42246));
                    entity.method_6979(newItemStack);
                    bounceInLava(entity, world);
                    this.wasInLava = true;
                }
                world.method_8396((class_1297) null, pos, class_3417.field_19198, class_3419.field_15245, 0.8f, 1.0f);
                for (int i = 0; i < 5; i++) {
                    world.method_8406(class_2398.field_11239, entity.method_23317(), entity.method_23318(), entity.method_23321(), 0.0d, 0.1d, 0.0d);
                }
            }
        }
    }

    @Unique
    private void checkBathingFireComponent(class_1542 entity, class_1937 world, class_1799 stack, boolean isInLava) {
        if (stack.method_58694(ModComponentTypes.BATHING_FIRE) != null && ((Integer) stack.method_58694(ModComponentTypes.BATHING_FIRE)).intValue() == 1 && !isInLava && world.field_9236) {
            world.method_8406(class_2398.field_11240, entity.method_23317() + ((world.field_9229.method_43058() - 0.5d) * 0.2d), entity.method_23318() + ((world.field_9229.method_43058() - 0.5d) * 0.2d), entity.method_23321() + ((world.field_9229.method_43058() - 0.5d) * 0.2d), (world.field_9229.method_43058() - 0.5d) * 0.1d, world.field_9229.method_43058() * 0.1d, (world.field_9229.method_43058() - 0.5d) * 0.1d);
        }
    }

    @Unique
    private void processBathingFireRecipes(class_1542 entity, class_1937 world) {
        if (world.field_9236) {
            return;
        }
        class_238 searchBox = entity.method_5829().method_1014(1.0d);
        List<class_1542> nearbyItems = world.method_8390(class_1542.class, searchBox, otherEntity -> {
            return otherEntity != entity;
        });
        for (class_1542 otherEntity2 : nearbyItems) {
            class_1799 firstStack = entity.method_6983();
            class_1799 secondStack = otherEntity2.method_6983();
            BathingFireDropRecipeInput recipeInput = new BathingFireDropRecipeInput(firstStack, secondStack);
            Optional<class_8786<BathingFireDropRecipeType>> recipeEntry1 = this.bathingFireDropRecipeGetter.method_42303(recipeInput, (class_3218) world);
            if (recipeEntry1.isPresent()) {
                BathingFireDropRecipeType fireRecipe = (BathingFireDropRecipeType) recipeEntry1.get().comp_1933();
                firstStack.method_7934(1);
                secondStack.method_7934(1);
                if (firstStack.method_7960()) {
                    entity.method_31472();
                }
                if (secondStack.method_7960()) {
                    otherEntity2.method_31472();
                }
                if (world.field_9229.method_43057() < fireRecipe.getChance().floatValue()) {
                    class_1799 resultStack = fireRecipe.method_8116(recipeInput, world.method_30349());
                    class_1542 resultEntity = new class_1542(world, (entity.method_23317() + otherEntity2.method_23317()) / 2.0d, (entity.method_23318() + otherEntity2.method_23318()) / 2.0d, (entity.method_23321() + otherEntity2.method_23321()) / 2.0d, resultStack);
                    world.method_8649(resultEntity);
                    world.method_8396((class_1297) null, resultEntity.method_24515(), class_3417.field_19198, class_3419.field_15245, 0.8f, 1.0f);
                    for (int i = 0; i < 5; i++) {
                        ((class_3218) world).method_65096(class_2398.field_11239, resultEntity.method_23317(), resultEntity.method_23318(), resultEntity.method_23321(), 5, 0.1d, 0.0d, 0.0d, 0.1d);
                    }
                }
            }
        }
    }

    @Unique
    private void transformInSpecialEnvironment(class_1542 entity, class_1937 world, class_2338 pos, class_1799 stack, class_1792[] inputItems, class_1792 outputItem, int chancePercent, class_3414 transformSound, float soundPitch, class_2394 particleEffect) {
        boolean isInWater = entity.method_5799();
        boolean isNearEnvironmentBlock = world.method_8320(pos.method_10095()).method_27852(class_2246.field_10295) || world.method_8320(pos.method_10072()).method_27852(class_2246.field_10295) || world.method_8320(pos.method_10078()).method_27852(class_2246.field_10295) || world.method_8320(pos.method_10067()).method_27852(class_2246.field_10295) || world.method_8320(pos.method_10084()).method_27852(class_2246.field_10295) || world.method_8320(pos.method_10074()).method_27852(class_2246.field_10295);
        boolean isTransformableItem = false;
        int length = inputItems.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            class_1792 inputItem = inputItems[i];
            if (!stack.method_31574(inputItem)) {
                i++;
            } else {
                isTransformableItem = true;
                break;
            }
        }
        if (isInWater && isNearEnvironmentBlock && isTransformableItem && world.field_9229.method_43048(100) < chancePercent) {
            class_1799 resultStack = new class_1799(outputItem);
            resultStack.method_7939(stack.method_7947());
            entity.method_6979(resultStack);
            world.method_8396((class_1297) null, pos, transformSound, class_3419.field_15245, 0.8f, soundPitch);
            if (world.field_9236) {
                for (int i2 = 0; i2 < 10; i2++) {
                    world.method_8406(particleEffect, entity.method_23317() + ((world.field_9229.method_43058() - 0.5d) * 0.5d), entity.method_23318() + ((world.field_9229.method_43058() - 0.5d) * 0.5d), entity.method_23321() + ((world.field_9229.method_43058() - 0.5d) * 0.5d), (world.field_9229.method_43058() - 0.5d) * 0.1d, world.field_9229.method_43058() * 0.1d, (world.field_9229.method_43058() - 0.5d) * 0.1d);
                }
            }
        }
    }

    @Unique
    private void restoreDurabilityWithComponent(class_1542 entity, class_1937 world) {
        class_1799 stack = entity.method_6983();
        if (stack.method_58694(ModComponentTypes.FROST_REPAIRABLE) != null && ((Integer) stack.method_58694(ModComponentTypes.FROST_REPAIRABLE)).intValue() == 1 && stack.method_7919() > 0) {
            class_238 searchBox = entity.method_5829().method_1014(2.0d);
            List<class_1542> nearbyRepairItems = world.method_8390(class_1542.class, searchBox, otherEntity -> {
                if (otherEntity == entity) {
                    return false;
                }
                class_1799 otherStack = otherEntity.method_6983();
                return otherStack.method_58694(ModComponentTypes.FROST_ENERGY) != null && ((Integer) otherStack.method_58694(ModComponentTypes.FROST_ENERGY)).intValue() > 0;
            });
            if (!nearbyRepairItems.isEmpty() && world.method_8510() % 100 == 0) {
                int totalRepairEnergy = 0;
                for (class_1542 repairItemEntity : nearbyRepairItems) {
                    class_1799 repairStack = repairItemEntity.method_6983();
                    if (repairStack.method_58694(ModComponentTypes.FROST_ENERGY) != null) {
                        totalRepairEnergy += ((Integer) repairStack.method_58694(ModComponentTypes.FROST_ENERGY)).intValue() * repairStack.method_7947();
                    }
                }
                int restoreAmount = totalRepairEnergy / 5;
                if (restoreAmount > 0) {
                    int newDamage = Math.max(0, stack.method_7919() - restoreAmount);
                    stack.method_7974(newDamage);
                    int energyConsumed = Math.min(restoreAmount * 5, totalRepairEnergy);
                    consumeFrostEnergy(nearbyRepairItems, energyConsumed);
                    if (!world.field_9236) {
                        world.method_43128((class_1297) null, entity.method_23317(), entity.method_23318(), entity.method_23321(), class_3417.field_15081, class_3419.field_15245, 0.5f, 2.0f);
                    }
                    if (world.field_9236) {
                        for (int i = 0; i < 5; i++) {
                            world.method_8406(class_2398.field_11228, entity.method_23317() + ((world.field_9229.method_43058() - 0.5d) * 0.5d), entity.method_23318() + ((world.field_9229.method_43058() - 0.5d) * 0.5d), entity.method_23321() + ((world.field_9229.method_43058() - 0.5d) * 0.5d), (world.field_9229.method_43058() - 0.5d) * 0.05d, world.field_9229.method_43058() * 0.05d, (world.field_9229.method_43058() - 0.5d) * 0.05d);
                        }
                    }
                }
            }
        }
    }

    @Unique
    private void consumeFrostEnergy(List<class_1542> frostItems, int energyToConsume) {
        for (class_1542 frostItemEntity : frostItems) {
            if (energyToConsume > 0) {
                class_1799 frostStack = frostItemEntity.method_6983();
                int stackEnergy = 0;
                if (frostStack.method_58694(ModComponentTypes.FROST_ENERGY) != null) {
                    stackEnergy = ((Integer) frostStack.method_58694(ModComponentTypes.FROST_ENERGY)).intValue() * frostStack.method_7947();
                }
                if (stackEnergy <= energyToConsume) {
                    frostItemEntity.method_31472();
                    energyToConsume -= stackEnergy;
                } else if (frostStack.method_58694(ModComponentTypes.FROST_ENERGY) != null) {
                    int energyPerItem = ((Integer) frostStack.method_58694(ModComponentTypes.FROST_ENERGY)).intValue();
                    int itemsToConsume = Math.min((int) Math.ceil(energyToConsume / energyPerItem), frostStack.method_7947());
                    frostStack.method_7934(itemsToConsume);
                    if (frostStack.method_7960()) {
                        frostItemEntity.method_31472();
                    }
                    energyToConsume -= itemsToConsume * energyPerItem;
                }
            } else {
                return;
            }
        }
    }
}
