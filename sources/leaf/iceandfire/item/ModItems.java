package leaf.iceandfire.item;

import java.util.function.Function;
import leaf.iceandfire.LeafsCrucible;
import leaf.iceandfire.component.ModComponentTypes;
import leaf.iceandfire.fluid.ModFluids;
import leaf.iceandfire.item.type.FrostBowItem;
import leaf.iceandfire.item.type.FrostPearlItem;
import leaf.iceandfire.item.type.FrostSwordItem;
import leaf.iceandfire.item.type.FrostWandItem;
import leaf.iceandfire.item.type.MagmaAxeItem;
import leaf.iceandfire.item.type.MagmaPearlItem;
import leaf.iceandfire.item.type.MagmaPickaxeItem;
import leaf.iceandfire.item.type.MagmaSwordItem;
import leaf.iceandfire.item.type.MagmaWandItem;
import leaf.iceandfire.item.type.RubySwordItem;
import leaf.iceandfire.material.ModMaterials;
import net.minecraft.class_1743;
import net.minecraft.class_1755;
import net.minecraft.class_1792;
import net.minecraft.class_1794;
import net.minecraft.class_1802;
import net.minecraft.class_1821;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7924;
import net.minecraft.class_8051;
import net.minecraft.class_9334;

public class ModItems {
    public static final class_1792 BATHING_FIRE_ROD = register("bathing_fire_rod", class_1792::new, new class_1792.class_1793().method_7889(16).method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(ModComponentTypes.TEMPERATURE, 2));
    public static final class_1792 MAGMA_PEARL = register("magma_pearl", MagmaPearlItem::new, new class_1792.class_1793().method_24359().method_7889(16).method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(ModComponentTypes.TEMPERATURE, 2));
    public static final class_1792 BATHING_FIRE_POWDER = register("bathing_fire_powder", class_1792::new, new class_1792.class_1793().method_7889(16).method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(class_9334.field_49641, true).method_57349(ModComponentTypes.TEMPERATURE, 2));
    public static final class_1792 MAGMA_EYE = register("magma_eye", class_1792::new, new class_1792.class_1793().method_7889(16).method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(ModComponentTypes.TEMPERATURE, 3));
    public static final class_1792 MAGMA_SWORD = register("magma_sword", MagmaSwordItem::new, new class_1792.class_1793().method_7889(1).method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_7895(1000).method_57349(ModComponentTypes.TEMPERATURE, 3));
    public static final class_1792 MAGMA_WAND = register("magma_wand", MagmaWandItem::new, new class_1792.class_1793().method_7895(128).method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(ModComponentTypes.TEMPERATURE, 2));
    public static final class_1792 MAGMA_CORE = register("magma_core", class_1792::new, new class_1792.class_1793().method_7889(16).method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(ModComponentTypes.TEMPERATURE, 3));
    public static final class_1792 MAGMA_AXE = register("magma_axe", settings -> {
        return new MagmaAxeItem(ModMaterials.MAGMA_TOOL, 5.0f, 3.0f, settings);
    }, new class_1792.class_1793().method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_7895(10240).method_57349(ModComponentTypes.TEMPERATURE, 3));
    public static final class_1792 FROST_CRYSTAL = register("frost_crystal", class_1792::new, new class_1792.class_1793().method_7889(16).method_57349(ModComponentTypes.FROST_ENERGY, 50).method_57349(ModComponentTypes.TEMPERATURE, -2));
    public static final class_1792 ICE_SOUL = register("ice_soul", class_1792::new, new class_1792.class_1793().method_7889(16).method_57349(ModComponentTypes.FROST_ENERGY, 75).method_57349(ModComponentTypes.TEMPERATURE, -3));
    public static final class_1792 FROST_CORE = register("frost_core", class_1792::new, new class_1792.class_1793().method_7889(16).method_57349(ModComponentTypes.FROST_ENERGY, 100).method_57349(ModComponentTypes.TEMPERATURE, -4));
    public static final class_1792 FROST_SWORD = register("frost_sword", FrostSwordItem::new, new class_1792.class_1793().method_7895(1500).method_57349(ModComponentTypes.TEMPERATURE, -2).method_57349(ModComponentTypes.FROST_REPAIRABLE, 1));
    public static final class_1792 FROST_STICK = register("frost_stick", class_1792::new, new class_1792.class_1793().method_7889(16).method_57349(ModComponentTypes.FROST_ENERGY, 10).method_57349(ModComponentTypes.TEMPERATURE, -1));
    public static final class_1792 FROST_PEARL = register("frost_pearl", FrostPearlItem::new, new class_1792.class_1793().method_7889(16).method_57349(ModComponentTypes.FROST_ENERGY, 50).method_57349(ModComponentTypes.TEMPERATURE, -2));
    public static final class_1792 FROST_BOW = register("frost_bow", FrostBowItem::new, new class_1792.class_1793().method_57349(ModComponentTypes.TEMPERATURE, -2).method_7895(1024));
    public static final class_1792 FROST_DIAMOND = register("frost_diamond", class_1792::new, new class_1792.class_1793().method_7889(16).method_57349(ModComponentTypes.FROST_ENERGY, 100).method_57349(ModComponentTypes.TEMPERATURE, -4));
    public static final class_1792 FROST_INGOT = register("frost_ingot", class_1792::new, new class_1792.class_1793().method_7889(16).method_57349(ModComponentTypes.FROST_ENERGY, 50).method_57349(ModComponentTypes.TEMPERATURE, -2));
    public static final class_1792 RAW_OBSIDIAN = register("raw_obsidian", class_1792::new, new class_1792.class_1793().method_24359().method_7889(16));
    public static final class_1792 CRYING_RAW_OBSIDIAN = register("crying_raw_obsidian", class_1792::new, new class_1792.class_1793().method_24359().method_7889(16));
    public static final class_1792 MELT_RAW_OBSIDIAN = register("melt_raw_obsidian", class_1792::new, new class_1792.class_1793().method_24359().method_7889(16).method_57349(class_9334.field_49641, true));
    public static final class_1792 MAGMA_PICKAXE = register("magma_pickaxe", MagmaPickaxeItem::new, new class_1792.class_1793().method_7889(1).method_24359().method_57349(ModComponentTypes.BATHING_FIRE, 1).method_57349(ModComponentTypes.TEMPERATURE, 3));
    public static final class_1792 FROST_WAND = register("frost_wand", FrostWandItem::new, new class_1792.class_1793().method_7895(1024).method_57349(ModComponentTypes.TEMPERATURE, -2));
    public static final class_1792 OBSIDIAN_STICK = register("obsidian_stick", class_1792::new, new class_1792.class_1793().method_7889(16).method_24359());
    public static final class_1792 OBSIDIAN_HELMET = register("obsidian_helmet", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.OBSIDIAN_ARMOR, class_8051.field_41934).method_7895(class_8051.field_41934.method_56690(ModMaterials.OBSIDIAN_ARMOR.comp_3166())));
    public static final class_1792 OBSIDIAN_CHESTPLATE = register("obsidian_chestplate", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.OBSIDIAN_ARMOR, class_8051.field_41935).method_7895(class_8051.field_41935.method_56690(ModMaterials.OBSIDIAN_ARMOR.comp_3166())));
    public static final class_1792 OBSIDIAN_LEGGINGS = register("obsidian_leggings", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.OBSIDIAN_ARMOR, class_8051.field_41936).method_7895(class_8051.field_41936.method_56690(ModMaterials.OBSIDIAN_ARMOR.comp_3166())));
    public static final class_1792 OBSIDIAN_BOOTS = register("obsidian_boots", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.OBSIDIAN_ARMOR, class_8051.field_41937).method_7895(class_8051.field_41937.method_56690(ModMaterials.OBSIDIAN_ARMOR.comp_3166())));
    public static final class_1792 BATHING_FIRE_HELMET = register("bathing_fire_helmet", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.BATHING_FIRE_ARMOR, class_8051.field_41934).method_7895(class_8051.field_41934.method_56690(ModMaterials.BATHING_FIRE_ARMOR.comp_3166())));
    public static final class_1792 BATHING_FIRE_CHESTPLATE = register("bathing_fire_chestplate", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.BATHING_FIRE_ARMOR, class_8051.field_41935).method_7895(class_8051.field_41935.method_56690(ModMaterials.BATHING_FIRE_ARMOR.comp_3166())));
    public static final class_1792 BATHING_FIRE_LEGGINGS = register("bathing_fire_leggings", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.BATHING_FIRE_ARMOR, class_8051.field_41936).method_7895(class_8051.field_41936.method_56690(ModMaterials.BATHING_FIRE_ARMOR.comp_3166())));
    public static final class_1792 BATHING_FIRE_BOOTS = register("bathing_fire_boots", class_1792::new, new class_1792.class_1793().method_7889(1).method_24359().method_66332(ModMaterials.BATHING_FIRE_ARMOR, class_8051.field_41937).method_7895(class_8051.field_41937.method_56690(ModMaterials.BATHING_FIRE_ARMOR.comp_3166())));
    public static final class_1792 RUBY = register("ruby", class_1792::new, new class_1792.class_1793().method_7889(16));
    public static final class_1792 INLAID_RUBY = register("inlaid_ruby", class_1792::new, new class_1792.class_1793().method_7889(16));
    public static final class_1792 RUBY_SWORD = register("ruby_sword", RubySwordItem::new, new class_1792.class_1793().method_7895(10000).method_66333(ModMaterials.RUBY_TOOL, 4.0f, -2.0f));
    public static final class_1792 RUBY_PICKAXE = register("ruby_pickaxe", class_1792::new, new class_1792.class_1793().method_7895(10000).method_66330(ModMaterials.RUBY_TOOL, 3.0f, -2.0f));
    public static final class_1792 RUBY_AXE = register("ruby_axe", settings -> {
        return new class_1743(ModMaterials.RUBY_TOOL, 3.0f, -2.0f, settings);
    }, new class_1792.class_1793().method_7895(10000));
    public static final class_1792 RUBY_SHOVEL = register("ruby_shovel", settings -> {
        return new class_1821(ModMaterials.RUBY_TOOL, 3.0f, -2.0f, settings);
    }, new class_1792.class_1793().method_7895(10000));
    public static final class_1792 RUBY_HOE = register("ruby_hoe", settings -> {
        return new class_1794(ModMaterials.RUBY_TOOL, 3.0f, -2.0f, settings);
    }, new class_1792.class_1793().method_7895(10000));
    public static final class_1792 BATHING_FIRE_UPGRADE_SMITHING_TEMPLATE = register("bathing_fire_upgrade_smithing_template", class_1792::new, new class_1792.class_1793().method_7889(1).method_57349(ModComponentTypes.BATHING_FIRE, 1));
    public static final class_1792 INCOMPLETE_BATHING_FIRE_UPGRADE_SMITHING_TEMPLATE = register("incomplete_bathing_fire_upgrade_smithing_template", class_1792::new, new class_1792.class_1793().method_7889(1).method_57349(ModComponentTypes.BATHING_FIRE, 1));
    public static final class_1792 RUBY_HELMET = register("ruby_helmet", class_1792::new, new class_1792.class_1793().method_66332(ModMaterials.RUBY_ARMOR, class_8051.field_41934).method_7895(class_8051.field_41934.method_56690(ModMaterials.RUBY_ARMOR.comp_3166())));
    public static final class_1792 RUBY_CHESTPLATE = register("ruby_chestplate", class_1792::new, new class_1792.class_1793().method_66332(ModMaterials.RUBY_ARMOR, class_8051.field_41935).method_7895(class_8051.field_41935.method_56690(ModMaterials.RUBY_ARMOR.comp_3166())));
    public static final class_1792 RUBY_LEGGINGS = register("ruby_leggings", class_1792::new, new class_1792.class_1793().method_66332(ModMaterials.RUBY_ARMOR, class_8051.field_41936).method_7895(class_8051.field_41936.method_56690(ModMaterials.RUBY_ARMOR.comp_3166())));
    public static final class_1792 RUBY_BOOTS = register("ruby_boots", class_1792::new, new class_1792.class_1793().method_66332(ModMaterials.RUBY_ARMOR, class_8051.field_41937).method_7895(class_8051.field_41937.method_56690(ModMaterials.RUBY_ARMOR.comp_3166())));
    public static final class_1792 SOUL_LAVA_BUCKET = register("soul_lava_bucket", settings -> {
        return new class_1755(ModFluids.SOUL_LAVA, settings);
    }, new class_1792.class_1793().method_7889(1).method_7896(class_1802.field_8550));
    public static final class_1792 SOUL_MAGMA_PEARL = register("soul_lava_pearl", MagmaPearlItem::new, new class_1792.class_1793().method_7889(16).method_24359());

    public static class_1792 register(String path, Function<class_1792.class_1793, class_1792> factory, class_1792.class_1793 settings) {
        class_5321<class_1792> registryKey = class_5321.method_29179(class_7924.field_41197, class_2960.method_60655(LeafsCrucible.MOD_ID, path));
        return class_1802.method_51348(registryKey, factory, settings);
    }

    public static void initialize() {
        LeafsCrucible.LOGGER.info("模组物品正在加载...");
    }
}
