package leaf.iceandfire;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.minecraft.class_1058;
import net.minecraft.class_1059;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3610;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class ModFluidRenderHandler implements FluidRenderHandler {
    private final class_2960 stillTexture;
    private final class_2960 flowingTexture;
    private class_1058[] sprites;

    public ModFluidRenderHandler(class_2960 stillTexture, class_2960 flowingTexture) {
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
    }

    public class_1058[] getFluidSprites(class_1920 view, class_2338 pos, class_3610 state) {
        if (this.sprites == null) {
            this.sprites = new class_1058[2];
            this.sprites[0] = (class_1058) class_310.method_1551().method_1549(class_1059.field_5275).apply(this.stillTexture);
            this.sprites[1] = (class_1058) class_310.method_1551().method_1549(class_1059.field_5275).apply(this.flowingTexture);
        }
        return this.sprites;
    }

    public int getFluidColor(@Nullable class_1920 view, @Nullable class_2338 pos, class_3610 state) {
        return -1;
    }
}
