package com.thunder.laboratory.samples.cure;

import com.thunder.laboratory.AbstractEffect;
import com.thunder.laboratory.EventType;
import com.thunder.laboratory.IBioSample;
import com.thunder.laboratory.SampleType;
import com.thunder.mob.IBioMob;
import com.thunder.player.IBioPlayer;
import com.thunder.util.Constants;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

public class CureCold extends AbstractEffect {

    public CureCold() {
        this(Constants.CURE_EFFECT_STANDART_DURATION, 0);
    }

    public CureCold(int duration, int power) {
        super(Constants.ID_CURE_COLD, duration, power, false, "Cure: Cold", SampleType.EFFECT_CURE);
    }

    @Override
    public void performPlayer(Event event, EntityPlayer player, EventType type, IBioPlayer cap) {
        if(type == EventType.TICK && isExpired){
            IBioSample smp = cap.getEffectById(Constants.ID_COLD);
            if(smp != null) smp.setExpired(true);
        }
    }

    @Override
    public void performEntity(Event event, EntityLivingBase entity, EventType type, IBioMob cap) {

    }
}
