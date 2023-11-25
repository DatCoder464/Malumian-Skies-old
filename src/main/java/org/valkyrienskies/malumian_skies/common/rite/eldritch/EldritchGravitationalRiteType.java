package org.valkyrienskies.malumian_skies.common.rite.eldritch;

import com.sammy.malum.common.block.curiosities.totem.TotemBaseBlockEntity;
import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.antlr.v4.runtime.misc.Triple;
import org.joml.Vector3d;

import java.util.ArrayList;
import java.util.HashMap;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.*;

public class EldritchGravitationalRiteType extends MalumRiteType {
    public EldritchGravitationalRiteType() {
        super("greater_gravitational_rite", ELDRITCH_SPIRIT, ARCANE_SPIRIT, AERIAL_SPIRIT, INFERNAL_SPIRIT);
    }

    HashMap<Boolean, BlockPos> EldritchAuras = new HashMap<Boolean, BlockPos>();
    Vector3d VectorRange = new Vector3d(10, 10, 10);

    private BlockPos vectorBlockPosAdder(Vector3d vectorA, BlockPos vectorB) {
        return  new BlockPos(new Vec3(
                vectorA.x +vectorB.getX(),
                vectorA.y +vectorB.getY(),
                vectorA.z +vectorB.getZ()));
    }

    @Override
    public MalumRiteEffect getNaturalRiteEffect() {
        return new MalumRiteEffect() {
            public void riteEffect(TotemBaseBlockEntity totemBase) {
                if(totemBase.active) {
                    EldritchAuras.put(false, totemBase.getBlockPos());
                }
            }
        };
    }

    @Override
    public MalumRiteEffect getCorruptedEffect() {
        return new MalumRiteEffect() {
            public void riteEffect(TotemBaseBlockEntity totemBase) {
                if(totemBase.active) {
                    Vector3d VectorRange = new Vector3d(10, 10, 10);
                    EldritchAuras.put(true, totemBase.getBlockPos());

                }
            }
        };
    }

    public HashMap<Boolean, BlockPos> getAuras() {
        return EldritchAuras;
    }

    public Vector3d getRange() {
        return VectorRange;
    }
}
