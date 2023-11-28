package org.valkyrienskies.malumian_skies.common.ship;



import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.api.ShipForcesInducer;
import org.valkyrienskies.core.impl.game.ships.PhysShipImpl;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;

import java.util.ArrayList;
import java.util.List;


public class GravController implements ShipForcesInducer {
    public RiteData riteType;

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

    public static GravController getOrCreate(ServerShip ship) {
        if (ship.getAttachment(GravController.class) == null)
            ship.saveAttachment(GravController.class, new GravController()); // copied from clockwork
        return ship.getAttachment(GravController.class);
    }

    @Override
    public void applyForces(@NotNull PhysShip physShip) { // only getting called on ships created in the range after activation
        List<Vector3dc> forces = new ArrayList<>();
        if(riteType != null){
            if (!riteType.eldritch) {
                if (!riteType.corrupted) {
                    forces.add(new Vector3d(0, 10000, 0));
                } else {
                    Vector3d shipPosRelativetoBlockPos = new Vector3d(
                            physShip.getTransform().getPositionInWorld().x(),
                            physShip.getTransform().getPositionInWorld().y(),
                            physShip.getTransform().getPositionInWorld().z());
                    Vector3d vectorDirection = new Vector3d(
                            shipPosRelativetoBlockPos.x-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.x),
                            shipPosRelativetoBlockPos.y-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.y),
                            shipPosRelativetoBlockPos.z-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.z));
                    forces.add(new Vector3d(vectorDirection.x, vectorDirection.y, vectorDirection.z));
                }
            } else {
                if (!riteType.corrupted) {
                    forces.add( new Vector3d(0,  20000, 0));
                } else {
                    Vector3d shipPosRelativetoBlockPos = new Vector3d(
                            physShip.getTransform().getPositionInWorld().x(),
                            physShip.getTransform().getPositionInWorld().y(),
                            physShip.getTransform().getPositionInWorld().z());
                    Vector3d vectorDirection = new Vector3d(
                            shipPosRelativetoBlockPos.x-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.x),
                            shipPosRelativetoBlockPos.y-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.y),
                            shipPosRelativetoBlockPos.z-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.z));
                    forces.add(new Vector3d(-vectorDirection.x, -vectorDirection.y, -vectorDirection.z));
                }
            }
        }
        Vector3d forceSum = SumVectors(forces);
        physShip.applyInvariantForce(forceSum);
    }

    public GravController setRiteType(RiteData newRiteType) {
        riteType = newRiteType;
        return this;
    }
}
