package org.valkyrienskies.malumian_skies.common.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import org.valkyrienskies.malumian_skies.registry.block.entity.BlockEntityRegistry;

public class CombustionSiloEntity extends BlockEntity {
    public CombustionSiloEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.COMBUSTION_SILO.get(), pos, state);
    }
    private static final int MAX_SIZE = 3;

    protected LazyOptional<IItemHandler> itemCapability;
    protected boolean forceFluidLevelUpdate;
    protected FluidTank tankInventory;
    protected int width;
    protected int height;
    
}
