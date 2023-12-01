package org.valkyrienskies.malumian_skies.registry.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static org.valkyrienskies.malumian_skies.MalumianSkies.MOD_ID;

public class MSTab extends CreativeModeTab {

    private final Supplier<? extends Item> icon;

    public MSTab(String name, Supplier<? extends Item> icon) {
        super(MOD_ID + "_" + name);
        this.icon = icon;
    }

    @Nonnull
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(icon.get());
    }
}
