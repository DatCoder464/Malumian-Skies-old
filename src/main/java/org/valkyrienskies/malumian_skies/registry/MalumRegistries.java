package org.valkyrienskies.malumian_skies.registry;

import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.Bootstrap;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class MalumRegistries {

    static { init(); }
    public static final IForgeRegistry<MalumSpiritType> SPIRITS = RegistryManager.ACTIVE.getRegistry(MalumKeys.SPIRITS);
    public static final IForgeRegistry<MalumRiteType> RITES = RegistryManager.ACTIVE.getRegistry(MalumKeys.RITES);
    public static final class MalumKeys {
        public static final ResourceKey<Registry<MalumSpiritType>> SPIRITS  = key("spirit");
        public static final ResourceKey<Registry<MalumRiteType>> RITES  = key("rites");

        private static <T> ResourceKey<Registry<T>> key(String name)
        {
            return ResourceKey.createRegistryKey(new ResourceLocation(name));
        }
        private static void init() {}


    }

    private static void init()
    {
        MalumRegistries.MalumKeys.init();
        GameData.init();
        Bootstrap.bootStrap();
        Tags.init();
    }
}
