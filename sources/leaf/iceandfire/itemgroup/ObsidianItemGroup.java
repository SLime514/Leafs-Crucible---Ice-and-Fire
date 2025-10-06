package leaf.iceandfire.itemgroup;

import leaf.iceandfire.block.ModBlocks;
import leaf.iceandfire.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;

public class ObsidianItemGroup {
    public static final class_1761 ObsidianItemGroup = FabricItemGroup.builder().method_47320(() -> {
        return new class_1799(ModItems.RAW_OBSIDIAN);
    }).method_47321(class_2561.method_43471("itemGroup.leafs-crucible.obsidian_group")).method_47317((context, entries) -> {
        entries.method_45421(ModItems.RAW_OBSIDIAN);
        entries.method_45421(ModItems.CRYING_RAW_OBSIDIAN);
        entries.method_45421(ModItems.MELT_RAW_OBSIDIAN);
        entries.method_45421(ModBlocks.TEMPERATURE_FURNACE_ITEM);
        entries.method_45421(class_1802.field_8281);
        entries.method_45421(ModItems.OBSIDIAN_STICK);
        entries.method_45421(ModItems.OBSIDIAN_HELMET);
        entries.method_45421(ModItems.OBSIDIAN_CHESTPLATE);
        entries.method_45421(ModItems.OBSIDIAN_LEGGINGS);
        entries.method_45421(ModItems.OBSIDIAN_BOOTS);
    }).method_47324();
}
