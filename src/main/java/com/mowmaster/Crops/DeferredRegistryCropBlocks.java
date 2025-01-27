package com.mowmaster.Crops;

import com.mowmaster.Crops.block.PeasCropBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DeferredRegistryCropBlocks
{
    public static final DeferredRegister.Blocks CROP_BLOCKS = DeferredRegister.createBlocks("simplelife_crops");

    /*public static final DeferredBlock<Block> PEA_CROP = registerBlock("pea_crop",
            () -> new PeasCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));*/

    //Not using registerBlock method here since the crop block item is a seedItem and not a blockItem.
    public static final DeferredBlock<Block> PEA_CROP = CROP_BLOCKS.register("pea_crop",
            () -> new PeasCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = CROP_BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DefferredRegistryCropItems.CROP_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        CROP_BLOCKS.register(eventBus);
    }
}
