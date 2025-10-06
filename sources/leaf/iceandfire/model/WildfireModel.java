package leaf.iceandfire.model;

import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.entity.state.WildfireState;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_5601;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;

@Environment(EnvType.CLIENT)
public class WildfireModel extends class_583<WildfireState> {
    public static final class_5601 LAYER_LOCATION = new class_5601(class_2960.method_60655(LeafsCrucible.MOD_ID, "wildfire"), "main");
    private final class_630 head;
    private final class_630[] shields;
    final float distance = 9.0f;

    public WildfireModel(class_630 root) {
        super(root);
        this.distance = 9.0f;
        class_630 bb_main = root.method_32086("bb_main");
        this.head = root.method_32086("head");
        this.shields = new class_630[4];
        for (int i = 0; i < 4; i++) {
            this.shields[i] = bb_main.method_32086("shield" + (i + 1));
        }
    }

    public static class_5609 getModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 bb_main = modelPartData.method_32117("bb_main", class_5606.method_32108().method_32101(0, 0).method_32097(-2.0f, -21.0f, -2.0f, 4.0f, 21.0f, 4.0f), class_5603.method_32091(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        modelPartData.method_32117("head", class_5606.method_32108().method_32101(0, 26).method_32097(-4.0f, -29.0f, -4.0f, 8.0f, 8.0f, 8.0f).method_32101(0, 43).method_32098(-4.0f, -30.0f, -4.0f, 8.0f, 9.0f, 8.0f, new class_5605(1.0f)), class_5603.method_32091(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        bb_main.method_32117("shield1", class_5606.method_32108().method_32101(17, 0).method_32097(-5.0f, 0.0f, -1.0f, 10.0f, 17.0f, 2.0f), class_5603.method_32091(0.0f, -20.0f, -9.0f, 0.0f, 0.0f, 0.0f));
        bb_main.method_32117("shield2", class_5606.method_32108().method_32101(17, 0).method_32097(-5.0f, 0.0f, -1.0f, 10.0f, 17.0f, 2.0f), class_5603.method_32091(9.0f, -20.0f, 0.0f, 0.0f, -1.5708f, 0.0f));
        bb_main.method_32117("shield3", class_5606.method_32108().method_32101(17, 0).method_32097(-5.0f, 0.0f, -1.0f, 10.0f, 17.0f, 2.0f), class_5603.method_32091(-9.0f, -20.0f, 0.0f, 0.0f, 1.5708f, 0.0f));
        bb_main.method_32117("shield4", class_5606.method_32108().method_32101(17, 0).method_32097(-5.0f, 0.0f, -1.0f, 10.0f, 17.0f, 2.0f), class_5603.method_32091(0.0f, -20.0f, 9.0f, 0.0f, 0.0f, 0.0f));
        return modelData;
    }

    public void method_2819(WildfireState state) {
        animate(state);
        state.animationTime += 0.1f;
        state.animationTime %= 10000.0f;
        this.head.field_3675 = (float) Math.toRadians(state.field_53447);
        updateShieldVisibility(state);
        updateShieldAnimation(state);
    }

    private void updateShieldAnimation(WildfireState state) {
        for (int i = 0; i < 4; i++) {
            if (state.shieldStatus[i]) {
                float x = ((float) Math.sin(state.animationTime + (i * 5.0f))) * 9.0f;
                float z = ((float) Math.cos(state.animationTime + (i * 5.0f))) * 9.0f;
                this.shields[i].field_3657 = x;
                this.shields[i].field_3655 = z;
                this.shields[i].field_3654 = (float) Math.toRadians(Math.sin(state.animationTime + (i * 5.0f)) * 10.0d);
                this.shields[i].field_3675 = (float) Math.toRadians(Math.cos(state.animationTime + (i * 5.0f)) * 10.0d);
            }
        }
    }

    private void animate(WildfireState state) {
        float animateTime = state.animationTime;
        float f = animateTime * 0.8f;
    }

    private void updateShieldVisibility(WildfireState state) {
        for (int i = 0; i < 4; i++) {
            if (i < this.shields.length && this.shields[i] != null) {
                this.shields[i].field_3665 = state.shieldStatus[i];
            }
        }
    }

    public static class_5607 getTexturedModelData() {
        return class_5607.method_32110(getModelData(), 64, 64);
    }

    public class_630 getHead() {
        return this.head;
    }

    public class_630[] getShields() {
        return this.shields;
    }
}
