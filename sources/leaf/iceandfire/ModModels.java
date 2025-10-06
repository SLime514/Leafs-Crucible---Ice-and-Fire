package leaf.iceandfire;

import leaf.iceandfire.block.ModBlocks;
import leaf.iceandfire.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.class_4910;
import net.minecraft.class_4915;
import net.minecraft.class_4943;

@Environment(EnvType.CLIENT)
public class ModModels extends FabricModelProvider {
    public ModModels(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(class_4910 blockStateModelGenerator) {
        blockStateModelGenerator.method_25641(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.method_25641(ModBlocks.NETHER_IRON_ORE);
    }

    public void generateItemModels(class_4915 itemModelGenerator) {
        itemModelGenerator.method_65442(ModItems.RUBY_SWORD, class_4943.field_22939);
        itemModelGenerator.method_65442(ModItems.RUBY_AXE, class_4943.field_22939);
        itemModelGenerator.method_65442(ModItems.RUBY_PICKAXE, class_4943.field_22939);
        itemModelGenerator.method_65442(ModItems.RUBY_SHOVEL, class_4943.field_22939);
        itemModelGenerator.method_65442(ModItems.RUBY_HOE, class_4943.field_22939);
        itemModelGenerator.method_65442(ModItems.INLAID_RUBY, class_4943.field_22938);
        itemModelGenerator.method_65442(ModItems.INCOMPLETE_BATHING_FIRE_UPGRADE_SMITHING_TEMPLATE, class_4943.field_22938);
        itemModelGenerator.method_65442(ModItems.MAGMA_CORE, class_4943.field_22938);
    }
}
