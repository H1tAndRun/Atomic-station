package ru.academy.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityDepartment {

    private final NuclearStation nuclearStation;

    private int accidentCountPeriod;

    @Autowired
    public SecurityDepartment(NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

    public void addAccident() {
        accidentCountPeriod++;
    }

    public void reset() {
        nuclearStation.setAccidentCountAllTime(nuclearStation.getAccidentCountAllTime()+accidentCountPeriod);
        accidentCountPeriod = 0;
    }

    public int getAccidentCountPeriod() {
        return accidentCountPeriod;
    }

    public NuclearStation getNuclearStation() {
        return nuclearStation;
    }
}
