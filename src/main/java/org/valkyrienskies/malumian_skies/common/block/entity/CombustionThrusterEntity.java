package org.valkyrienskies.malumian_skies.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.valkyrienskies.malumian_skies.registry.block.entity.BlockEntityRegistry;

public class CombustionThrusterEntity extends BlockEntity {

    public CombustionThrusterEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.COMBUSTION_THRUSTER.get(), pos, state);
    }
}
