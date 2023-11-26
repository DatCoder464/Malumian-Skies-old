package org.valkyrienskies.malumian_skies.registry.rites;

import com.sammy.malum.core.systems.rites.MalumRiteType;
import com.sammy.malum.registry.common.SpiritRiteRegistry;
import org.valkyrienskies.malumian_skies.common.rite.GravitationalRiteType;
import org.valkyrienskies.malumian_skies.common.rite.eldritch.EldritchGravitationalRiteType;

import static com.sammy.malum.registry.common.SpiritRiteRegistry.RITES;

public class   MSRiteRegistry {
    public static MalumRiteType GRAVITATIONAL_RITE = SpiritRiteRegistry.create(new GravitationalRiteType());
    public static MalumRiteType ELDRITCH_GRAVITATIONAL_RITE = SpiritRiteRegistry.create(new EldritchGravitationalRiteType());


    public static void init() {
        System.out.print("rites_work");
    }
}
