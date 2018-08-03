package com.thunder.laboratory.samples.cure;

import com.thunder.item.Antibiotic;
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

public class StrongAntibiotic extends AbstractEffect {

    public StrongAntibiotic() {
        this(Constants.CURE_BACTERIA_STANDART_DURATION, 0);
    }

    public StrongAntibiotic(int duration, int power) {
        super(Constants.ID_CURE_STRONGANTIBIOTIC, duration, power, false, "Cure: Strong Antibiotic", SampleType.BACTERIA_CURE);
    }

    @Override
    public void performPlayer(Event event, EntityPlayer player, EventType type, IBioPlayer cap) {
        if(type == EventType.TICK && isExpired){
            //remove effects
            for(Integer id : Antibiotic.strongTargetIds){
                IBioSample smp = cap.getEffectById(id);
                if(smp != null){
                    smp.setExpired(true);
                }
            }
            cap.removeImmunity(25);
        }
    }

    @Override
    public void performEntity(Event event, EntityLivingBase entity, EventType type, IBioMob cap) {

    }
}
