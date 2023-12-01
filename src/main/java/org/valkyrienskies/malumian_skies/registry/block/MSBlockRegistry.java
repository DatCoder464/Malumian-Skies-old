package org.valkyrienskies.malumian_skies.registry.block;


import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;
import org.valkyrienskies.malumian_skies.common.block.CombustionSilo;
import org.valkyrienskies.malumian_skies.common.block.CombustionTank;
import org.valkyrienskies.malumian_skies.common.block.CombustionThruster;
import org.valkyrienskies.malumian_skies.registry.tab.MSTabRegistry;

import static org.valkyrienskies.malumian_skies.MalumianSkies.MOD_ID;
import static org.valkyrienskies.malumian_skies.registry.block.MSBlockProperties.HALLOWED_LEAD;

public class MSBlockRegistry extends Blocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final RegistryObject<CombustionThruster> COMBUSTION_THRUSTER = BLOCKS.register("combustion_thruster", () -> new CombustionThruster(HALLOWED_LEAD()));
    public static final RegistryObject<CombustionTank> COMBUSTION_TANK = BLOCKS.register("combustion_tank", () -> new CombustionTank(HALLOWED_LEAD()));
    public static final RegistryObject<CombustionSilo> COMBUSTION_SILO = BLOCKS.register("combustion_silo", () -> new CombustionSilo(HALLOWED_LEAD()));
    public static final RegistryObject<Block> BLIGHTED_SAND = BLOCKS.register("blighted_sand", () -> new Block(HALLOWED_LEAD()));

    public static void register(IEventBus modEventBus) {
    }
}
