package ru.vital1ks.being.objects.items;

import javax.annotation.Nonnull;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.vital1ks.being.BeingMod.BeingItemGroup;
import ru.vital1ks.being.init.ItemInit;
import ru.vital1ks.being.util.item.Utils;

public class BagOfFlourItem extends Item{
	public BagOfFlourItem()
	{
		super(new Properties().defaultMaxDamage(64).group(BeingItemGroup.instance));
	}
	@Nonnull
	@Override
	public ItemStack getContainerItem(@Nonnull ItemStack stack)
	{
		ItemStack container = stack.copy();
		if(container.attemptDamageItem(0, Utils.RAND, null))
			return ItemStack.EMPTY;
		else
			return new ItemStack(ItemInit.bag);
	}

	@Override
	public boolean hasContainerItem(@Nonnull ItemStack stack)
	{
		return true;
	}

	@Override
	public boolean isDamageable()
	{
		return true;
	}

	   
}
