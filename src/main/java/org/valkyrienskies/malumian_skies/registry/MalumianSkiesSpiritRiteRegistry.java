package org.valkyrienskies.malumian_skies.registry;

import com.sammy.malum.core.systems.rites.MalumRiteType;
import com.sammy.malum.core.systems.spirit.MalumSpiritType;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;
import org.valkyrienskies.malumian_skies.common.rite.eldritch.EldritchGravitationalRiteType;

import java.util.ArrayList;
import java.util.List;

import static com.sammy.malum.registry.common.SpiritRiteRegistry.RITES;

public class MalumianSkiesSpiritRiteRegistry {

    public static MalumRiteType GRAVITATIONAL_RITE = create(new GravitationalRiteType());
    public static MalumRiteType ELDRITCH_GRAVITATIONAL_RITE = create(new EldritchGravitationalRiteType());
    public static MalumRiteType create(MalumRiteType type) {
        RITES.add(type);
        return type;
    }

    public static MalumRiteType getRite(String identifier) {
        for (MalumRiteType rite : RITES) {
            if (rite.identifier.equals(identifier)) {
                return rite;
            }
        }
        return null;
    }

    public static MalumRiteType getRite(List<MalumSpiritType> spirits) {
        for (MalumRiteType rite : RITES) {
            if (rite.spirits.equals(spirits)) {
                return rite;
            }
        }
        return null;
    }
}
