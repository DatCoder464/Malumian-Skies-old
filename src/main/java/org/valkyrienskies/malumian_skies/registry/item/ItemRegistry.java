package org.valkyrienskies.malumian_skies.registry.item;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import static org.valkyrienskies.malumian_skies.MalumianSkies.REGISTRATE;

public class ItemRegistry extends Items {
    public static final RegistryEntry<Item> HOLLOW_ALLOY = REGISTRATE.item("Hollow Alloy", Item::new).register();
    public static final RegistryEntry<Item> VOLATILE_POWDER = REGISTRATE.item("Lead Ingot", Item::new).register();
    public static final RegistryEntry<Item> ARCANE_LENSE = REGISTRATE.item("Arcane Lense", Item::new).register();
    public static void register() {
    }
}
