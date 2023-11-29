package org.valkyrienskies.malumian_skies.common.ship;


import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.tuple.Triple;
import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;
import org.valkyrienskies.malumian_skies.common.rite.eldritch.EldritchGravitationalRiteType;
import org.valkyrienskies.mod.common.VSGameUtilsKt;


public class EventHandler {

    public static AABB blockPostoAABB(BlockPos blockPos) {
        return new AABB(GravController.vectorBlockPosAdder(new Vector3d(10, 10, 10), blockPos), GravController.vectorBlockPosAdder(new Vector3d(10, 10, 10).mul(-1,-1,-1), blockPos));
    }

    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {
        if(GravitationalRiteType.getAuras() != null) {
            for (Triple<RiteData, ServerLevel, BlockPos> dataTriple : GravitationalRiteType.getAuras()) {
                for (Ship ship : VSGameUtilsKt.getShipsIntersecting(dataTriple.getMiddle(), blockPostoAABB(dataTriple.getRight()))) {
                    final ServerShip serverShip = (ServerShip) ship;
                    GravController.getOrCreate(serverShip).setRiteType(dataTriple.getLeft());
                    // gets called on all ships but only ones created after have  "apply forces" being called
                    // current theory is that this "GravitationalRiteType.getAuras()" isnt giving a updated list.
                    // mainly it needs to update aabb's
                }
            }
        } else {
            System.out.println("Failed to find gravitational auras");
        }

        if (EldritchGravitationalRiteType.getAuras() != null) {
            for (Triple<RiteData, ServerLevel, BlockPos> dataTriple : EldritchGravitationalRiteType.getAuras()) {
                for (Ship ship : VSGameUtilsKt.getShipsIntersecting(dataTriple.getMiddle(), blockPostoAABB(dataTriple.getRight()))) {
                    final ServerShip serverShip = (ServerShip) ship;
                    GravController.getOrCreate(serverShip).setRiteType(dataTriple.getLeft());
                }
            }
        } else {
            System.out.println("Failed to find eldritch gravitational auras");
        }

    }
}
