package com.shielza.item;

import com.shielza.PixelBand;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PIANO_SHEET_MUSIC = registerItems("piano_sheet_music", new Item(new Item.Settings().maxCount(1)));


    private static Item registerItems(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(PixelBand.MOD_ID, name), item);
    }

    public static void registerModItems(){
        PixelBand.LOGGER.info("Registering Mod Items for " + PixelBand.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(PIANO_SHEET_MUSIC);
        });
    }
}
