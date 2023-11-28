package org.valkyrienskies.malumian_skies.common.ship;

import net.minecraft.server.level.ServerLevel;

public enum RiteData {
    BasicNatural(false, false),
    EldritchNatural(false, true),
    BasicCorrupted(true, false),
    EldritchCorrupted(true, true);

    final boolean corrupted;
    final boolean eldritch;
    RiteData(boolean corrupted, boolean eldritch) {
        this.corrupted = corrupted;
        this.eldritch = eldritch;
    }


}
