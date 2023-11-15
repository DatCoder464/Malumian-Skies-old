package org.valkyrienskies.malumian_skies.registry.block;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static org.valkyrienskies.malumian_skies.MalumianSkies.REGISTRATE;

public class BlockRegistry extends Blocks {

    public static final RegistryEntry<Block> COMBUSTION_THRUSTER = REGISTRATE.block("Combustion Thruster", Block::new).register();
    public static final RegistryEntry<Block> COMBUSTION_TANK = REGISTRATE.block("Combustion Tank", Block::new).register();
    public static final RegistryEntry<Block> COMBUSTION_SILO = REGISTRATE.block("Combustion Silo", Block::new).register();
    public static void register() {
    }
}
