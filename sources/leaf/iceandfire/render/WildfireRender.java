package leaf.iceandfire.render;

import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.entity.state.WildfireState;
import leaf.iceandfire.entity.type.WildfireEntity;
import leaf.iceandfire.model.WildfireModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_10017;
import net.minecraft.class_10042;
import net.minecraft.class_1308;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;

@Environment(EnvType.CLIENT)
public class WildfireRender extends class_927<class_1308, WildfireState, WildfireModel> {
    private static final class_2960 WILDFIRE_TEXTURE = class_2960.method_60655(LeafsCrucible.MOD_ID, "textures/entity/wildfire.png");
    private static final class_2960 SOUL_WILDFIRE_TEXTURE = class_2960.method_60655(LeafsCrucible.MOD_ID, "textures/entity/soul_wildfire.png");

    protected float method_55831(class_10017 class_10017Var) {
        return super.method_55832((class_10042) class_10017Var);
    }

    public WildfireRender(class_5617.class_5618 context) {
        super(context, new WildfireModel(context.method_32167(WildfireModel.LAYER_LOCATION)), 1.0f);
    }

    public WildfireState method_55269() {
        return new WildfireState();
    }

    public void method_62354(class_1308 entity, WildfireState state, float tickDelta) {
        super.method_62355(entity, state, tickDelta);
        if (entity instanceof WildfireEntity) {
            WildfireEntity wildfire = (WildfireEntity) entity;
            boolean[] shieldStatus = wildfire.getShieldStatus();
            System.arraycopy(shieldStatus, 0, state.shieldStatus, 0, Math.min(shieldStatus.length, state.shieldStatus.length));
            state.isInSecondPhase = wildfire.isInSecondPhase();
        }
    }

    public void method_3936(WildfireState state, class_4587 matrices, class_4597 vertexConsumers, int light) {
        super.method_4054(state, matrices, vertexConsumers, light);
    }

    public class_2960 method_3885(WildfireState state) {
        return state.isInSecondPhase ? SOUL_WILDFIRE_TEXTURE : WILDFIRE_TEXTURE;
    }
}
