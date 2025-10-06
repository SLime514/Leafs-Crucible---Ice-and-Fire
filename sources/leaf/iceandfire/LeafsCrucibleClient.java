package leaf.iceandfire;

import leaf.iceandfire.entity.ModEntities;
import leaf.iceandfire.fluid.ModFluids;
import leaf.iceandfire.model.WildfireModel;
import leaf.iceandfire.render.FrostArrowEntityRenderer;
import leaf.iceandfire.render.FrostPearlEntityRenderer;
import leaf.iceandfire.render.MagmaPearlEntityRenderer;
import leaf.iceandfire.render.SoulMagnaPearlEntityRenderer;
import leaf.iceandfire.render.SwordRainEntityRenderer;
import leaf.iceandfire.render.WildfireFireballEntityRenderer;
import leaf.iceandfire.render.WildfireRender;
import leaf.iceandfire.screen.ModScreenHandlers;
import leaf.iceandfire.screen.type.TemperatureFurnaceScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.class_2960;
import net.minecraft.class_3929;

@Environment(EnvType.CLIENT)
public class LeafsCrucibleClient implements ClientModInitializer {
    public void onInitializeClient() {
        LeafsCrucible.LOGGER.info("LeafsCrucibleClient initialized");
        EntityRendererRegistry.register(ModEntities.MAGMA_PEARL_ENTITY, MagmaPearlEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FROST_PEARL_ENTITY, FrostPearlEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FROST_ARROW_ENTITY, FrostArrowEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SWORD_RAIN_ENTITY, SwordRainEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SWORD_RAIN_ENTITY, SwordRainEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.WILDFIRE_FIREBALL_ENTITY, WildfireFireballEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOUL_MAGNA_PEARL_ENTITY, SoulMagnaPearlEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(WildfireModel.LAYER_LOCATION, WildfireModel::getTexturedModelData);
        class_3929.method_17542(ModScreenHandlers.TEMPERATURE_FURNACE_SCREEN_HANDLER, TemperatureFurnaceScreen::new);
        EntityRendererRegistry.register(ModEntities.WILDFIRE_ENTITY, WildfireRender::new);
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOUL_LAVA, new ModFluidRenderHandler(class_2960.method_60655(LeafsCrucible.MOD_ID, "block/soul_lava_still"), class_2960.method_60655(LeafsCrucible.MOD_ID, "block/soul_lava_flow")));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.FLOWING_SOUL_LAVA, new ModFluidRenderHandler(class_2960.method_60655(LeafsCrucible.MOD_ID, "block/soul_lava_still"), class_2960.method_60655(LeafsCrucible.MOD_ID, "block/soul_lava_flow")));
    }
}
