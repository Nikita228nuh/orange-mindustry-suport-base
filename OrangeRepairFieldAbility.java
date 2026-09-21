package orangesupport;

import arc.math.Mathf;
import arc.util.Time;
import mindustry.entities.Units;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Building;
import mindustry.gen.Unit;
import mindustry.ui.Bar;
import mindustry.world.meta.Stat;
import mindustry.graphics.Pal;

import static mindustry.Vars.indexer;

public class OrangeRepairFieldAbility extends Ability {

    public float amount;
    public float range;

    public OrangeRepairFieldAbility(float amount, float range) {
        this.amount = amount;
        this.range = range;
    }

    @Override
    public void update(Unit unit) {
        float heal = amount * Time.delta / 60f;

        // Friendly units.
        Units.nearby(unit.team, unit.x, unit.y, range, other -> {
            if(other != unit && other.damaged()) {
                other.heal(heal);
            }
        });

        // Friendly buildings, including multi-tile buildings whose hitbox reaches
        // the edge of the 10-block radius.
        indexer.eachBlock(unit.team, unit.x, unit.y, range,
            Building::damaged,
            build -> build.heal(heal)
        );
    }

    @Override
    public void addStats(mindustry.ui.layout.Table table) {
        super.addStats(table);
        table.add("Repairs " + amount + " HP/s");
        table.row();
        table.add("Range: " + Mathf.round(range / 8f) + " blocks");
    }

    @Override
    public void displayBars(Unit unit, mindustry.ui.layout.Table bars) {
        // No persistent ability bar needed.
    }
}
