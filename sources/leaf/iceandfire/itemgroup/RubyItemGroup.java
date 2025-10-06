package leaf.iceandfire.itemgroup;

import leaf.iceandfire.block.ModBlocks;
import leaf.iceandfire.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2561;

public class RubyItemGroup {
    public static final class_1761 RUBY_GROUP = FabricItemGroup.builder().method_47320(() -> {
        return new class_1799(ModItems.RUBY);
    }).method_47321(class_2561.method_43471("itemGroup.leafs-crucible.ruby_group")).method_47317((context, entries) -> {
        entries.method_45421(ModBlocks.NETHER_RUBY_ORE_ITEM);
        entries.method_45421(ModBlocks.RUBY_BLOCK_ITEM);
        entries.method_45421(ModItems.RUBY);
        entries.method_45421(ModItems.INLAID_RUBY);
        entries.method_45421(ModItems.RUBY_SWORD);
        entries.method_45421(ModItems.RUBY_PICKAXE);
        entries.method_45421(ModItems.RUBY_AXE);
        entries.method_45421(ModItems.RUBY_SHOVEL);
        entries.method_45421(ModItems.RUBY_HOE);
        entries.method_45421(ModItems.MAGMA_CORE);
        entries.method_45421(ModItems.BATHING_FIRE_UPGRADE_SMITHING_TEMPLATE);
        entries.method_45421(ModItems.INCOMPLETE_BATHING_FIRE_UPGRADE_SMITHING_TEMPLATE);
        entries.method_45421(ModItems.RUBY_HELMET);
        entries.method_45421(ModItems.RUBY_CHESTPLATE);
        entries.method_45421(ModItems.RUBY_LEGGINGS);
        entries.method_45421(ModItems.RUBY_BOOTS);
    }).method_47324();
}
