package org.valkyrienskies.malumian_skies.common.ship;


import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.PhysShip;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.impl.api.ShipForcesInducer;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;

import java.util.ArrayList;
import java.util.List;

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


    public void applyForces(@NotNull PhysShip physShip) {
        double mass;
        Vector3d forces;
        GravitationalRiteType gravitationalRiteType = new GravitationalRiteType();
        for (Boolean rite : gravitationalRiteType.getAuras().keySet()) {
            if (rite) {
                if (shipChecker(gravitationalRiteType.getAuras().get(true), new Vector3d(physShip.getTransform().getPositionInWorld()))) {
                    mass = ship.getInertiaData().getMass();
                    forces = new Vector3d(0, mass * 10, 0);
                    physShip.applyInvariantForce(forces);
                }
            } else if (shipChecker(gravitationalRiteType.getAuras().get(false), new Vector3d(physShip.getTransform().getPositionInWorld()))) {
                mass = ship.getInertiaData().getMass();
                forces = new Vector3d(0, mass * 20, 0);
                physShip.applyInvariantForce(forces);
            }
        }

    }
    public GravController(ServerShip ship) {
        this.ship = ship;
    }
}
