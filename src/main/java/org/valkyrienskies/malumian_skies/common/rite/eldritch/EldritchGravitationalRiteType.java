package org.valkyrienskies.malumian_skies.common.rite.eldritch;

import com.sammy.malum.core.systems.rites.MalumRiteEffect;
import com.sammy.malum.core.systems.rites.MalumRiteType;

import static com.sammy.malum.registry.common.SpiritTypeRegistry.ARCANE_SPIRIT;
import static com.sammy.malum.registry.common.SpiritTypeRegistry.ELDRITCH_SPIRIT;
import static org.valkyrienskies.malumian_skies.registry.MalumianSkiesSpiritTypeRegistry.GRAVITATIONAL_SPIRIT;

public class EldritchGravitationalRiteType extends MalumRiteType {
    public EldritchGravitationalRiteType() {
        super("greater_gravitational_rite", ELDRITCH_SPIRIT, ARCANE_SPIRIT, GRAVITATIONAL_SPIRIT, GRAVITATIONAL_SPIRIT);
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
