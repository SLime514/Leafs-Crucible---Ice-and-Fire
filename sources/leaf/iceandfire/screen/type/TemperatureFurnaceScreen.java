package leaf.iceandfire.screen.type;

import leaf.iceandfire.LeafsCrucible;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1661;
import net.minecraft.class_1921;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3936;
import net.minecraft.class_465;

@Environment(EnvType.CLIENT)
public class TemperatureFurnaceScreen extends class_465<TemperatureFurnaceScreenHandler> implements class_3936<TemperatureFurnaceScreenHandler> {
    private static final class_2960 TEXTURE = class_2960.method_60655(LeafsCrucible.MOD_ID, "textures/gui/container/temperature_furnace.png");
    private static final class_2960 TEMPERATURE_TEXTURE = class_2960.method_60655(LeafsCrucible.MOD_ID, "textures/gui/container/temperature.png");

    public TemperatureFurnaceScreen(TemperatureFurnaceScreenHandler handler, class_1661 inventory, class_2561 title) {
        super(handler, inventory, title);
        this.field_2792 = 176;
        this.field_2779 = 166;
    }

    protected void method_2389(class_332 context, float delta, int mouseX, int mouseY) {
        float iconU;
        int x = (this.field_22789 - this.field_2792) / 2;
        int y = (this.field_22790 - this.field_2779) / 2;
        context.method_25290(class_1921::method_62277, TEXTURE, x, y, 0.0f, 0.0f, this.field_2792, this.field_2779, 256, 256);
        int temperature = ((TemperatureFurnaceScreenHandler) this.field_2797).getProperty(0);
        int tempX = x + 56;
        int tempY = y + 51;
        if (temperature != 0) {
            if (temperature >= 0) {
                iconU = 0.0f;
            } else {
                iconU = 16.0f;
            }
            int draw_temperature = Math.abs(temperature);
            int displayHeight = Math.min(draw_temperature * 2, 16);
            int textureV = 16 - displayHeight;
            int screenY = tempY - displayHeight;
            context.method_25290(class_1921::method_62277, TEMPERATURE_TEXTURE, tempX, screenY, iconU, textureV, 16, displayHeight, 32, 16);
            return;
        }
        context.method_25290(class_1921::method_62277, TEMPERATURE_TEXTURE, tempX, tempY - 8, 0.0f, 8.0f, 16, 1, 32, 16);
    }

    public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
        method_25420(context, mouseX, mouseY, delta);
        super.method_25394(context, mouseX, mouseY, delta);
        method_2380(context, mouseX, mouseY);
    }
}
