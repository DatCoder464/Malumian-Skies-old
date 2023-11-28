package org.valkyrienskies.malumian_skies.common.block;

import com.sammy.malum.registry.common.item.ItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import org.valkyrienskies.malumian_skies.registry.item.MSItemRegistry;

import java.util.Arrays;
import java.util.List;

public enum Dusts {
    Redstone(Items.REDSTONE),
    Sand(Items.SAND),
    Gravel(Items.GRAVEL),
    Glowstone(Items.GLOWSTONE_DUST),
    BlazePowder(Items.BLAZE_POWDER),
    GunPowder(Items.GUNPOWDER),
    PowderSnow(Items.POWDER_SNOW_BUCKET),
    AlchemicalCalx(ItemRegistry.ALCHEMICAL_CALX.get()),
    BlightedGunk(ItemRegistry.BLIGHTED_GUNK.get()),
    HexAsh(ItemRegistry.HEX_ASH.get()),
    VoidSalt(ItemRegistry.VOID_SALTS.get()),
    CursedGrit(ItemRegistry.CURSED_GRIT.get()),
    GrimTalc(ItemRegistry.GRIM_TALC.get()),
    RottingEssence(ItemRegistry.ROTTING_ESSENCE.get()),
    PrimordialSoup(ItemRegistry.PRIMORDIAL_SOUP.get()),
    EthericNitrate(ItemRegistry.ETHERIC_NITRATE.get()),
    VividNitrate(ItemRegistry.VIVID_NITRATE.get()),
    VolatilePowder(MSItemRegistry.VOLATILE_POWDER.get());

    final Item dust;
    Dusts(Item dust) {
        this.dust = dust;
    }

    List<Dusts> ListDusts() {
        return Arrays.stream(Dusts.values()).toList();
    }
}
