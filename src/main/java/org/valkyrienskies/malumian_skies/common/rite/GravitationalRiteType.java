package org.valkyrienskies.malumian_skies.common.rite;

import com.sammy.malum.common.block.curiosities.totem.TotemBaseBlockEntity;
import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.malumian_skies.common.ship.GravController;
import org.valkyrienskies.malumian_skies.common.ship.RiteData;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.HashMap;
import java.util.List;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.*;


public class GravitationalRiteType extends MalumRiteType {
    public GravitationalRiteType() {
        super("gravitational_rite", ARCANE_SPIRIT, AERIAL_SPIRIT, INFERNAL_SPIRIT);
    }
    static ServerLevel totemBaseServerLevel;
    public TotemBaseBlockEntity riteTotemBase;
    static HashMap<ServerLevel, List<AABB>> Auras;
    static Vector3d VectorRange = new Vector3d(10, 10, 10);

    public AABB blockPostoAABB(BlockPos blockPos) {
        return new AABB(GravController.vectorBlockPosAdder(VectorRange, blockPos), GravController.vectorBlockPosAdder(VectorRange.mul(-1,-1,-1), blockPos));
    }

    @Override
    public MalumRiteEffect getNaturalRiteEffect() {
        return new MalumRiteEffect() {
            public void riteEffect(TotemBaseBlockEntity totemBase) {
                if (totemBase.active) {
                    totemBaseServerLevel = ((ServerLevel) totemBase.getLevel());
                    riteTotemBase = totemBase;
                    {
                        List<AABB> AABBs = null;
                        for (BlockPos blockPos : totemBase.poles) {
                            AABBs.add(blockPostoAABB(blockPos));
                        }
                        Auras.put(totemBaseServerLevel, AABBs);
                        GravController.setRiteType(RiteData.BasicNatural);
                    }
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
                    {
                        List<AABB> AABBs = null;
                        for (BlockPos blockPos : totemBase.poles) {
                            AABBs.add(blockPostoAABB(blockPos));
                        }
                        Auras.put(totemBaseServerLevel, AABBs);
                        GravController.setRiteType(RiteData.BasicCorrupted);
                    }
                }
            }
        };
    }

    public static HashMap<ServerLevel, List<AABB>> getAuras() {
        return Auras;
    }

    public static ServerLevel getTotemBaseServerLevel() {
        return totemBaseServerLevel;
    }

    public static Vector3d getRange() {
        return VectorRange;
    }

    Iterable<Ship> ships;
    {
        if(GravitationalRiteType.getAuras() != null) {
            for (List<AABB> aabbs : GravitationalRiteType.getAuras().values()) {
                for (AABB aabb : aabbs) {
                    ships = VSGameUtilsKt.getShipsIntersecting(getTotemBaseServerLevel(), aabb);
                }
            }
        }
    }

    public BlockPos getRitePos(boolean corrupted) {
        if(!corrupted) {
            return corruptedEffect.getRiteEffectCenter(riteTotemBase);
        } else {
            return effect.getRiteEffectCenter(riteTotemBase);
        }
    }

    static GravController control;
    {
        if(ships != null) {
            for (Ship value : ships) {
                ServerShip ship = (ServerShip) value;
                control = ship.getAttachment(GravController.class);
            }
        }
    }

    public static GravController getControl() {
        return control;
    }
}
