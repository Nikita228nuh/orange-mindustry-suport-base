package orangesupport;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import mindustry.entities.abilities.Ability;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.gen.Unit;

public class OrangeForceFieldAbility extends ForceFieldAbility {

    public float power = 999999f;
    public Color fieldColor = Color.valueOf("ff8a00");

    public OrangeForceFieldAbility() {
        super(120f, 25f, 999999f, 60f);
    }

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
        // Keep the shield effectively full.
        // The normal ForceFieldAbility handles the actual shield behavior.
        super.update(unit);
    }

    @Override
    public void draw(Unit unit) {
        float r = radius * radiusScale;

        if (r <= 0f) return;

        float alpha = 0.16f + Mathf.absin(5f, 0.06f);

        Draw.z(110f);

        Draw.color(fieldColor, alpha);

        Fill.circle(
                unit.x,
                unit.y,
                r
        );

        Draw.color(fieldColor, 0.75f);

        // Outer ring
        Draw.alpha(0.75f);
        Draw.circle(
                unit.x,
                unit.y,
                r
        );

        Draw.alpha(1f);
        Draw.reset();
    }

    @Override
    public Ability copy() {
        OrangeForceFieldAbility ability =
                new OrangeForceFieldAbility(
                        radius,
                        regen,
                        max,
                        cooldown
                );

        ability.sides = sides;
        ability.rotation = rotation;
        ability.power = power;
        ability.fieldColor = fieldColor.cpy();

        return ability;
    }
}