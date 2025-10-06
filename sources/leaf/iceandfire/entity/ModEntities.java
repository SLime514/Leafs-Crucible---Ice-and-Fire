package leaf.iceandfire.entity;

import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.entity.type.FrostArrowEntity;
import leaf.iceandfire.entity.type.FrostPearlEntity;
import leaf.iceandfire.entity.type.MagmaPearlEntity;
import leaf.iceandfire.entity.type.SoulMagnaPearlEntity;
import leaf.iceandfire.entity.type.SwordRainEntity;
import leaf.iceandfire.entity.type.WildfireEntity;
import leaf.iceandfire.entity.type.WildfireFireballEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7923;
import net.minecraft.class_7924;

public class ModEntities {
    public static final class_1299<MagmaPearlEntity> MAGMA_PEARL_ENTITY = (class_1299) class_2378.method_10230(class_7923.field_41177, class_2960.method_60655(LeafsCrucible.MOD_ID, "magma_pearl"), class_1299.class_1300.method_5903(MagmaPearlEntity::new, class_1311.field_17715).method_17687(0.25f, 0.25f).method_27299(4).method_27300(10).method_5905(class_5321.method_29179(class_7924.field_41266, class_2960.method_60655(LeafsCrucible.MOD_ID, "magma_pearl"))));
    public static final class_1299<WildfireFireballEntity> WILDFIRE_FIREBALL_ENTITY = (class_1299) class_2378.method_10230(class_7923.field_41177, class_2960.method_60655(LeafsCrucible.MOD_ID, "wildfire_fireball"), class_1299.class_1300.method_5903(WildfireFireballEntity::new, class_1311.field_17715).method_17687(0.25f, 0.25f).method_27299(4).method_27300(10).method_5905(class_5321.method_29179(class_7924.field_41266, class_2960.method_60655(LeafsCrucible.MOD_ID, "wildfire_fireball"))));
    public static final class_1299<WildfireEntity> WILDFIRE_ENTITY = (class_1299) class_2378.method_10230(class_7923.field_41177, class_2960.method_60655(LeafsCrucible.MOD_ID, "wildfire"), class_1299.class_1300.method_5903(WildfireEntity::new, class_1311.field_6302).method_17687(1.4f, 2.7f).method_27299(10).method_5905(class_5321.method_29179(class_7924.field_41266, class_2960.method_60655(LeafsCrucible.MOD_ID, "wildfire"))));
    public static final class_1299<FrostPearlEntity> FROST_PEARL_ENTITY = (class_1299) class_2378.method_10230(class_7923.field_41177, class_2960.method_60655(LeafsCrucible.MOD_ID, "frost_pearl"), class_1299.class_1300.method_5903(FrostPearlEntity::new, class_1311.field_17715).method_17687(0.25f, 0.25f).method_27299(4).method_27300(10).method_5905(class_5321.method_29179(class_7924.field_41266, class_2960.method_60655(LeafsCrucible.MOD_ID, "frost_pearl"))));
    public static final class_1299<FrostArrowEntity> FROST_ARROW_ENTITY = (class_1299) class_2378.method_10230(class_7923.field_41177, class_2960.method_60655(LeafsCrucible.MOD_ID, "frost_arrow"), class_1299.class_1300.method_5903(FrostArrowEntity::new, class_1311.field_17715).method_17687(0.5f, 0.5f).method_27299(4).method_27300(10).method_5905(class_5321.method_29179(class_7924.field_41266, class_2960.method_60655(LeafsCrucible.MOD_ID, "frost_arrow"))));
    public static final class_1299<SwordRainEntity> SWORD_RAIN_ENTITY = (class_1299) class_2378.method_10230(class_7923.field_41177, class_2960.method_60655(LeafsCrucible.MOD_ID, "sword_rain"), class_1299.class_1300.method_5903(SwordRainEntity::new, class_1311.field_17715).method_17687(0.25f, 1.0f).method_27299(4).method_27300(10).method_5905(class_5321.method_29179(class_7924.field_41266, class_2960.method_60655(LeafsCrucible.MOD_ID, "sword_rain"))));
    public static final class_1299<SoulMagnaPearlEntity> SOUL_MAGNA_PEARL_ENTITY = (class_1299) class_2378.method_10230(class_7923.field_41177, class_2960.method_60655(LeafsCrucible.MOD_ID, "soul_magna_pearl"), class_1299.class_1300.method_5903(SoulMagnaPearlEntity::new, class_1311.field_17715).method_17687(0.25f, 0.25f).method_27299(4).method_27300(10).method_5905(class_5321.method_29179(class_7924.field_41266, class_2960.method_60655(LeafsCrucible.MOD_ID, "soul_magna_pearl"))));

    public static void initialize() {
        LeafsCrucible.LOGGER.info("模组实体正在加载...");
        FabricDefaultAttributeRegistry.register(WILDFIRE_ENTITY, WildfireEntity.createMobAttributes());
    }
}
