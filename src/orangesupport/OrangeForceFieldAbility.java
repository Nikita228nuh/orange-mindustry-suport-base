package orangesupport;

import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.Unit;

public class OrangeForceFieldAbility extends ForceFieldAbility {

    public OrangeForceFieldAbility(
            float radius,
            float regen,
            float max,
            float cooldown
    ) {
        super(radius, regen, max, cooldown);
    }

    @Override
    public void update(Unit unit) {
        // Run the normal Mindustry force-field behavior.
        super.update(unit);

        // Keep the shield completely regenerated.
        // This makes the field effectively impossible to permanently break.
        unit.shield = max;
    }

    @Override
    public Ability copy() {
        return new OrangeForceFieldAbility(
            radius,
            regen,
            max,
            cooldown
        );
    }
}