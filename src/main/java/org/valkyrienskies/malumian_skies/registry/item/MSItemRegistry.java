package org.valkyrienskies.malumian_skies.registry.item;



import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.valkyrienskies.malumian_skies.registry.tab.MSTabRegistry;

import static org.valkyrienskies.malumian_skies.MalumianSkies.MOD_ID;

@SuppressWarnings("unused")
public class MSItemRegistry extends Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static Item.Properties DEFAULT_PROPERTIES() {
        return new Item.Properties().tab(MSTabRegistry.CONTENT);
    }

    public static final RegistryObject<Item> VOLATILE_POWDER = ITEMS.register("volatile_powder", () -> new Item(DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> HALLOWED_LEAD_INGOT = ITEMS.register("hallowed_lead_ingot", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> SPECTRAL_INGOT = ITEMS.register("spectral_ingot", () -> new Item(DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> ARCANE_LENSE = ITEMS.register("arcane_lense", () -> new Item(DEFAULT_PROPERTIES()));

    public static void register(IEventBus modEventBus) {
    }
}
