package org.valkyrienskies.malumian_skies.registry.block;


import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.valkyrienskies.malumian_skies.common.block.CombustionSilo;
import org.valkyrienskies.malumian_skies.common.block.CombustionTank;
import org.valkyrienskies.malumian_skies.common.block.CombustionThruster;

import static org.valkyrienskies.malumian_skies.MalumianSkies.REGISTRATE;

public class MSBlockRegistry extends Blocks {
    
    public static final RegistryEntry<CombustionThruster> COMBUSTION_THRUSTER = REGISTRATE.block("combustion_thruster", CombustionThruster::new)
            .register();
    public static final RegistryEntry<CombustionTank> COMBUSTION_TANK = REGISTRATE.block("combustion_tank", CombustionTank::new)
            .register();
    public static final RegistryEntry<CombustionSilo> COMBUSTION_SILO = REGISTRATE.block("combustion_silo", CombustionSilo::new)
            .register();
    public static final RegistryEntry<Block> BLIGHTED_SAND = REGISTRATE.block("blighted_sand", Block::new)
            .register();

    public static void register() {
    }
}
