package com.shielza.block;

import com.shielza.PixelBand;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block GRAND_PIANO = registerBlock("grand_piano",
            new Block(AbstractBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.BAMBOO)));

    private static Block registerBlock(String name, Block block){
        registerBlocksItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PixelBand.MOD_ID, name), block);
    }

    private static void registerBlocksItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(PixelBand.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        PixelBand.LOGGER.info("Registering Mod Blocks for " + PixelBand.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
            entries.add(GRAND_PIANO);
        });
    }
}
