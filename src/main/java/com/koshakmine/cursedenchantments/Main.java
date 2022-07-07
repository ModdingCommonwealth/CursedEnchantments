package com.koshakmine.cursedenchantments;

import com.koshakmine.cursedenchantments.enchantments.GoodEnchantClass;
import com.koshakmine.cursedenchantments.enchantments.GoofEnchantClass;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	static String MOD_ID = "cursedenchantments";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Enchantment GoofEnchant = new GoofEnchantClass(new FabricItemSettings().group(ItemGroup.MISC));
	public static Enchantment GoodEnchant = new GoodEnchantClass(new FabricItemSettings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "goof"), GoofEnchant);
		Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "good"), GoodEnchant);
		LOGGER.info("Initializing mod...");
	}
}
