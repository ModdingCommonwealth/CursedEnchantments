package com.koshakmine.cursedenchantments.enchantments;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class GoodEnchantClass extends Enchantment {
    public GoodEnchantClass(FabricItemSettings group) {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_CHEST , new EquipmentSlot[] {EquipmentSlot.CHEST});
    }



    @Override
    public int getMaxLevel() {
        return 2;
    }

    public boolean isTreasure() {
        return true;
    }

    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 300, level + 2));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 300, level + 3));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 300, level + 3));
            user.getEquippedStack(EquipmentSlot.CHEST).addEnchantment(Enchantments.MENDING, 1);
            user.getEquippedStack(EquipmentSlot.CHEST).addEnchantment(Enchantments.FIRE_PROTECTION, 1);
            user.getEquippedStack(EquipmentSlot.CHEST).addEnchantment(Enchantments.UNBREAKING, 3);
        }

        super.onTargetDamaged(user, target, level);
    }
}
