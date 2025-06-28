package net.znedj.glimbo_goblin.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class GreenShakeEffect extends MobEffect {
    public GreenShakeEffect() {
        super(MobEffectCategory.HARMFUL, 0x00FF00);
        addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.25, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        int duration = entity.getEffect(this).getDuration();
        int phase = (600 - duration) / 300;

        switch (phase) {
            case 0 -> {
                entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 0));
            }
            case 1 -> {
                entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 300, 0));
            }
            case 2 -> {
                entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0));
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 1));
            }
            case 3 -> {
                entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 300, 0));
                entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
            }
            default -> {
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, 1));
                entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, duration, 0));
            }
        }

        entity.setDeltaMovement(entity.getDeltaMovement().add(
                (Math.random() - 0.5) * 0.1,
                Math.random() * 0.05,
                (Math.random() - 0.5) * 0.1
        ));
    }

    @Override public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}