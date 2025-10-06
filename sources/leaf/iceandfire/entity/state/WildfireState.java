package leaf.iceandfire.entity.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_10042;

@Environment(EnvType.CLIENT)
public class WildfireState extends class_10042 {
    public boolean isInSecondPhase;
    public boolean[] shieldStatus = new boolean[4];
    public float animationTime = 0.0f;

    public WildfireState() {
        for (int i = 0; i < 4; i++) {
            this.shieldStatus[i] = true;
        }
        this.isInSecondPhase = false;
    }
}
