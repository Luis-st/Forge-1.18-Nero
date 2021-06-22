package net.luis.nero.event;

import net.luis.nero.init.items.ModItems;
import net.minecraft.item.Item;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class OnFurnaceFuelBurnTimeEvent {
	
	// TODO: setBurnTime via config
	
	@SubscribeEvent
	public static void furnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
		Item item = event.getItemStack().getItem();
		if (item == ModItems.HEATED_OBSIDIAN_POWDER.get()) {
			event.setBurnTime(60000);
		}
	}

}
