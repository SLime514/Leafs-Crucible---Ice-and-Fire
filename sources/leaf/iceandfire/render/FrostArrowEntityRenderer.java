package leaf.iceandfire.render;

import leaf.iceandfire.LeafsCrucible;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_10017;
import net.minecraft.class_10074;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_954;

@Environment(EnvType.CLIENT)
public class FrostArrowEntityRenderer extends class_954 {
    public static final class_2960 TEXTURE = class_2960.method_60655(LeafsCrucible.MOD_ID, "textures/entity/frost_arrow.png");

    public class_10017 method_55269() {
        return super.method_62553();
    }

    public FrostArrowEntityRenderer(class_5617.class_5618 ctx) {
        super(ctx);
    }

    public class_2960 method_4120(class_10074 arrowEntityRenderState) {
        return TEXTURE;
    }
}
