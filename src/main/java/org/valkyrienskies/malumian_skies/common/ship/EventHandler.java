package org.valkyrienskies.malumian_skies.common.ship;


import kotlin.Pair;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.commons.lang3.tuple.Triple;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.io.Console;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EventHandler {
    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {
        if(GravitationalRiteType.getAuras() != null) {
            for (Triple<RiteData, ServerLevel, AABB> dataTriple : GravitationalRiteType.getAuras()) {
                for (Ship ship : VSGameUtilsKt.getShipsIntersecting(dataTriple.getMiddle(), dataTriple.getRight())) {
                    final ServerShip serverShip = (ServerShip) ship;
                    GravController.getOrCreate(serverShip).setRiteType(dataTriple.getLeft());
                    // gets called on all ships but only ones created after have  "apply forces" being called
                    // current theory is that this "GravitationalRiteType.getAuras()" isnt giving a updated list.
                    // mainly it needs to update aabb's
                }
            }
        } else {
            System.out.println("Failed to find");
        }
    }
}
