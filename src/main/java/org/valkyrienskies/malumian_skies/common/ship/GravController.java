package org.valkyrienskies.malumian_skies.common.ship;


import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.api.ShipForcesInducer;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;
import org.valkyrienskies.malumian_skies.common.rite.eldritch.EldritchGravitationalRiteType;


public class GravController implements ShipForcesInducer {
    private final ServerShip ship;


    public boolean shipChecker(AABB aabb, Vector3d point) {
        boolean isInsideAnyAABB = false;

        if (
                point.x >= aabb.minX && point.x <= aabb.maxX &&
                point.y >= aabb.minY && point.y <= aabb.maxY &&
                point.z >= aabb.minZ && point.z <= aabb.maxZ) {
            isInsideAnyAABB = true;
        } else {
            isInsideAnyAABB = false;
        }

        return isInsideAnyAABB;
    }

    private BlockPos vectorBlockPosAdder(Vector3d vectorA, BlockPos vectorB) {
        return  new BlockPos(new Vec3(
                vectorA.x +vectorB.getX(),
                vectorA.y +vectorB.getY(),
                vectorA.z +vectorB.getZ()));
    }


    public void applyForces(@NotNull PhysShip physShip) {
        double mass;
        Vector3d forces;
        GravitationalRiteType gravitationalRiteType = new GravitationalRiteType();
            BlockPos trueBasicPos = gravitationalRiteType.getAuras().get(true);
            BlockPos falseBasicPos = gravitationalRiteType.getAuras().get(false);
        EldritchGravitationalRiteType eldritchGravitationalRiteType = new EldritchGravitationalRiteType();
            BlockPos trueEldritchPos = eldritchGravitationalRiteType.getAuras().get(true);
            BlockPos falseEldritchPos = eldritchGravitationalRiteType.getAuras().get(true);

        for (Boolean rite : gravitationalRiteType.getAuras().keySet()) {
            if (rite) {
                if (shipChecker(
                        new AABB(vectorBlockPosAdder(gravitationalRiteType.getRange(), falseBasicPos),
                                 vectorBlockPosAdder(gravitationalRiteType.getRange().mul(-1,-1,-1), falseBasicPos)),
                        new Vector3d(physShip.getTransform().getPositionInWorld()))) {
                    mass = ship.getInertiaData().getMass();
                    forces = new Vector3d(0, mass * 10, 0);
                    physShip.applyInvariantForce(forces);
                }
            } else if (shipChecker(
                    new AABB(vectorBlockPosAdder(gravitationalRiteType.getRange(), trueBasicPos),
                             vectorBlockPosAdder(gravitationalRiteType.getRange().mul(-1,-1,-1), trueBasicPos)),
                    new Vector3d(physShip.getTransform().getPositionInWorld()))) {
                mass = ship.getInertiaData().getMass();
                forces = new Vector3d(0, mass * 20, 0);
                physShip.applyInvariantForce(forces);
            }
        }

        for (Boolean rite : eldritchGravitationalRiteType.getAuras().keySet()) {
            if (rite) {
                if (shipChecker(
                        new AABB(vectorBlockPosAdder(eldritchGravitationalRiteType.getRange(), falseEldritchPos),
                                 vectorBlockPosAdder(eldritchGravitationalRiteType.getRange().mul(-1,-1,-1), falseEldritchPos)),
                        new Vector3d(physShip.getTransform().getPositionInWorld()))) {
                    mass = ship.getInertiaData().getMass();
                    forces = new Vector3d(0, mass * 10, 0);
                    physShip.applyInvariantForce(forces);
                }
            } else if (shipChecker(
                    new AABB(vectorBlockPosAdder(eldritchGravitationalRiteType.getRange(), trueEldritchPos),
                             vectorBlockPosAdder(eldritchGravitationalRiteType.getRange().mul(-1,-1,-1), trueEldritchPos)),
                    new Vector3d(physShip.getTransform().getPositionInWorld()))) {
                mass = ship.getInertiaData().getMass();
                Vector3d shipPosRelativetoBlockPos = new Vector3d(
                        physShip.getTransform().getPositionInWorld().x() - trueEldritchPos.getX(),
                        physShip.getTransform().getPositionInWorld().y() - trueEldritchPos.getY(),
                        physShip.getTransform().getPositionInWorld().z() - trueEldritchPos.getZ());
                Vector3d vectorDirection = new Vector3d(
                        shipPosRelativetoBlockPos.x-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.x),
                        shipPosRelativetoBlockPos.y-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.y),
                        shipPosRelativetoBlockPos.z-(Math.sqrt(Math.sqrt(shipPosRelativetoBlockPos.x*shipPosRelativetoBlockPos.x+shipPosRelativetoBlockPos.y*shipPosRelativetoBlockPos.y)+shipPosRelativetoBlockPos.z)/shipPosRelativetoBlockPos.z));
                forces = new Vector3d(vectorDirection.x, mass * 10 + shipPosRelativetoBlockPos.y, vectorDirection.z);
                physShip.applyInvariantForce(forces);
            }
        }

    }
    public GravController(ServerShip ship) {
        this.ship = ship;
    }
}
