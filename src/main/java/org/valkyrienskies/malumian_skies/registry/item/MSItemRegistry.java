package org.valkyrienskies.malumian_skies.registry.item;

import com.sammy.malum.common.item.spirit.SpiritShardItem;
import com.sammy.malum.registry.common.SpiritTypeRegistry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.valkyrienskies.malumian_skies.registry.MalumianSkiesSpiritTypeRegistry;

import static com.sammy.malum.registry.common.item.ItemRegistry.DEFAULT_PROPERTIES;
import static com.sammy.malum.registry.common.item.ItemRegistry.ITEMS;
import static org.valkyrienskies.malumian_skies.MalumianSkies.MOD_ID;
import static org.valkyrienskies.malumian_skies.MalumianSkies.REGISTRATE;

public class MSItemRegistry extends Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryEntry<Item> HOLLOW_ALLOY = REGISTRATE.item("hollow_alloy", Item::new).register();
    public static final RegistryEntry<Item> VOLATILE_POWDER = REGISTRATE.item("lead_ingot", Item::new).register();
    public static final RegistryEntry<Item> ARCANE_LENSE = REGISTRATE.item("arcane_lense", Item::new).register();
    public static final RegistryObject<SpiritShardItem> GRAVITATIONAL_SPIRIT = ITEMS.register("gravitational_spirit", () -> new SpiritShardItem(DEFAULT_PROPERTIES(), MalumianSkiesSpiritTypeRegistry.GRAVITATIONAL_SPIRIT));
    public static void register() {
    }
}
