package leaf.iceandfire.itemgroup;

import leaf.iceandfire.block.ModBlocks;
import leaf.iceandfire.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2561;

public class BathingFireItemGroup {
    public static final class_1761 BATHING_FIRE_GROUP = FabricItemGroup.builder().method_47320(() -> {
        return new class_1799(ModItems.BATHING_FIRE_POWDER);
    }).method_47321(class_2561.method_43471("itemGroup.leafs-crucible.bathing_fire_group")).method_47317((context, entries) -> {
        entries.method_45421(ModItems.BATHING_FIRE_ROD);
        entries.method_45421(ModItems.MAGMA_EYE);
        entries.method_45421(ModItems.MAGMA_PEARL);
        entries.method_45421(ModItems.MAGMA_SWORD);
        entries.method_45421(ModItems.MAGMA_PICKAXE);
        entries.method_45421(ModItems.MAGMA_WAND);
        entries.method_45421(ModItems.BATHING_FIRE_POWDER);
        entries.method_45421(ModBlocks.MAGMA_ROCK_ITEM);
        entries.method_45421(ModItems.MAGMA_AXE);
        entries.method_45421(ModItems.BATHING_FIRE_HELMET);
        entries.method_45421(ModItems.BATHING_FIRE_CHESTPLATE);
        entries.method_45421(ModItems.BATHING_FIRE_LEGGINGS);
        entries.method_45421(ModItems.BATHING_FIRE_BOOTS);
    }).method_47324();
}
