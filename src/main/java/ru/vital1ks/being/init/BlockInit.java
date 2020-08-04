package ru.vital1ks.being.init;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import ru.vital1ks.being.BeingMod;
import ru.vital1ks.being.BeingMod.BeingItemGroup;
import ru.vital1ks.being.objects.blocks.CattailBlock;
import ru.vital1ks.being.objects.blocks.HorseradishBlock;



@ObjectHolder(BeingMod.MOD_ID)
@Mod.EventBusSubscriber(modid = BeingMod.MOD_ID, bus = Bus.MOD)
public class BlockInit {
	public static final Block matter_block = null;
	public static final Block cattail = null;
	public static final Block horseradish_seeds = null;
	public static final Block squash = null;

	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.2f, 7f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)).setRegistryName("matter_block"));
		event.getRegistry().register(new CattailBlock(Block.Properties.from(Blocks.SUGAR_CANE)).setRegistryName("cattail"));
		event.getRegistry().register(new HorseradishBlock(Block.Properties.from(Blocks.WHEAT)).setRegistryName("horseradish_seeds"));


	}
	
	@SubscribeEvent
	public static void registerBlocksItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(matter_block, new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("matter_block"));
		event.getRegistry().register(new BlockItem(cattail, new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("cattail"));
		event.getRegistry().register(new BlockItem(horseradish_seeds, new Item.Properties().group(BeingItemGroup.instance)).setRegistryName("horseradish_seeds"));

			
	}
		
	
}
