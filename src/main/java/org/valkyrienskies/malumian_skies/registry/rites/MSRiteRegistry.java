package org.valkyrienskies.malumian_skies.registry.rites;

import com.sammy.malum.core.systems.rites.MalumRiteType;
import com.sammy.malum.registry.common.SpiritRiteRegistry;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;

public class MSRiteRegistry {
    public static MalumRiteType GRAVITATIONAL_RITE = SpiritRiteRegistry.create(new GravitationalRiteType());
}
