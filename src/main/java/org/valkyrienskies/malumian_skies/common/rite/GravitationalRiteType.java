package org.valkyrienskies.malumian_skies.common.rite;

import com.sammy.malum.common.block.curiosities.totem.TotemBaseBlockEntity;
import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import kotlin.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Tuple;
import net.minecraft.world.phys.AABB;
import org.apache.commons.lang3.tuple.Triple;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.malumian_skies.common.ship.GravController;
import org.valkyrienskies.malumian_skies.common.ship.RiteData;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.*;


public class GravitationalRiteType extends MalumRiteType {
    public GravitationalRiteType() {
        super("gravitational_rite", ARCANE_SPIRIT, AERIAL_SPIRIT, INFERNAL_SPIRIT);
    }
    ServerLevel totemBaseServerLevel;
    public TotemBaseBlockEntity riteTotemBase;
    static List<Triple<RiteData, ServerLevel, BlockPos>> auras = new ArrayList<>();


    @Override
    public MalumRiteEffect getNaturalRiteEffect() {
        return new MalumRiteEffect() {
            public void riteEffect(TotemBaseBlockEntity totemBase) {
                if (totemBase.active) {
                    totemBaseServerLevel = ((ServerLevel) totemBase.getLevel());
                    riteTotemBase = totemBase;
                    { auras.add(Triple.of(RiteData.BasicNatural, totemBaseServerLevel, totemBase.getBlockPos())); }
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
                    riteTotemBase = totemBase;
                    { auras.add(Triple.of(RiteData.BasicCorrupted, totemBaseServerLevel, totemBase.getBlockPos())); }
                }
            }
        };
    }

    static public List<Triple<RiteData, ServerLevel, BlockPos>> updateAuras() {
        auras
        return auras;
    }

    public ServerLevel getTotemBaseServerLevel() {
        return totemBaseServerLevel;
    }
    Iterable<Ship> ships;
    {
        if(GravitationalRiteType.updateAuras() != null) {
            for (Triple<RiteData, ServerLevel, BlockPos> aabbs : GravitationalRiteType.updateAuras()) {
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
