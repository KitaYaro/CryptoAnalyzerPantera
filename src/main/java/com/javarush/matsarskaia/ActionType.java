package com.javarush.matsarskaia;

import com.javarush.matsarskaia.Command.Action;
import com.javarush.matsarskaia.Command.BruteForce;
import com.javarush.matsarskaia.Command.Decode;
import com.javarush.matsarskaia.Command.Encode;

public enum ActionType {
    BRUTEFORCE(new BruteForce()),
    DECODE(new Decode()),
    ENCODE(new Encode());

    private final Action action;

    ActionType(Action action) {
        this.action = action;
    }

    public Action getAction() {
        return action;
    }
}
