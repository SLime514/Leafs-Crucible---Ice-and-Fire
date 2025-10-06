package leaf.iceandfire.block.type;

import java.util.Iterator;
import java.util.Optional;
import leaf.iceandfire.block.ModBlockEntities;
import leaf.iceandfire.recipe.ModRecipes;
import leaf.iceandfire.recipe.TemperatureFurnaceRecipe;
import leaf.iceandfire.screen.type.TemperatureFurnaceScreenHandler;
import net.minecraft.class_1262;
import net.minecraft.class_1278;
import net.minecraft.class_1303;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1799;
import net.minecraft.class_1863;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2609;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3908;
import net.minecraft.class_7225;
import net.minecraft.class_8786;
import net.minecraft.class_9696;

public class TemperatureFurnaceBlockEntity extends class_2609 implements class_3908, class_1278 {
    private final class_2371<class_1799> inventory;
    private int temperature;
    private final class_1863.class_7266<class_9696, TemperatureFurnaceRecipe> recipeManager;

    public TemperatureFurnaceBlockEntity(class_2338 pos, class_2680 state) {
        super(ModBlockEntities.TEMPERATURE_FURNACE_BLOCK_ENTITY, pos, state, ModRecipes.TEMPERATURE_FURNACE_RECIPE_TYPE);
        this.inventory = class_2371.method_10213(TemperatureFurnaceScreenHandler.getSize(), class_1799.field_8037);
        this.temperature = 0;
        this.recipeManager = class_1863.method_42302(ModRecipes.TEMPERATURE_FURNACE_RECIPE_TYPE);
    }

    protected class_2561 method_17823() {
        return class_2561.method_43471("container.temperature_furnace");
    }

    protected class_1703 method_5465(int syncId, class_1661 playerInventory) {
        return new TemperatureFurnaceScreenHandler(syncId, playerInventory, this, this.field_11867, this);
    }

    public int method_5439() {
        return TemperatureFurnaceScreenHandler.getSize();
    }

    public boolean method_5442() {
        Iterator it = this.inventory.iterator();
        while (it.hasNext()) {
            class_1799 stack = (class_1799) it.next();
            if (!stack.method_7960()) {
                return false;
            }
        }
        return true;
    }

    public class_1799 method_5438(int slot) {
        return (class_1799) this.inventory.get(slot);
    }

    public class_1799 method_5434(int slot, int amount) {
        class_1799 result = class_1262.method_5430(this.inventory, slot, amount);
        if (!result.method_7960()) {
            method_5431();
        }
        return result;
    }

    public class_1799 method_5441(int slot) {
        return class_1262.method_5428(this.inventory, slot);
    }

    public void method_5447(int slot, class_1799 stack) {
        this.inventory.set(slot, stack);
        if (stack.method_7947() > method_5444()) {
            stack.method_7939(method_5444());
        }
        method_5431();
    }

    public boolean method_5443(class_1657 player) {
        return true;
    }

    public void method_5448() {
        this.inventory.clear();
    }

    public void method_11014(class_2487 nbt, class_7225.class_7874 registries) {
        super.method_11014(nbt, registries);
        class_1262.method_5429(nbt, this.inventory, registries);
        this.temperature = ((Integer) nbt.method_10550("Temperature").orElse(0)).intValue();
    }

    public void method_11007(class_2487 nbt, class_7225.class_7874 registries) {
        super.method_11007(nbt, registries);
        class_1262.method_5426(nbt, this.inventory, registries);
        nbt.method_10569("Temperature", this.temperature);
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = Math.max(-8, Math.min(8, temperature));
        method_5431();
        if (this.field_11863 != null && !this.field_11863.field_9236) {
            this.field_11863.method_8413(this.field_11867, this.field_11863.method_8320(this.field_11867), this.field_11863.method_8320(this.field_11867), 3);
        }
    }

    public void addTemperature(int amount) {
        this.temperature += amount;
        this.temperature = Math.max(-8, Math.min(8, this.temperature));
        method_5431();
        if (this.field_11863 != null && !this.field_11863.field_9236) {
            this.field_11863.method_8413(this.field_11867, this.field_11863.method_8320(this.field_11867), this.field_11863.method_8320(this.field_11867), 3);
        }
    }

    private Optional<class_8786<TemperatureFurnaceRecipe>> getMatchingRecipe(class_1799 input) {
        if (this.field_11863 == null) {
            return Optional.empty();
        }
        if (input.method_7960()) {
            return Optional.empty();
        }
        if (!this.field_11863.field_9236) {
            class_9696 recipeInput = new class_9696(input);
            Optional<class_8786<TemperatureFurnaceRecipe>> recipe = this.recipeManager.method_42303(recipeInput, this.field_11863);
            return recipe;
        }
        return Optional.empty();
    }

