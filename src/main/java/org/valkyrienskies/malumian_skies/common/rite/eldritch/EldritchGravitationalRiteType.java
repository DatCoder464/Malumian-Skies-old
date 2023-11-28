package org.valkyrienskies.malumian_skies.common.rite.eldritch;

import com.sammy.malum.common.block.curiosities.totem.TotemBaseBlockEntity;
import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.tuple.Triple;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;
import org.valkyrienskies.malumian_skies.common.ship.GravController;
import org.valkyrienskies.malumian_skies.common.ship.RiteData;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.*;

public class EldritchGravitationalRiteType extends MalumRiteType {
    public EldritchGravitationalRiteType() {
        super("gravitational_rite", ARCANE_SPIRIT, AERIAL_SPIRIT, INFERNAL_SPIRIT);
    }
    private ServerLevel totemBaseServerLevel;

    private static List<org.apache.commons.lang3.tuple.Triple<RiteData, ServerLevel, AABB>> Auras = new ArrayList<>();

    public AABB blockPostoAABB(BlockPos blockPos) {
        return new AABB(GravController.vectorBlockPosAdder(new Vector3d(10, 10, 10), blockPos), GravController.vectorBlockPosAdder(new Vector3d(10, 10, 10).mul(-1,-1,-1), blockPos));
    }

    @Override
    public MalumRiteEffect getNaturalRiteEffect() {
        return new MalumRiteEffect() {
            public void riteEffect(TotemBaseBlockEntity totemBase) {
                if (totemBase.active) {
                    totemBaseServerLevel = ((ServerLevel) totemBase.getLevel());
                    { Auras.add(Triple.of(RiteData.EldritchNatural, totemBaseServerLevel, blockPostoAABB(totemBase.getBlockPos()))); }
                }
            }
        };
    }

    @Override
    public MalumRiteEffect getCorruptedEffect() {
        return new MalumRiteEffect() {
            public void riteEffect(TotemBaseBlockEntity totemBase) {
                if (totemBase.active) {
                    totemBaseServerLevel = ((ServerLevel) totemBase.getLevel());
                    { Auras.add(org.apache.commons.lang3.tuple.Triple.of(RiteData.EldritchCorrupted, totemBaseServerLevel, blockPostoAABB(totemBase.getBlockPos()))); }
                }
            }
        };
    }

    public static List<org.apache.commons.lang3.tuple.Triple<RiteData, ServerLevel, AABB>> getAuras() {
        return Auras;
    }

    public ServerLevel getTotemBaseServerLevel() {
        return totemBaseServerLevel;
    }


    Iterable<Ship> ships;
    {
        if(GravitationalRiteType.getAuras() != null) {
            for (Triple<RiteData, ServerLevel, BlockPos> aabbs : GravitationalRiteType.getAuras()) {
                ships = VSGameUtilsKt.getShipsIntersecting(getTotemBaseServerLevel(), new AABB(GravController.vectorBlockPosAdder(new Vector3d(10, 10, 10), aabbs.getRight()), GravController.vectorBlockPosAdder(new Vector3d(10, 10, 10).mul(-1,-1,-1), aabbs.getRight())));
            }
        }
    }

    GravController control;
    {
        if(ships != null) {
            for (Ship value : ships) {
                ServerShip ship = (ServerShip) value;
                control = ship.getAttachment(GravController.class);
            }
        }
    }
}
