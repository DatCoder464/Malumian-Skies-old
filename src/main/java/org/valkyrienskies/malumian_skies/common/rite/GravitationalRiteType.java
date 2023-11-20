package org.valkyrienskies.malumian_skies.common.rite;

import com.sammy.malum.common.block.curiosities.totem.TotemBaseBlockEntity;
import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3d;

import java.util.ArrayList;
import java.util.List;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.ARCANE_SPIRIT;
import static org.valkyrienskies.malumian_skies.registry.MalumianSkiesSpiritTypeRegistry.GRAVITATIONAL;


public class GravitationalRiteType extends MalumRiteType {
    public GravitationalRiteType() {
        super("gravitational_rite", ARCANE_SPIRIT, GRAVITATIONAL, GRAVITATIONAL);
    }
    List<AABB> Auras = new ArrayList<>();

    private BlockPos vectorBlockPosAdder(Vector3d vectorA, BlockPos vectorB) {
        return  new BlockPos(new Vec3(
                vectorA.x +vectorB.getX(),
                vectorA.y +vectorB.getY(),
                vectorA.z +vectorB.getZ()));
    }

    @Override
    public MalumRiteEffect getNaturalRiteEffect() {

        return new MalumRiteEffect() {
            @Override
            public void riteEffect(TotemBaseBlockEntity totemBase) {
                if(totemBase.active) {
                    for (int i = 1; i < 2; i++) {
                        Vector3d Range = new Vector3d(10, 10, 10);
                        Auras.add(new AABB(vectorBlockPosAdder(Range, totemBase.getBlockPos()), vectorBlockPosAdder(new Vector3d(-Range.x, -Range.y, -Range.z), totemBase.getBlockPos())));
                    }
                }
            }
        };
    }

    @Override
    public MalumRiteEffect getCorruptedEffect() {
        return null;
    }

    public List<AABB> getAuras() {
        return Auras;
    }
}
