package org.valkyrienskies.malumian_skies.common.rite.eldritch;

import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.*;

public class EldritchGravitationalRiteType extends MalumRiteType {
    public EldritchGravitationalRiteType() {
        super("greater_gravitational_rite", ELDRITCH_SPIRIT, ARCANE_SPIRIT, AERIAL_SPIRIT, INFERNAL_SPIRIT);
    }
    @Override
    public MalumRiteEffect getNaturalRiteEffect() {
        return null;
    }

    @Override
    public MalumRiteEffect getCorruptedEffect() {
        return null;
    }
}
