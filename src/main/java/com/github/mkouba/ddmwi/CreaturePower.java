package com.github.mkouba.ddmwi;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.qute.TemplateEnum;

@Entity
@Table(name = "creature_power")
public class CreaturePower extends PanacheEntity {

    public static final int TEXT_LIMIT = 700;

    @ManyToOne
    @JoinColumn(name = "creature_id")
    public Creature creature;

    @NotNull
    public PowerType type;

    @Size(max = TEXT_LIMIT)
    public String text;

    @PositiveOrZero
    public Integer usageLimit;

    public PowerType getType() {
        return type;
    }

    public String getText() {
        return text;
    }
    
    public boolean isAttack() {
        return type == PowerType.ATTACK;
    }
    
    public boolean isAbility() {
        return type == PowerType.ABILITY;
    }
    
    public boolean isSpecial() {
        return type == PowerType.SPECIAL;
    }
    
    public boolean isChampion() {
        return type == PowerType.CHAMPION;
    }

    @TemplateEnum
    public enum PowerType {
        ABILITY,
        SPECIAL,
        ATTACK,
        CHAMPION
    }
}