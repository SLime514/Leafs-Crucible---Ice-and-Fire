package leaf.iceandfire.entity.type;

import java.util.Arrays;
import java.util.EnumSet;
import leaf.iceandfire.entity.p001ai.goal.SecondPhaseSpecialAttackGoal;
import leaf.iceandfire.entity.p001ai.goal.SummonBlazeGoal;
import leaf.iceandfire.entity.shield.WildfireShieldManager;
import net.minecraft.class_1259;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1370;
import net.minecraft.class_1376;
import net.minecraft.class_1399;
import net.minecraft.class_1400;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1677;
import net.minecraft.class_1743;
import net.minecraft.class_1937;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2940;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3213;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3857;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7;
import net.minecraft.class_8111;

public class WildfireEntity extends class_1588 {
    private static final int SUMMON_COOLDOWN = 300;
    private int summonCooldown;
    private final WildfireShieldManager shieldManager;
    private int shieldBreakCooldown;
    private static final int SHIELD_BREAK_COOLDOWN_DURATION = 20;
    private final class_3213 bossBar;
    private boolean isInSecondPhase;
    private static final float PHASE_TRANSITION_HEALTH_PERCENT = 0.2f;
    private static final class_2940<Integer> SHIELD_STATUS = class_2945.method_12791(WildfireEntity.class, class_2943.field_13327);
    private static final class_2940<Boolean> IS_HEALING = class_2945.method_12791(WildfireEntity.class, class_2943.field_13323);
    private static final class_2940<Boolean> IS_SECOND_PHASE = class_2945.method_12791(WildfireEntity.class, class_2943.field_13323);

    public WildfireEntity(class_1299<? extends class_1588> entityType, class_1937 world) {
        super(entityType, world);
        this.summonCooldown = 0;
        this.shieldManager = new WildfireShieldManager();
        this.shieldBreakCooldown = 0;
        this.isInSecondPhase = false;
        method_5941(class_7.field_18, -1.0f);
        method_5941(class_7.field_14, 0.0f);
        method_5941(class_7.field_9, 0.0f);
        method_5941(class_7.field_3, 0.0f);
        this.bossBar = new class_3213(class_2561.method_43470("Wildfire Boss"), class_1259.class_1260.field_5784, class_1259.class_1261.field_5795).method_5406(true).method_5411(true);
    }

    protected void method_5693(class_2945.class_9222 builder) {
        super.method_5693(builder);
        builder.method_56912(SHIELD_STATUS, 15);
        builder.method_56912(IS_HEALING, false);
        builder.method_56912(IS_SECOND_PHASE, false);
    }

