package org.valkyrienskies.malumian_skies.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.malumian_skies.common.block.entity.CombustionSiloEntity;
import org.valkyrienskies.malumian_skies.registry.block.entity.BlockEntityRegistry;

public class CombustionSilo extends Block implements EntityBlock {
    public CombustionSilo(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos Pos, BlockState State) {
        return BlockEntityRegistry.COMBUSTION_SILO.get().create(Pos,State);
    }
}
