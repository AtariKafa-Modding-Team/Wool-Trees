package com.atarikafa.wooltrees.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Map;

import com.atarikafa.wooltrees.block.LimeWoolSaplingBlock;
import com.atarikafa.wooltrees.WoolTreesMod;

public class LimeWoolBlockDestroyedByPlayerProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				WoolTreesMod.LOGGER.warn("Failed to load dependency world for procedure LimeWoolBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				WoolTreesMod.LOGGER.warn("Failed to load dependency x for procedure LimeWoolBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				WoolTreesMod.LOGGER.warn("Failed to load dependency y for procedure LimeWoolBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				WoolTreesMod.LOGGER.warn("Failed to load dependency z for procedure LimeWoolBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				WoolTreesMod.LOGGER.warn("Failed to load dependency entity for procedure LimeWoolBlockDestroyedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (!((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).abilities.isCreativeMode : false)) {
			if (0.25 > Math.random()) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(LimeWoolSaplingBlock.block));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.LIME_WOOL));
					entityToSpawn.setPickupDelay((int) 0);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}
}
