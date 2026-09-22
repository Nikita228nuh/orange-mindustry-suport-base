package orangesupport;

import arc.util.Time;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;

import static mindustry.Vars.indexer;

public class OrangeRepairFieldAbility extends Ability {

    private final float healAmount;
    private final float range;

    public OrangeRepairFieldAbility(float healAmount, float range) {
        this.healAmount = healAmount;
        this.range = range;
    }

    @Override
    public void update(Unit unit) {
        float heal = healAmount * Time.delta / 60f;

        // Repair nearby friendly units.
        mindustry.entities.Units.nearby(
            unit.team,
            unit.x,
            unit.y,
            range,
            other -> {
                if (other != unit && other.damaged()) {
                    other.heal(heal);
                }
            }
        );

        // Repair nearby friendly buildings.
        indexer.allBuildings(
            unit.x,
            unit.y,
            range,
            building -> {
                if (building.team == unit.team && building.damaged()) {
                    building.heal(heal);
                }
            }
        );
    }
}
