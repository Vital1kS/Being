package ru.vital1ks.being;

import java.util.Iterator;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import ru.vital1ks.being.init.BlockInit;
@SuppressWarnings("deprecation")
@Mod("beingmod")


public class BeingMod
{
	public static final String MOD_ID = "beingmod";
	//public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static final ResourceLocation HOUSE_LOC = new ResourceLocation(BeingMod.MOD_ID, "ground_house");
	public static IStructurePieceType GROUND_HOUSE_PIECE = null;
	@ObjectHolder(MOD_ID+":ground_house")
	public static Structure<NoFeatureConfig> GROUND_HOUSE; 
	public static BeingMod instance;
    public BeingMod() {
    	
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	DeferredWorkQueue.runLater(() -> {
			Iterator<Biome> biomes = ForgeRegistries.BIOMES.iterator();
			biomes.forEachRemaining((biome) -> {
				biome.addStructure(GROUND_HOUSE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, GROUND_HOUSE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			});
		});
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

}
    public static class BeingItemGroup extends ItemGroup{
    	public static final BeingItemGroup instance = new BeingItemGroup(ItemGroup.GROUPS.length, "beingmodtab");
    	private BeingItemGroup(int index, String label) {
    		super(index, label);
    	}
    	@Override
    	public ItemStack createIcon() {
    		return new ItemStack(BlockInit.matter_block);
    	}
    }
}
