package org.valkyrienskies.malumian_skies.common.ship;

public enum RiteData {
    BasicNatural(false, false),
    EldritchNatural(true, false),
    BasicCorrupted(false, true),
    EldritchCorrupted(true, true);

    final boolean corrupted;
    final boolean eldritch;
    RiteData(boolean corrupted, boolean eldritch) {
        this.corrupted = corrupted;
        this.eldritch = eldritch;
    }


}
