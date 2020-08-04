package ru.vital1ks.being.init;

import java.util.function.Supplier;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import ru.vital1ks.being.BeingMod;
import ru.vital1ks.being.BeingMod.BeingItemGroup;
import ru.vital1ks.being.objects.items.BagOfFlourItem;
import ru.vital1ks.being.objects.items.ModFood;
import ru.vital1ks.being.objects.items.MortarItem;
import ru.vital1ks.being.objects.items.PestleItem;

@Mod.EventBusSubscriber(modid = BeingMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(BeingMod.MOD_ID)
public class ItemInit 
{
	//Regular items
	public static final Item matter = null;
	public static final Item antimatter = null;
	public static final Item ingot_of_antimatter = null;
	public static final Item ingot_of_matter = null;
	public static final Item singularity = null;
	public static final Item singularity_stick = null;
	public static final Item horseradish = null;
	public static final Item leaf = null;
	public static final Item bag = null;
	public static final Item bag_of_flour = null;
	public static final Item fabric = null;
	public static final Item dried_cattail = null;
	public static final Item dough = null;
	
	//Tools
	public static final Item antimatter_pickaxe = null;
	public static final Item antimatter_shovel = null;
	public static final Item antimatter_sword = null;
	public static final Item antimatter_axe = null;
	public static final Item antimatter_hoe = null;
	public static final Item mortar = null;
	public static final Item pestle = null;
	
	//Food


	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		//Regular items
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("matter"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("antimatter"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("ingot_of_antimatter"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("ingot_of_matter"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("singularity"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("singularity_stick"));
		event.getRegistry().register(new MortarItem().setRegistryName("mortar"));
		event.getRegistry().register(new PestleItem().setRegistryName("pestle"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance).food(ModFood.HORSERADISH)).setRegistryName("horseradish"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("leaf"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("bag"));
		event.getRegistry().register(new BagOfFlourItem().setRegistryName("bag_of_flour"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("fabric"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("dried_cattail"));
		event.getRegistry().register(new Item(new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("dough"));
		//Tools
		event.getRegistry().register(new PickaxeItem(ModItemTier.ANTIMATTER, 4, 2.0f, new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("antimatter_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.ANTIMATTER, 3, 2.5f, new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("antimatter_shovel"));
		event.getRegistry().register(new SwordItem(ModItemTier.ANTIMATTER, 7, 1.5f, new Item.Properties().group(BeingMod.BeingItemGroup.instance)).setRegistryName("antimatter_sword"));
		event.getRegistry().register(new HoeItem(ModItemTier.ANTIMATTER, 1, new Item.Properties().group(BeingMod.BeingItemGroup.instance)).setRegistryName("antimatter_hoe"));
		event.getRegistry().register(new AxeItem(ModItemTier.ANTIMATTER, 9, 0.5f, new Item.Properties().group(BeingMod.BeingItemGroup.instance)).setRegistryName("antimatter_axe"));
		
	}
	public enum ModItemTier implements IItemTier {
		   ANTIMATTER(3, 1892, 12.0F, 3.5F, 15, () -> {
		      return Ingredient.fromItems(ItemInit.ingot_of_antimatter);
		   });

		   private final int harvestLevel;
		   private final int maxUses;
		   private final float efficiency;
		   private final float attackDamage;
		   private final int enchantability;
		   private final LazyValue<Ingredient> repairMaterial;

		   private ModItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		      this.harvestLevel = harvestLevelIn;
		      this.maxUses = maxUsesIn;
		      this.efficiency = efficiencyIn;
		      this.attackDamage = attackDamageIn;
		      this.enchantability = enchantabilityIn;
		      this.repairMaterial = new LazyValue<>(repairMaterialIn);
		   }

		   public int getMaxUses() {
		      return this.maxUses;
		   }

		   public float getEfficiency() {
		      return this.efficiency;
		   }

		   public float getAttackDamage() {
		      return this.attackDamage;
		   }

		   public int getHarvestLevel() {
		      return this.harvestLevel;
		   }

		   public int getEnchantability() {
		      return this.enchantability;
		   }

		   public Ingredient getRepairMaterial() {
		      return this.repairMaterial.getValue();
		   }
		}
	
	}

