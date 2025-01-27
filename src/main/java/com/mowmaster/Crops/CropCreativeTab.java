package com.mowmaster.Crops;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CropCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "simplelife_crops");

    public static final Supplier<CreativeModeTab> CROP_ITEMS_TAB = CREATIVE_MODE_TAB.register("crop_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DeferredRegistryCropBlocks.PEA_CROP.get()))
                    .title(Component.translatable("creativetab.simplelife_crops.crop_items"))
                    .displayItems((itemDisplayParameters, output) -> {


                        output.accept(DefferredRegistryCropItems.PEA_SEEDS);

                    }).build());

    public static final Supplier<CreativeModeTab> CROP_BLOCK_TAB = CREATIVE_MODE_TAB.register("crop_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DeferredRegistryCropBlocks.PEA_CROP))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath("simplelife_crops", "crop_items_tab"))
                    .title(Component.translatable("creativetab.simplelife_crops.crop_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {


                        //output.accept(ModBlocks.MAGIC_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
