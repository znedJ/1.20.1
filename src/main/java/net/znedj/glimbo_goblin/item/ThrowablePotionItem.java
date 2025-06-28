package net.znedj.glimbo_goblin.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ThrowablePotionItem;
import net.minecraft.world.phys.EntityHitResult;
import net.znedj.glimbo_goblin.GlimboMod;

public class ThrowablePotionItem extends ThrowablePotionItem
{
    public ThrowablePotionItem(Properties properties)
    {
        super(properties);
    }
    @Override protected void onImpact(EntityHitResult result)
    {
        if (!this.level.isClientSide && result.getEntity() instanceof LivingEntity target)
        {
            target.addEffect(new MobEffectInstance(GlimboMod.GREEN_SHAKE.get(), 1200));
        }
    }
}