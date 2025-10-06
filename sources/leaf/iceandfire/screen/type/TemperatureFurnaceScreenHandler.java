package leaf.iceandfire.screen.type;

import leaf.iceandfire.block.type.TemperatureFurnaceBlockEntity;
import leaf.iceandfire.component.ModComponentTypes;
import leaf.iceandfire.screen.ModScreenHandlers;
import net.minecraft.class_1263;
import net.minecraft.class_1277;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2338;
import net.minecraft.class_3913;
import net.minecraft.class_3919;

public class TemperatureFurnaceScreenHandler extends class_1703 {
    private final class_1263 inventory;
    private final class_2338 pos;
    private static final int INVENTORY_SIZE = 3;
    private final TemperatureFurnaceBlockEntity blockEntity;
    private final class_3913 propertyDelegate;

    public TemperatureFurnaceScreenHandler(int syncId, class_1661 playerInventory, class_1263 inventory, class_2338 pos, TemperatureFurnaceBlockEntity blockEntity) {
        super(ModScreenHandlers.TEMPERATURE_FURNACE_SCREEN_HANDLER, syncId);
        this.inventory = inventory;
        this.pos = pos;
        this.blockEntity = blockEntity;
        method_17359(inventory, INVENTORY_SIZE);
        method_7621(new class_1735(this, inventory, 0, 56, 17) {
            public void method_7668() {
                super.method_7668();
            }
        });
        method_7621(new class_1735(inventory, 1, 56, 53) {
            public boolean method_7680(class_1799 stack) {
                return stack.method_57353().method_58694(ModComponentTypes.TEMPERATURE) != null;
            }

            public void method_7668() {
                TemperatureFurnaceScreenHandler.this.FuelSlotChanged(TemperatureFurnaceScreenHandler.this.inventory.method_5438(1));
                super.method_7668();
            }
        });
        method_7621(new class_1735(this, inventory, 2, 116, 36) {
            public boolean method_7680(class_1799 stack) {
                return false;
            }

            public void method_7668() {
                super.method_7668();
            }
        });
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        this.propertyDelegate = new class_3919(1);
        if (this.blockEntity != null) {
            this.propertyDelegate.method_17391(0, this.blockEntity.getTemperature());
        }
        method_17360(this.propertyDelegate);
    }

    public TemperatureFurnaceScreenHandler(int syncId, class_1661 playerInventory, class_1263 inventory, class_2338 pos) {
        this(syncId, playerInventory, inventory, pos, null);
    }

    public TemperatureFurnaceScreenHandler(int syncId, class_1661 playerInventory) {
        this(syncId, playerInventory, new class_1277(INVENTORY_SIZE), class_2338.field_10980);
    }

    public class_1799 method_7601(class_1657 player, int invSlot) {
        class_1799 newStack = class_1799.field_8037;
        class_1735 slot = (class_1735) this.field_7761.get(invSlot);
        if (slot != null && slot.method_7681()) {
            class_1799 originalStack = slot.method_7677();
            newStack = originalStack.method_7972();
            if (invSlot < INVENTORY_SIZE) {
                if (!method_7616(originalStack, INVENTORY_SIZE, this.field_7761.size(), true)) {
                    return class_1799.field_8037;
                }
            } else if (!method_7616(originalStack, 0, INVENTORY_SIZE, false)) {
                return class_1799.field_8037;
            }
            if (originalStack.method_7960()) {
                slot.method_53512(class_1799.field_8037);
            } else {
                slot.method_7668();
            }
        }
        return newStack;
    }

    public boolean method_7597(class_1657 player) {
        return this.inventory.method_5443(player);
    }

    private void addPlayerInventory(class_1661 playerInventory) {
        for (int i = 0; i < INVENTORY_SIZE; i++) {
            for (int l = 0; l < 9; l++) {
                method_7621(new class_1735(playerInventory, l + (i * 9) + 9, 8 + (l * 18), 84 + (i * 18)));
            }
        }
    }

    private void addPlayerHotbar(class_1661 playerInventory) {
        for (int j = 0; j < 9; j++) {
            method_7621(new class_1735(playerInventory, j, 8 + (j * 18), 142));
        }
    }

    public class_2338 getPos() {
        return this.pos;
    }

    public static int getSize() {
        return INVENTORY_SIZE;
    }

    private void syncTemperature() {
        if (this.blockEntity != null && this.propertyDelegate != null) {
            int temp = this.blockEntity.getTemperature();
            this.propertyDelegate.method_17391(0, temp);
        }
    }

    public void FuelSlotChanged(class_1799 stack) {
        if (stack != null && !stack.method_7960() && stack != class_1799.field_8037) {
            Integer temperatureComponent = (Integer) stack.method_58694(ModComponentTypes.TEMPERATURE);
            if (this.blockEntity != null && temperatureComponent != null) {
                int currentTemperature = getTemperature();
                if ((currentTemperature >= -8 && temperatureComponent.intValue() > 0) || (currentTemperature <= 8 && temperatureComponent.intValue() < 0)) {
                    int temperaturePerItem = temperatureComponent.intValue();
                    int itemsToConsume = getItemsToConsume(stack, temperaturePerItem, currentTemperature);
                    int temperatureChange = temperaturePerItem * itemsToConsume;
                    int newTemperature = currentTemperature + temperatureChange;
                    this.blockEntity.setTemperature(newTemperature);
                    stack.method_7934(itemsToConsume);
                    syncTemperature();
                }
            }
        }
    }

    private static int getItemsToConsume(class_1799 stack, int temperaturePerItem, int currentTemperature) {
        int itemsAvailable = stack.method_7947();
        int itemsToConsume = 0;
        if (temperaturePerItem > 0) {
            int temperatureNeeded = 8 - currentTemperature;
            itemsToConsume = Math.min(itemsAvailable, temperatureNeeded / temperaturePerItem);
            if (itemsToConsume * temperaturePerItem < temperatureNeeded) {
                itemsToConsume = Math.min(itemsToConsume + 1, itemsAvailable);
            }
        } else if (temperaturePerItem < 0) {
            int temperatureNeeded2 = (-8) - currentTemperature;
            itemsToConsume = Math.min(itemsAvailable, Math.abs(temperatureNeeded2 / temperaturePerItem));
            if (itemsToConsume * temperaturePerItem > temperatureNeeded2) {
                itemsToConsume = Math.min(itemsToConsume + 1, itemsAvailable);
            }
        }
        if (itemsToConsume == 0 && ((temperaturePerItem > 0 && currentTemperature < 8) || (temperaturePerItem < 0 && currentTemperature > -8))) {
            itemsToConsume = 1;
        }
        return itemsToConsume;
    }

    public int getTemperature() {
        if (this.blockEntity != null) {
            int temp = this.blockEntity.getTemperature();
            return temp;
        }
        if (this.propertyDelegate != null) {
            int temp2 = this.propertyDelegate.method_17390(0);
            return temp2;
        }
        return 0;
    }

    public int getProperty(int index) {
        return this.propertyDelegate.method_17390(index);
    }

    public boolean hasPropertyDelegate() {
        return this.propertyDelegate != null;
    }
}
