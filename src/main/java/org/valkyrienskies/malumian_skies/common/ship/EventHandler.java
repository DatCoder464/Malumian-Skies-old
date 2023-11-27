package org.valkyrienskies.malumian_skies.common.ship;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class EventHandler {
    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {
        if(GravitationalRiteType.getAuras() != null) {
            for (Map.Entry<ServerLevel, List<AABB>> aabbs : GravitationalRiteType.getAuras().entrySet()) {
                for (AABB aabb : aabbs.getValue()) {
                    for (Ship ship : VSGameUtilsKt.getShipsIntersecting(aabbs.getKey(), aabb)) {
                        final ServerShip serverShip = (ServerShip) ship;
                        final GravController attachment = serverShip.getAttachment(GravController.class);
                    }
                }
            }
        }
    }
}
