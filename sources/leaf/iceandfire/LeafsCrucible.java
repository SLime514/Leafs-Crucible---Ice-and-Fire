package leaf.iceandfire;

import leaf.iceandfire.block.ModBlockEntities;
import leaf.iceandfire.block.ModBlocks;
import leaf.iceandfire.component.ModComponentTypes;
import leaf.iceandfire.enchantment.ModEnchantments;
import leaf.iceandfire.entity.ModEntities;
import leaf.iceandfire.fluid.ModFluids;
import leaf.iceandfire.handler.FrostSwordDropHandler;
import leaf.iceandfire.handler.PlayerIceEnergyHandler;
import leaf.iceandfire.item.ModItems;
import leaf.iceandfire.itemgroup.ModItemGroups;
import leaf.iceandfire.material.ModMaterials;
import leaf.iceandfire.recipe.ModRecipeBookCategories;
import leaf.iceandfire.recipe.ModRecipes;
import leaf.iceandfire.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.class_2893;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7924;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeafsCrucible implements ModInitializer {
    public static final String MOD_ID = "leafs-crucible";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");
        ModRecipeBookCategories.initialize();
        ModMaterials.initialize();
        ModRecipes.initialize();
        ModEnchantments.initialize();
        ModComponentTypes.initialize();
        ModFluids.initialize();
        ModItems.initialize();
        ModItemGroups.initialize();
        ModEntities.initialize();
        ModBlocks.initialize();
        ModBlockEntities.initialize();
        PlayerIceEnergyHandler.initialize();
        FrostSwordDropHandler.initialize();
        ModScreenHandlers.initialize();
        LOGGER.info("Leafs Crucible mod initialized!");
        registerFuels();
        registerOres();
        if (ModScreenHandlers.TEMPERATURE_FURNACE_SCREEN_HANDLER != null) {
            LOGGER.info("Hello Fabric Screen Handler!");
        }
        LOGGER.info("Load : {}", class_2960.method_60655(MOD_ID, ModRecipes.TEMPERATURE_FURNACE_RECIPE_ID));
    }

    private void registerFuels() {
        LOGGER.info("Registering Fuels for leafs-crucible");
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.method_61762(ModItems.BATHING_FIRE_ROD, 3200);
            builder.method_61762(ModItems.BATHING_FIRE_POWDER, 1600);
            builder.method_61762(ModItems.MAGMA_PEARL, 2400);
            builder.method_61762(ModItems.MAGMA_EYE, 4000);
            builder.method_61762(ModItems.RAW_OBSIDIAN, 200);
            builder.method_61762(ModItems.CRYING_RAW_OBSIDIAN, 400);
            builder.method_61762(ModItems.MELT_RAW_OBSIDIAN, 1200);
            builder.method_61762(ModItems.FROST_CRYSTAL, 1600);
            builder.method_61762(ModItems.FROST_CORE, 3200);
            builder.method_61762(ModItems.FROST_DIAMOND, 4000);
            builder.method_61762(ModItems.FROST_INGOT, 2400);
            builder.method_61762(ModItems.FROST_PEARL, 1200);
        });
    }

    private void registerOres() {
        LOGGER.info("Registering Ores for leafs-crucible");
        BiomeModifications.create(class_2960.method_60655(MOD_ID, "features")).add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInTheNether(), biomeSelectionContext -> {
            biomeSelectionContext.getGenerationSettings().addFeature(class_2893.class_2895.field_13176, class_5321.method_29179(class_7924.field_41245, class_2960.method_60655(MOD_ID, "ore_nether_ruby")));
        });
        BiomeModifications.create(class_2960.method_60655(MOD_ID, "features")).add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInTheNether(), biomeSelectionContext2 -> {
            biomeSelectionContext2.getGenerationSettings().addFeature(class_2893.class_2895.field_13176, class_5321.method_29179(class_7924.field_41245, class_2960.method_60655(MOD_ID, "ore_nether_iron")));
        });
        BiomeModifications.create(class_2960.method_60655(MOD_ID, "features")).add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInTheNether(), biomeSelectionContext3 -> {
            biomeSelectionContext3.getGenerationSettings().addFeature(class_2893.class_2895.field_13176, class_5321.method_29179(class_7924.field_41245, class_2960.method_60655(MOD_ID, "ore_large_nether_ruby")));
        });
    }
}
