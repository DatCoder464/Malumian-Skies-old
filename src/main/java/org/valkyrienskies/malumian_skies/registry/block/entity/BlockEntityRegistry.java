package org.valkyrienskies.malumian_skies.registry.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.valkyrienskies.malumian_skies.MalumianSkies;
import org.valkyrienskies.malumian_skies.common.block.entity.CombustionSiloEntity;
import org.valkyrienskies.malumian_skies.common.block.entity.CombustionTankEntity;
import org.valkyrienskies.malumian_skies.common.block.entity.CombustionThrusterEntity;
import org.valkyrienskies.malumian_skies.registry.block.MSBlockRegistry;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MalumianSkies.MOD_ID);

    public static final RegistryObject<BlockEntityType<CombustionSiloEntity>> COMBUSTION_SILO = BLOCK_ENTITY_TYPES.register("combustion_silo",
            () -> BlockEntityType.Builder.of(CombustionSiloEntity::new, MSBlockRegistry.COMBUSTION_SILO.get()).build(null));

    public static final RegistryObject<BlockEntityType<CombustionTankEntity>> COMBUSTION_TANK = BLOCK_ENTITY_TYPES.register("combustion_tank",
            () -> BlockEntityType.Builder.of(CombustionTankEntity::new, MSBlockRegistry.COMBUSTION_TANK.get()).build(null));

    public static final RegistryObject<BlockEntityType<CombustionThrusterEntity>> COMBUSTION_THRUSTER = BLOCK_ENTITY_TYPES.register("combustion_thruster",
            () -> BlockEntityType.Builder.of(CombustionThrusterEntity::new, MSBlockRegistry.COMBUSTION_THRUSTER.get()).build(null));

    public static void register() {
    }
}
