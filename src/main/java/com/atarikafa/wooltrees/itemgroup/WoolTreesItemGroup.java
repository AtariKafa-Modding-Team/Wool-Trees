
package com.atarikafa.wooltrees.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import com.atarikafa.wooltrees.block.WhiteWoolSaplingBlock;
import com.atarikafa.wooltrees.WoolTreesModElements;

@WoolTreesModElements.ModElement.Tag
public class WoolTreesItemGroup extends WoolTreesModElements.ModElement {
	public WoolTreesItemGroup(WoolTreesModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabwool_trees") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(WhiteWoolSaplingBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
