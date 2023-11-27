package org.valkyrienskies.malumian_skies.common.ship;



import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.api.ShipForcesInducer;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;

import java.util.ArrayList;
import java.util.List;


public class GravController implements ShipForcesInducer {
    private final ServerShip ship = GravitationalRiteType.getControl().ship;
    public static RiteData riteType;

    public Vector3d SumVectors(List<Vector3dc> forces) {
        Vector3d forceSum = new Vector3d();
        for(Vector3dc force : forces) {
            forceSum = new Vector3d(forceSum.x + force.x(), forceSum.y + force.y(), forceSum.z + force.z());
        }
        return forceSum;
    }

    public static BlockPos vectorBlockPosAdder(Vector3d vectorA, BlockPos vectorB) {
        return  new BlockPos(new Vec3(
                vectorA.x +vectorB.getX(),
                vectorA.y +vectorB.getY(),
                vectorA.z +vectorB.getZ()));
    }

    @Override
    public void applyForces(@NotNull PhysShip physShip) {
        List<Vector3dc> forces = new ArrayList<>();
        if(riteType != null){
            if (!riteType.eldritch) {
                if (!riteType.corrupted) {
                    forces.add(new Vector3d(0, ship.getInertiaData().getMass() * 10, 0));
                } else {
                    forces.add( new Vector3d(0, ship.getInertiaData().getMass() * 20, 0));
                }
            } else {
                if (!riteType.corrupted) {
                } else {
               //     Vector3d shipPosRelativetoBlockPos = new Vector3d(
               //             physShip.getTransform().getPositionInWorld().x() - trueEldritchPos.getX(),
               //             physShip.getTransform().getPositionInWorld().y() - trueEldritchPos.getY(),
               //             physShip.getTransform().getPositionInWorld().z() - trueEldritchPos.getZ());
               //     Vector3d vectorDirection = new Vector3d(
               //             shipPosRelativetoBlockPos.x-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.x),
               //             shipPosRelativetoBlockPos.y-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.y),
               //             shipPosRelativetoBlockPos.z-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.z));
               //     forces.add(new Vector3d(vectorDirection.x, ship.getInertiaData().getMass() * 10 + shipPosRelativetoBlockPos.y, vectorDirection.z));
                }
            }
        }
        Vector3d forceSum = SumVectors(forces);
        physShip.applyInvariantForce(forceSum);
    }

    public static void setRiteType(RiteData newRiteType) {
        riteType = newRiteType;
    }
}