    public void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        nbt.method_10569("ShieldStatus", ((Integer) this.field_6011.method_12789(SHIELD_STATUS)).intValue());
        nbt.method_10569("SummonCooldown", this.summonCooldown);
        nbt.method_10569("ShieldBreakCooldown", this.shieldBreakCooldown);
        nbt.method_10556("IsHealing", ((Boolean) this.field_6011.method_12789(IS_HEALING)).booleanValue());
    }

    public void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        this.field_6011.method_12778(SHIELD_STATUS, (Integer) nbt.method_10550("ShieldStatus").orElse(0));
        this.summonCooldown = ((Integer) nbt.method_10550("SummonCooldown").orElse(0)).intValue();
        this.shieldBreakCooldown = ((Integer) nbt.method_10550("ShieldBreakCooldown").orElse(0)).intValue();
        this.field_6011.method_12778(IS_HEALING, (Boolean) nbt.method_10577("IsHealing").orElse(false));
        this.isInSecondPhase = ((Boolean) nbt.method_10577("IsInSecondPhase").orElse(false)).booleanValue();
    }

    public boolean method_5809() {
        return false;
    }

    public static class_5132.class_5133 createMobAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 80.0d).method_26868(class_5134.field_23719, 0.10000000149011612d).method_26868(class_5134.field_23721, 2.0d).method_26868(class_5134.field_23717, 10.0d).method_26868(class_5134.field_23720, 0.30000001192092896d);
    }

    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(5, new class_1370(this, 1.0d));
        this.field_6201.method_6277(6, new class_1361(this, class_1657.class, 8.0f));
        this.field_6201.method_6277(7, new class_1376(this));
        this.field_6185.method_6277(1, new class_1399(this, new Class[0]));
        this.field_6185.method_6277(2, new class_1400(this, class_1657.class, true));
        this.field_6201.method_6277(1, new SummonBlazeGoal(this, 3, 6, SUMMON_COOLDOWN, 20.0f));
        this.field_6201.method_6277(2, new ShootFireballGoal(this));
        this.field_6201.method_6277(3, new HealGoal(this));
        this.field_6201.method_6277(4, new SecondPhaseSpecialAttackGoal(this));
    }

    public void method_5837(class_3222 player) {
        super.method_5837(player);
        this.bossBar.method_14088(player);
    }

    public void method_5742(class_3222 player) {
        super.method_5742(player);
        this.bossBar.method_14089(player);
    }

    public void method_6078(class_1282 damageSource) {
        super.method_6078(damageSource);
        if (!method_37908().field_9236) {
            for (int i = 0; i < 360; i += 10) {
                double angle = Math.toRadians(i);
                double offsetX = Math.cos(angle) * 2.0d;
                double offsetZ = Math.sin(angle) * 2.0d;
                method_37908().method_65096(class_2398.field_11240, method_23317() + offsetX, method_23323(0.5d), method_23321() + offsetZ, 1, 0.0d, 0.0d, 0.0d, 0.05d);
            }
            this.bossBar.method_14094();
        }
    }

    public void method_5773() {
        super.method_5773();
        if (!method_37908().field_9236 && !this.isInSecondPhase) {
            checkPhaseTransition();
        }
        if (!method_37908().field_9236) {
            this.bossBar.method_5408(method_6032() / method_6063());
        }
        if (this.shieldBreakCooldown > 0) {
            this.shieldBreakCooldown--;
            if (!method_37908().field_9236) {
                method_5762(0.0d, 0.1d, 0.0d);
            }
        }
        if (!method_37908().field_9236) {
            updateShieldStatus();
        }
        if (!method_37908().field_9236) {
            method_5875(true);
            if (this.field_6012 % SHIELD_BREAK_COOLDOWN_DURATION == 0) {
                method_5762(0.0d, (this.field_5974.method_43058() - 0.5d) * 0.05d, 0.0d);
            }
            if (method_5968() != null) {
                double yDistance = method_5968().method_23318() - method_23318();
                if (Math.abs(yDistance) <= 1.0d) {
                    method_18800(method_18798().field_1352, method_18798().field_1351 * 0.9d, method_18798().field_1350);
                } else if (yDistance > 0.0d) {
                    method_5762(0.0d, 0.03d, 0.0d);
                } else {
                    method_5762(0.0d, -0.03d, 0.0d);
                }
                method_5962().method_6239(method_5968().method_23317(), method_5968().method_23318(), method_5968().method_23321(), 1.0d);
            } else {
                method_18800(method_18798().field_1352, method_18798().field_1351 * 0.9d, method_18798().field_1350);
            }
            class_243 velocity = method_18798();
            double maxSpeed = this.isInSecondPhase ? 0.3d : 0.2d;
            if (velocity.method_1033() > maxSpeed) {
                method_18799(velocity.method_1029().method_1021(maxSpeed));
            }
        }
        if (this.summonCooldown > 0) {
            this.summonCooldown--;
        }
        this.shieldManager.tick();
        if (method_37908().field_9236) {
            if (this.summonCooldown > 0 && this.summonCooldown < 100) {
                method_37908().method_8406(this.isInSecondPhase ? class_2398.field_22246 : class_2398.field_11240, method_23317() + ((this.field_5974.method_43058() - 0.5d) * 2.0d), method_23318() + (this.field_5974.method_43058() * 2.0d), method_23321() + ((this.field_5974.method_43058() - 0.5d) * 2.0d), (this.field_5974.method_43058() - 0.5d) * 0.2d, this.field_5974.method_43058() * 0.2d, (this.field_5974.method_43058() - 0.5d) * 0.2d);
            }
            if (((Boolean) this.field_6011.method_12789(IS_HEALING)).booleanValue()) {
                for (int i = 0; i < 2; i++) {
                    method_37908().method_8406(class_2398.field_11201, method_23317() + ((this.field_5974.method_43058() - 0.5d) * 1.0d), method_23318() + 1.5d + ((this.field_5974.method_43058() - 0.5d) * 1.0d), method_23321() + ((this.field_5974.method_43058() - 0.5d) * 1.0d), (this.field_5974.method_43058() - 0.5d) * 0.05d, this.field_5974.method_43058() * 0.05d, (this.field_5974.method_43058() - 0.5d) * 0.05d);
                }
            }
            if (this.isInSecondPhase && this.field_6012 % 5 == 0) {
                method_37908().method_8406(class_2398.field_23114, method_23317() + ((this.field_5974.method_43058() - 0.5d) * 2.0d), method_23318() + ((this.field_5974.method_43058() - 0.5d) * 2.0d), method_23321() + ((this.field_5974.method_43058() - 0.5d) * 2.0d), (this.field_5974.method_43058() - 0.5d) * 0.05d, this.field_5974.method_43058() * 0.05d, (this.field_5974.method_43058() - 0.5d) * 0.05d);
            }
        }
    }

    public boolean method_64397(class_3218 world, class_1282 source, float amount) {
        if (source.method_49708(class_8111.field_42337) || source.method_49708(class_8111.field_42335) || source.method_49708(class_8111.field_42338) || source.method_49708(class_8111.field_42339) || this.shieldBreakCooldown > 0) {
            return false;
        }
        class_1297 class_1297VarMethod_5529 = source.method_5529();
        if (class_1297VarMethod_5529 instanceof class_1657) {
            class_1657 player = (class_1657) class_1297VarMethod_5529;
            if ((player.method_6047().method_7909() instanceof class_1743) && this.shieldManager.damageShield()) {
                world.method_60511((class_1297) null, method_23317(), method_23318(), method_23321(), class_3417.field_15239, class_3419.field_15251, 1.0f, 1.0f);
                if (!world.field_9236) {
                    world.method_65096(class_2398.field_11205, method_23317() + (this.field_5974.method_43059() * 0.5d), method_23318() + 1.0d + (this.field_5974.method_43059() * 0.5d), method_23321() + (this.field_5974.method_43059() * 0.5d), 30, this.field_5974.method_43059() * 0.1d, this.field_5974.method_43059() * 0.1d, this.field_5974.method_43059() * 0.1d, 0.2d);
                    shootMagmaPearlsAtPlayer(player);
                    this.shieldBreakCooldown = SHIELD_BREAK_COOLDOWN_DURATION;
                    updateShieldStatus();
                    return false;
                }
                return false;
            }
        }
        float damageReduction = this.shieldManager.getDamageReduction();
        float reducedAmount = amount * (1.0f - damageReduction);
        return super.method_64397(world, source, reducedAmount);
    }

    private void checkPhaseTransition() {
        if (method_6032() <= method_6063() * PHASE_TRANSITION_HEALTH_PERCENT && !this.isInSecondPhase) {
            transitionToSecondPhase();
        }
    }

    private void transitionToSecondPhase() {
        this.isInSecondPhase = true;
        this.field_6011.method_12778(IS_SECOND_PHASE, true);
        this.shieldManager.setSecondPhase(true);
        method_6033(method_6063());
        this.bossBar.method_5416(class_1259.class_1260.field_5780);
        if (!method_37908().field_9236) {
            method_37908().method_43128((class_1297) null, method_23317(), method_23318(), method_23321(), class_3417.field_14931, class_3419.field_15251, 1.0f, 1.0f);
            method_37908().method_65096(class_2398.field_22246, method_23317(), method_23318() + 1.0d, method_23321(), 50, 1.0d, 1.0d, 1.0d, 0.1d);
        }
        this.summonCooldown = 0;
        this.shieldManager.resetShields();
        updateShieldStatus();
    }

    public boolean isInSecondPhase() {
        return ((Boolean) this.field_6011.method_12789(IS_SECOND_PHASE)).booleanValue();
    }

    public WildfireShieldManager getShieldManager() {
        return this.shieldManager;
    }

    public boolean[] getShieldStatus() {
        int status = ((Integer) this.field_6011.method_12789(SHIELD_STATUS)).intValue();
        boolean[] shieldStatus = new boolean[4];
        for (int i = 0; i < 4; i++) {
            shieldStatus[i] = (status & (1 << i)) != 0;
        }
        return shieldStatus;
    }

    private void updateShieldStatus() {
        boolean[] shields = this.shieldManager.getShieldStatus();
        int status = 0;
        for (int i = 0; i < 4; i++) {
            if (shields[i]) {
                status |= 1 << i;
            }
        }
        this.field_6011.method_12778(SHIELD_STATUS, Integer.valueOf(status));
    }

    public void debugShieldStatus() {
        boolean[] status = this.shieldManager.getShieldStatus();
        System.out.println("Shield Status: " + Arrays.toString(status));
        System.out.println("Active Shields: " + this.shieldManager.getActiveShields());
    }

    private void shootMagmaPearlsAtPlayer(class_1657 player) {
        class_3857 magmaPearlEntity;
        if (method_37908().field_9236) {
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (this.isInSecondPhase) {
                magmaPearlEntity = new SoulMagnaPearlEntity(method_37908(), (class_1309) this);
            } else {
                magmaPearlEntity = new MagmaPearlEntity(method_37908(), (class_1309) this);
            }
            class_3857 pearl = magmaPearlEntity;
            pearl.method_5808(method_23317(), method_23323(0.5d) + 0.5d, method_23321(), method_36454(), method_36455());
            double dX = (player.method_23317() - method_23317()) + (this.field_5974.method_43059() * 0.2d);
            double dY = (player.method_23323(0.5d) - method_23323(0.5d)) + (this.field_5974.method_43059() * 0.2d);
            double dZ = (player.method_23321() - method_23321()) + (this.field_5974.method_43059() * 0.2d);
            double distance = Math.sqrt((dX * dX) + (dY * dY) + (dZ * dZ));
            pearl.method_7485((dX / distance) * 0.8d, ((dY / distance) * 0.8d) + 0.1d, (dZ / distance) * 0.8d, 1.0f, 1.0f);
            pearl.method_18799(pearl.method_18798().method_1021(1.0d + (i * 0.05d)));
            method_37908().method_8649(pearl);
        }
        method_37908().method_43128((class_1297) null, method_23317(), method_23318(), method_23321(), class_3417.field_14970, class_3419.field_15251, 1.0f, this.isInSecondPhase ? 0.8f : 1.0f);
    }

    public boolean isHealing() {
        return ((Boolean) this.field_6011.method_12789(IS_HEALING)).booleanValue();
    }

    public void setHealing(boolean healing) {
        this.field_6011.method_12778(IS_HEALING, Boolean.valueOf(healing));
    }

    public void method_6025(float amount) {
        if (!method_37908().field_9236) {
            float currentHealth = method_6032();
            float maxHealth = method_6063();
            if (currentHealth < maxHealth) {
                method_6033(Math.min(currentHealth + amount, maxHealth));
            }
        }
    }

    static class ShootFireballGoal extends class_1352 {
        private final WildfireEntity blaze;
        private int fireballsFired;
        private int fireballCooldown;
        private int targetNotVisibleTicks;

        public ShootFireballGoal(WildfireEntity blaze) {
            this.blaze = blaze;
            method_6265(EnumSet.of(class_1352.class_4134.field_18405, class_1352.class_4134.field_18406));
        }

        public boolean method_6264() {
            class_1309 livingEntity = this.blaze.method_5968();
            return livingEntity != null && livingEntity.method_5805() && this.blaze.method_18395(livingEntity);
        }

        public void method_6269() {
            this.fireballsFired = 0;
        }

        public void method_6270() {
            this.blaze.setFireActive(false);
            this.targetNotVisibleTicks = 0;
        }

        public boolean method_38846() {
            return true;
        }

        public void method_6268() {
            this.fireballCooldown--;
            class_1297 class_1297VarMethod_5968 = this.blaze.method_5968();
            if (class_1297VarMethod_5968 != null) {
                boolean bl = this.blaze.method_5985().method_6369(class_1297VarMethod_5968);
                if (bl) {
                    this.targetNotVisibleTicks = 0;
                } else {
                    this.targetNotVisibleTicks++;
                }
                double d = this.blaze.method_5858(class_1297VarMethod_5968);
                if (d < 4.0d) {
                    if (!bl) {
                        return;
                    }
                    if (this.fireballCooldown <= 0) {
                        this.fireballCooldown = 10;
                        this.blaze.method_6121(method_64451(this.blaze), class_1297VarMethod_5968);
                    }
                    this.blaze.method_5962().method_6239(class_1297VarMethod_5968.method_23317(), class_1297VarMethod_5968.method_23318(), class_1297VarMethod_5968.method_23321(), 1.0d);
                } else if (d < getFollowRange() * getFollowRange() && bl) {
                    double e = class_1297VarMethod_5968.method_23317() - this.blaze.method_23317();
                    double f = class_1297VarMethod_5968.method_23323(0.5d) - this.blaze.method_23323(0.5d);
                    double g = class_1297VarMethod_5968.method_23321() - this.blaze.method_23321();
                    if (this.fireballCooldown <= 0) {
                        this.fireballsFired++;
                        if (this.fireballsFired == 1) {
                            this.fireballCooldown = 30;
                            this.blaze.setFireActive(true);
                        } else if (this.fireballsFired <= 6) {
                            this.fireballCooldown = 3;
                        } else {
                            this.fireballCooldown = 60;
                            this.fireballsFired = 0;
                            this.blaze.setFireActive(false);
                        }
                        if (this.fireballsFired > 0) {
                            this.blaze.method_5762(0.0d, -0.4d, 0.0d);
                            double h = Math.sqrt(Math.sqrt(d)) * 0.5d;
                            if (!this.blaze.method_5701()) {
                                this.blaze.method_37908().method_8444((class_1297) null, 1018, this.blaze.method_24515(), 0);
                            }
                            for (int i = 0; i < 3; i++) {
                                class_243 vec3d = new class_243(this.blaze.method_59922().method_43385(e, 2.297d * h), f, this.blaze.method_59922().method_43385(g, 2.297d * h));
                                class_1677 smallFireballEntity = new WildfireFireballEntity(this.blaze.method_37908(), this.blaze, vec3d.method_1029());
                                smallFireballEntity.method_5814(smallFireballEntity.method_23317(), this.blaze.method_23323(0.5d) + 0.5d, smallFireballEntity.method_23321());
                                this.blaze.method_37908().method_8649(smallFireballEntity);
                            }
                        }
                    }
                    this.blaze.method_5988().method_6226(class_1297VarMethod_5968, 10.0f, 10.0f);
                } else if (this.targetNotVisibleTicks < 5) {
                    this.blaze.method_5962().method_6239(class_1297VarMethod_5968.method_23317(), class_1297VarMethod_5968.method_23318(), class_1297VarMethod_5968.method_23321(), 1.0d);
                }
                super.method_6268();
            }
        }

        private double getFollowRange() {
            return this.blaze.method_45325(class_5134.field_23717);
        }
    }

    static class HealGoal extends class_1352 {
        private final WildfireEntity wildfire;
        private static final int HEAL_DURATION = 100;
        private static final int HEAL_COOLDOWN = 400;
        private int healTicks = 0;
        private int cooldown = 0;

        public HealGoal(WildfireEntity wildfire) {
            this.wildfire = wildfire;
            method_6265(EnumSet.of(class_1352.class_4134.field_18405, class_1352.class_4134.field_18406));
        }

        public boolean method_6264() {
            if (this.cooldown <= 0) {
                return (this.wildfire.method_5968() == null || this.wildfire.method_6032() >= this.wildfire.method_6063() * 0.8f || ((Boolean) this.wildfire.field_6011.method_12789(WildfireEntity.IS_HEALING)).booleanValue()) ? false : true;
            }
            this.cooldown--;
            return false;
        }

        public boolean method_6266() {
            return this.healTicks < HEAL_DURATION;
        }

        public void method_6269() {
            this.healTicks = 0;
            this.wildfire.setHealing(true);
            if (!this.wildfire.method_37908().field_9236) {
                this.wildfire.method_37908().method_43128((class_1297) null, this.wildfire.method_23317(), this.wildfire.method_23318(), this.wildfire.method_23321(), class_3417.field_14905, class_3419.field_15251, 1.0f, 1.0f);
            }
        }

        public void method_6268() {
            this.healTicks++;
            if (this.healTicks % 10 == 0) {
                this.wildfire.method_6025(1.0f);
            }
        }

        public void method_6270() {
            this.wildfire.setHealing(false);
            this.healTicks = 0;
            this.cooldown = HEAL_COOLDOWN;
        }
    }

    private void setFireActive(boolean b) {
    }
}
