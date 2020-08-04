package ru.vital1ks.being.events;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.vital1ks.being.BeingMod;
import ru.vital1ks.being.init.BlockInit;

@Mod.EventBusSubscriber(modid = BeingMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(BlockInit.cattail, RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.horseradish_seeds, RenderType.getCutout());
	}
	
}
