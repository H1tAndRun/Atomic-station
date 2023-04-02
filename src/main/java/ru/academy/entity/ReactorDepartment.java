package ru.academy.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.academy.exception.NuclearFuelIsEmptyException;
import ru.academy.exception.ReactorWorkException;

@Component
public class ReactorDepartment {

    private boolean isWorking;

    private double producedEnergy = 10000000;

    private int countLaunches = 0;

    @Lazy
    @Autowired
    private  SecurityDepartment securityDepartment;

    public double run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWorking) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже работает");
        }
        isWorking = true;
        if (countLaunches == 100) {
            countLaunches = 0;
            stop();
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException("Не хватает топлива");
        }
        countLaunches++;
        return producedEnergy;
    }

    public void stop() throws ReactorWorkException {
        if (!isWorking) {
            securityDepartment.addAccident();
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWorking = false;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public double getProducedEnergy() {
        return producedEnergy;
    }

    public void setProducedEnergy(double producedEnergy) {
        this.producedEnergy = producedEnergy;
    }
}
