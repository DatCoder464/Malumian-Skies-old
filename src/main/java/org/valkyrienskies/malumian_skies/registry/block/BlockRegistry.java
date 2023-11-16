package org.valkyrienskies.malumian_skies.registry.block;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.valkyrienskies.malumian_skies.common.block.CombustionSilo;
import org.valkyrienskies.malumian_skies.common.block.CombustionTank;
import org.valkyrienskies.malumian_skies.common.block.CombustionThruster;
import org.valkyrienskies.malumian_skies.common.block.entity.CombustionSiloEntity;

import static org.valkyrienskies.malumian_skies.MalumianSkies.REGISTRATE;

public class BlockRegistry extends Blocks {

    public static final RegistryEntry<CombustionThruster> COMBUSTION_THRUSTER = REGISTRATE.block("Combustion Thruster", CombustionThruster::new)
            .register();
    public static final RegistryEntry<CombustionTank> COMBUSTION_TANK = REGISTRATE.block("Combustion Tank", CombustionTank::new)
            .register();
    public static final RegistryEntry<CombustionSilo> COMBUSTION_SILO = REGISTRATE.block("Combustion Silo", CombustionSilo::new)
            .register();
    public static void register() {
    }
}
