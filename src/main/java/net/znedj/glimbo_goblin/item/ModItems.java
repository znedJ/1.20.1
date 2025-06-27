package net.znedj.glimbo_goblin.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.znedj.glimbo_goblin.GlimboMod;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GlimboMod.MOD_ID);

    public static final RegistryObject<Item> GREENIUM = ITEMS.register("greenium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GOBLIN_EYE = ITEMS.register("goblin_eye",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
