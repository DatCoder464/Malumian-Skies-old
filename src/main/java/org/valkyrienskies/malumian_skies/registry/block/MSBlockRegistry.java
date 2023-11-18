package org.valkyrienskies.malumian_skies.registry.block;

import com.sammy.malum.common.block.mana_mote.SpiritMoteBlock;
import com.sammy.malum.registry.common.block.BlockEntityRegistry;
import com.sammy.malum.registry.common.block.MalumBlockProperties;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.valkyrienskies.malumian_skies.common.block.CombustionSilo;
import org.valkyrienskies.malumian_skies.common.block.CombustionTank;
import org.valkyrienskies.malumian_skies.common.block.CombustionThruster;
import org.valkyrienskies.malumian_skies.registry.MalumianSkiesSpiritTypeRegistry;

import static org.valkyrienskies.malumian_skies.MalumianSkies.MOD_ID;
import static org.valkyrienskies.malumian_skies.MalumianSkies.REGISTRATE;

public class MSBlockRegistry extends Blocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryEntry<CombustionThruster> COMBUSTION_THRUSTER = REGISTRATE.block("combustion_thruster", CombustionThruster::new)
            .register();
    public static final RegistryEntry<CombustionTank> COMBUSTION_TANK = REGISTRATE.block("combustion_tank", CombustionTank::new)
            .register();
    public static final RegistryEntry<CombustionSilo> COMBUSTION_SILO = REGISTRATE.block("combustion_silo", CombustionSilo::new)
            .register();
    public static final RegistryObject<SpiritMoteBlock> MOTE_OF_GRAVITATIONAL_ARCANA = BLOCKS.register("mote_of_gravitational_arcana", () -> new SpiritMoteBlock(MalumBlockProperties.MANA_MOTE_BLOCK(), MalumianSkiesSpiritTypeRegistry.GRAVITATIONAL_SPIRIT).setBlockEntity(BlockEntityRegistry.MOTE_OF_MANA));
    public static void register() {
    }
}
