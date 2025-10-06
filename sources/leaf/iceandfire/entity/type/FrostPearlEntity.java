package leaf.iceandfire.entity.type;

import java.util.List;
import leaf.iceandfire.entity.ModEntities;
import leaf.iceandfire.item.ModItems;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_2398;
import net.minecraft.class_3857;

public class FrostPearlEntity extends class_3857 {
    public FrostPearlEntity(class_1299<? extends class_3857> entityType, class_1937 world) {
        super(entityType, world);
    }

    public FrostPearlEntity(class_1937 world, class_1309 owner) {
        super(ModEntities.FROST_PEARL_ENTITY, owner, world, ModItems.FROST_PEARL.method_7854());
    }

    protected class_1792 method_16942() {
        return ModItems.FROST_PEARL;
    }

    public void method_5773() {
        super.method_5773();
        if (method_37908().field_9236) {
            for (int i = 0; i < 5; i++) {
                method_37908().method_8406(class_2398.field_11228, method_23317() + ((this.field_5974.method_43058() - 0.5d) * 0.2d), method_23318() + ((this.field_5974.method_43058() - 0.5d) * 0.2d), method_23321() + ((this.field_5974.method_43058() - 0.5d) * 0.2d), (this.field_5974.method_43058() - 0.5d) * 0.05d, (this.field_5974.method_43058() - 0.5d) * 0.05d, (this.field_5974.method_43058() - 0.5d) * 0.05d);
            }
        }
    }

    protected void method_7488(class_239 hitResult) {
        super.method_7488(hitResult);
        if (!method_37908().field_9236) {
            applySphereEffect();
        }
        createSphereParticles();
        method_31472();
    }

    private void applySphereEffect() {
        List<class_1309> entities = method_37908().method_8390(class_1309.class, method_5829().method_1014(5.0d), entity -> {
            return entity.method_5805() && entity.method_5707(method_19538()) <= 25.0d;
        });
        for (class_1309 entity2 : entities) {
            double distance = entity2.method_19538().method_1022(method_19538());
            int duration = (int) (100.0d * (1.0d - (distance / 5.0d)));
            entity2.method_6092(new class_1293(class_1294.field_5909, Math.max(20, duration), 4, false, true, true));
            if (!method_37908().field_9236) {
                entity2.method_64397(method_37908(), method_37908().method_48963().method_48836(), 3.0f);
            }
        }
    }

    private void createSphereParticles() {
        if (method_37908().field_9236) {
            spawnSphereParticlesClient();
        } else {
            method_37908().method_8421(this, (byte) 3);
        }
    }

    private void spawnSphereParticlesClient() {
        class_1937 world = method_37908();
        double x = method_23317();
        double y = method_23318();
        double z = method_23321();
        for (int i = 0; i < 100; i++) {
            double theta = world.field_9229.method_43058() * 2.0d * 3.141592653589793d;
            double phi = world.field_9229.method_43058() * 3.141592653589793d;
            double radius = world.field_9229.method_43058() * 3.0d;
            double px = x + (radius * Math.sin(phi) * Math.cos(theta));
            double py = y + (radius * Math.cos(phi));
            double pz = z + (radius * Math.sin(phi) * Math.sin(theta));
            world.method_8406(class_2398.field_11228, px, py, pz, (px - x) * 0.1d, (py - y) * 0.1d, (pz - z) * 0.1d);
        }
    }

    public void method_5711(byte status) {
        if (status == 3) {
            spawnSphereParticlesClient();
        }
    }
}
