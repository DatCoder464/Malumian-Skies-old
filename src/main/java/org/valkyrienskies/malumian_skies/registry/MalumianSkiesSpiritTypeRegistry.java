package org.valkyrienskies.malumian_skies.registry;


import com.sammy.malum.common.block.mana_mote.*;
import com.sammy.malum.common.item.spirit.*;
import com.sammy.malum.core.systems.spirit.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;
import org.valkyrienskies.malumian_skies.*;
import org.valkyrienskies.malumian_skies.registry.block.MSBlockRegistry;
import org.valkyrienskies.malumian_skies.registry.item.MSItemRegistry;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.function.*;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.SPIRITS;

@SuppressWarnings("unchecked")
@Mod.EventBusSubscriber(modid= MalumianSkies.MOD_ID, value= Dist.CLIENT, bus= Mod.EventBusSubscriber.Bus.MOD)
public class MalumianSkiesSpiritTypeRegistry {

    public static MalumSpiritType GRAVITATIONAL_SPIRIT = create("gravitational", new Color(73, 234, 27), MSItemRegistry.GRAVITATIONAL_SPIRIT, MSBlockRegistry.MOTE_OF_GRAVITATIONAL_ARCANA);
    public static SpiritTypeProperty SPIRIT_TYPE_PROPERTY = new SpiritTypeProperty("spirit_type", SPIRITS.values());

    public static MalumSpiritType create(String identifier, Color color, Supplier<SpiritShardItem> spiritShard, Supplier<SpiritMoteBlock> spiritMote) {
        MalumSpiritType spiritType = new MalumSpiritType(identifier, color, spiritShard, spiritMote);
        SPIRITS.put(identifier, spiritType);
        return spiritType;
    }

    public static MalumSpiritType create(String identifier, Color color, Color endColor, Supplier<SpiritShardItem> spiritShard, Supplier<SpiritMoteBlock> spiritMote) {
        MalumSpiritType spiritType = new MalumSpiritType(identifier, color, endColor, spiritShard, spiritMote);
        SPIRITS.put(identifier, spiritType);
        return spiritType;
    }

    public static int getIndexForSpiritType(MalumSpiritType type) {
        List<MalumSpiritType> types = SPIRITS.values().stream().toList();
        return types.indexOf(type);
    }

    public static MalumSpiritType getSpiritTypeForIndex(int slot) {
        if (slot >= SPIRITS.size())
            return null;
        List<MalumSpiritType> types = SPIRITS.values().stream().toList();
        return types.get(slot);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void stitchTextures(TextureStitchEvent.Pre event) {
        if (!event.getAtlas().location().equals(TextureAtlas.LOCATION_BLOCKS)) {
            return;
        }
        SPIRITS.forEach((s, t) -> event.addSprite(t.getTotemGlowTexture()));
    }
}
