package org.valkyrienskies.malumian_skies.registry.tab;

import com.sammy.malum.registry.common.item.ItemRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import org.valkyrienskies.malumian_skies.registry.block.MSBlockRegistry;
import org.valkyrienskies.malumian_skies.registry.item.MSItemRegistry;

public class MSTabRegistry {
    public static final MSTab CONTENT = new MSTab("basis_of_magic", MSItemRegistry.HALLOWED_LEAD_INGOT);

    public static void register(IEventBus modEventBus) {
    }
}
