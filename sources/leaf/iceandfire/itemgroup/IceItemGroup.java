package leaf.iceandfire.itemgroup;

import leaf.iceandfire.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2561;

public class IceItemGroup {
    public static final class_1761 IceItemGroup = FabricItemGroup.builder().method_47320(() -> {
        return new class_1799(ModItems.FROST_CRYSTAL);
    }).method_47321(class_2561.method_43471("itemGroup.leafs-crucible.ice_group")).method_47317((context, entries) -> {
        entries.method_45421(ModItems.FROST_CRYSTAL);
        entries.method_45421(ModItems.ICE_SOUL);
        entries.method_45421(ModItems.FROST_CORE);
        entries.method_45421(ModItems.FROST_SWORD);
        entries.method_45421(ModItems.FROST_WAND);
        entries.method_45421(ModItems.FROST_STICK);
        entries.method_45421(ModItems.FROST_PEARL);
        entries.method_45421(ModItems.FROST_BOW);
        entries.method_45421(ModItems.FROST_DIAMOND);
        entries.method_45421(ModItems.FROST_INGOT);
    }).method_47324();
}
