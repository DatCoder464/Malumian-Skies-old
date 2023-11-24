package org.valkyrienskies.malumian_skies.registry.item;



import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static org.valkyrienskies.malumian_skies.MalumianSkies.REGISTRATE;

@SuppressWarnings("unused")
public class MSItemRegistry extends Items {

    public static final RegistryEntry<Item> VOLATILE_POWDER = REGISTRATE.item("hallowed_lead_ingot", Item::new).register();

    public static final RegistryEntry<Item> HALLOWED_LEAD_INGOT = REGISTRATE.item("hallowed_lead_ingot", Item::new).register();
    public static final RegistryEntry<Item> SPECTRAL_INGOT = REGISTRATE.item("spectral_ingot", Item::new).register();

    public static final RegistryEntry<Item> ARCANE_LENSE = REGISTRATE.item("arcane_lense", Item::new).register();

    public static void register() {
    }
}
