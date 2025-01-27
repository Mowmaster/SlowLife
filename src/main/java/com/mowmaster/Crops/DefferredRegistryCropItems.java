package com.mowmaster.Crops;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;


public class DefferredRegistryCropItems {
    public static final DeferredRegister.Items CROP_ITEMS = DeferredRegister.createItems("simplelife_crops");

    public static final DeferredItem<Item> PEAS = CROP_ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.tutorialmod.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> PEA_SEEDS = CROP_ITEMS.register("pea_seeds",
            () -> new ItemNameBlockItem(DeferredRegistryCropBlocks.PEA_CROP.get(), new Item.Properties()));



    public static void register(IEventBus eventBus) {
        CROP_ITEMS.register(eventBus);
    }
}
