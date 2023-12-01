package org.valkyrienskies.malumian_skies.registry.block;

import com.sammy.malum.registry.common.SoundRegistry;
import com.sammy.malum.registry.common.block.BlockTagRegistry;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import team.lodestar.lodestone.systems.block.LodestoneBlockProperties;

public class MSBlockProperties {
    public static LodestoneBlockProperties HALLOWED_LEAD() {
        return new LodestoneBlockProperties(Material.HEAVY_METAL, MaterialColor.COLOR_PURPLE)
                .addTag(BlockTagRegistry.RITE_IMMUNE)
                .sound(SoundType.METAL);
    }
}
