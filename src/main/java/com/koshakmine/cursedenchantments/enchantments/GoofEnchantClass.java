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

public class GoofEnchantClass extends Enchantment {

    public GoofEnchantClass(FabricItemSettings group) {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_CHEST , new EquipmentSlot[] {EquipmentSlot.CHEST});
    }


    @Override
    public int getMinPower(int level) {
        return 25;
    }
    @Override
    public int getMaxLevel() {
        return 2;
    }
    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    public boolean isTreasure() {
        return true;
    }

    public boolean isCursed() {
        return true;
    }
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 300, level + 5));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 300, level + 2));
            user.damage(DamageSource.GENERIC, 1);
            user.getEquippedStack(EquipmentSlot.CHEST).addEnchantment(Enchantments.UNBREAKING, 300);
            user.getEquippedStack(EquipmentSlot.CHEST).addEnchantment(Enchantments.BINDING_CURSE, 1);
        }

        super.onTargetDamaged(user, target, level);
    }
}
