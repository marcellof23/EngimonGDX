package com.ungabunga.model.entities;

import com.ungabunga.model.enums.AVATAR_STATE;
import com.ungabunga.model.exceptions.FeatureNotImplementedException;
import com.ungabunga.model.utilities.Pair;
import com.ungabunga.model.enums.DIRECTION;

public interface LivingEngimon {

    public void move(int dx,int dy);

    public void repositionOnCellConflict() throws FeatureNotImplementedException;

    public Pair<Integer,Integer> getPosition() throws FeatureNotImplementedException;
    public int getRemainingLives();
    public boolean isDead();
    public void reduceLives();
    public String getEngimonSpecies();
    public AVATAR_STATE getState();

    public DIRECTION getDirection();
}
