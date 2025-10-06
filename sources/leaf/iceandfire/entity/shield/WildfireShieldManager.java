package leaf.iceandfire.entity.shield;

public class WildfireShieldManager {
    private static final int MAX_SHIELDS = 4;
    private static final int SHIELD_REGEN_TIME = 600;
    private static final int SHIELD_REGEN_TIME_PHASE_2 = 500;
    private int shieldRegenTime = SHIELD_REGEN_TIME;
    private boolean isInSecondPhase = false;
    private boolean[] shields = new boolean[MAX_SHIELDS];
    private int[] shieldRegenTimers = new int[MAX_SHIELDS];
    private int totalShields = MAX_SHIELDS;

    public WildfireShieldManager() {
        for (int i = 0; i < MAX_SHIELDS; i++) {
            this.shields[i] = true;
        }
    }

    public void tick() {
        for (int i = 0; i < MAX_SHIELDS; i++) {
            if (!this.shields[i] && this.shieldRegenTimers[i] > 0) {
                int[] iArr = this.shieldRegenTimers;
                int i2 = i;
                iArr[i2] = iArr[i2] - 1;
                if (this.shieldRegenTimers[i] <= 0) {
                    this.shields[i] = true;
                    this.totalShields++;
                    this.shieldRegenTime -= 200;
                }
            }
        }
    }

    public boolean damageShield() {
        for (int i = 0; i < MAX_SHIELDS; i++) {
            if (this.shields[i]) {
                this.shields[i] = false;
                this.shieldRegenTimers[i] = this.isInSecondPhase ? SHIELD_REGEN_TIME_PHASE_2 : this.shieldRegenTime + 200;
                this.totalShields--;
                this.shieldRegenTime += 200;
                return true;
            }
        }
        return false;
    }

    public float getDamageReduction() {
        return this.totalShields * 0.25f;
    }

    public int getActiveShields() {
        return this.totalShields;
    }

    public boolean[] getShieldStatus() {
        return (boolean[]) this.shields.clone();
    }

    public void resetShields() {
        for (int i = 0; i < MAX_SHIELDS; i++) {
            this.shields[i] = true;
            this.shieldRegenTimers[i] = 0;
        }
        this.totalShields = MAX_SHIELDS;
    }

    public void setSecondPhase(boolean secondPhase) {
        this.isInSecondPhase = secondPhase;
        if (secondPhase) {
            this.shieldRegenTime = SHIELD_REGEN_TIME_PHASE_2;
        } else {
            this.shieldRegenTime = SHIELD_REGEN_TIME;
        }
    }
}
