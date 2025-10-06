package leaf.iceandfire.render;

import leaf.iceandfire.entity.type.WildfireFireballEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_10017;
import net.minecraft.class_5617;
import net.minecraft.class_953;

@Environment(EnvType.CLIENT)
public class WildfireFireballEntityRenderer extends class_953<WildfireFireballEntity> {
    public class_10017 method_55269() {
        return super.method_62547();
    }

    public WildfireFireballEntityRenderer(class_5617.class_5618 ctx, float scale, boolean lit) {
        super(ctx, scale, lit);
    }

    public WildfireFireballEntityRenderer(class_5617.class_5618 ctx) {
        super(ctx);
    }
}