    private class_1799 getSmeltingResult(class_1799 input) {
        return (class_1799) getMatchingRecipe(input).map(recipeEntry -> {
            if (this.field_11863 != null) {
                return recipeEntry.comp_1933().getOutput(this.field_11863.method_30349());
            }
            return null;
        }).orElse(class_1799.field_8037);
    }

    private int getRequiredTemperature(class_1799 input) {
        return ((Integer) getMatchingRecipe(input).map(recipeEntry -> {
            return Integer.valueOf(recipeEntry.comp_1933().getTemperature());
        }).orElse(0)).intValue();
    }

    private float getExperience(class_1799 input) {
        return ((Float) getMatchingRecipe(input).map(recipeEntry -> {
            return Float.valueOf(recipeEntry.comp_1933().method_8171());
        }).orElse(Float.valueOf(0.0f))).floatValue();
    }

    private boolean hasRecipe(class_1799 input) {
        return getMatchingRecipe(input).isPresent();
    }

    private boolean isTemperatureMatch(class_1799 input) {
        int requiredTemperature = getRequiredTemperature(input);
        return this.temperature == requiredTemperature;
    }

    private boolean canAcceptOutput(class_1799 result, class_1799 existing) {
        if (existing.method_7960()) {
            return true;
        }
        return class_1799.method_7984(existing, result) && existing.method_7947() + result.method_7947() <= existing.method_7914();
    }

    public static <T extends class_2586> void tick(class_1937 world, class_2338 blockPos, class_2680 blockState, T t) {
        if (world.field_9236 || !(t instanceof TemperatureFurnaceBlockEntity)) {
            return;
        }
        TemperatureFurnaceBlockEntity entity = (TemperatureFurnaceBlockEntity) t;
        class_1799 inputStack = entity.method_5438(0);
        class_1799 outputStack = entity.method_5438(2);
        if (!inputStack.method_7960() && entity.hasRecipe(inputStack) && entity.isTemperatureMatch(inputStack)) {
            class_1799 result = entity.getSmeltingResult(inputStack);
            if (entity.canAcceptOutput(result, outputStack)) {
                if (outputStack.method_7960()) {
                    entity.method_5447(2, result.method_7972());
                } else if (class_1799.method_7984(outputStack, result)) {
                    outputStack.method_7933(result.method_7947());
                }
                float experience = entity.getExperience(inputStack);
                spawnExperience(world, blockPos, experience);
                inputStack.method_7934(1);
                while (!inputStack.method_7960() && entity.hasRecipe(inputStack) && entity.isTemperatureMatch(inputStack) && entity.canAcceptOutput(entity.getSmeltingResult(inputStack), entity.method_5438(2))) {
                    class_1799 nextResult = entity.getSmeltingResult(inputStack);
                    class_1799 currentOutput = entity.method_5438(2);
                    if (!entity.canAcceptOutput(nextResult, currentOutput)) {
                        break;
                    }
                    if (currentOutput.method_7960()) {
                        entity.method_5447(2, nextResult.method_7972());
                    } else if (class_1799.method_7984(currentOutput, nextResult)) {
                        currentOutput.method_7933(nextResult.method_7947());
                    }
                    float nextExperience = entity.getExperience(inputStack);
                    spawnExperience(world, blockPos, nextExperience);
                    inputStack.method_7934(1);
                }
                if (inputStack.method_7960()) {
                    entity.method_5447(0, class_1799.field_8037);
                }
                entity.method_5431();
            }
        }
    }

    private static void spawnExperience(class_1937 world, class_2338 pos, float experience) {
        if (world instanceof class_3218) {
            class_3218 serverWorld = (class_3218) world;
            int experienceAmount = (int) (experience * 10.0f);
            class_1303.method_31493(serverWorld, class_243.method_24953(pos.method_10084()), experienceAmount);
        }
    }

    public boolean method_5493(int slot, class_1799 stack, class_2350 dir) {
        return slot == 2 && dir == class_2350.field_11033;
    }

    public boolean method_5492(int slot, class_1799 stack, class_2350 dir) {
        return (slot != 0 || dir == class_2350.field_11036 || dir == class_2350.field_11033) ? false : true;
    }

    public int[] method_5494(class_2350 side) {
        if (side != class_2350.field_11036 && side != class_2350.field_11033) {
            return new int[]{0};
        }
        if (side == class_2350.field_11033) {
            return new int[]{2};
        }
        return new int[0];
    }
}
