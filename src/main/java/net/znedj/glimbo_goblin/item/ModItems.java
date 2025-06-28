package net.znedj.glimbo_goblin.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.znedj.glimbo_goblin.GlimboMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GlimboMod.MOD_ID);


    public static final RegistryObject<Item> GOBLIN_EYE = ITEMS.register("goblin_eye",
            () -> new Item(new Item.Properties().stacksTo(16)));

    // Drinkable Greenium
    public static final RegistryObject<Item> GREENIUM = ITEMS.register("greenium",
            () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)
                    .food(new FoodProperties.Builder().alwaysEat()
                            .effect(() -> new MobEffectInstance(GlimboMod.GREEN_SHAKE.get(), 1200), 1.0F)
                            .build())));


    public static final RegistryObject<Item> GREENIUM_THROWABLE = ITEMS.register("greenium_throwable",
            () -> new ThrowablePotionItem(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}