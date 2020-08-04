package ru.vital1ks.being.world.gen.feature.structure;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.vital1ks.being.BeingMod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid=BeingMod.MOD_ID)
public class ModBusEvents {
	
	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> args) {
		BeingMod.GROUND_HOUSE_PIECE = Registry.register(Registry.STRUCTURE_PIECE, BeingMod.HOUSE_LOC, GroundHousePiece.Piece::new);
		 args.getRegistry().register(new GroundHouse(NoFeatureConfig::deserialize).setRegistryName(BeingMod.HOUSE_LOC));
	}

}
