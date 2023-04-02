package ru.academy.entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("france")
public class FranceEconomicDepartment implements EconomicDepartment{

    @Override
    public double computeYearIncomes(long countElectricity) {
        double costPerUnit = 0.5;
        double totalSum = 0.0;
        long billionsOfKilowattHours = countElectricity / 1000000000L;
        for (int i = 0; i < billionsOfKilowattHours; i++) {
            totalSum += 1000000000L * costPerUnit;
            costPerUnit *= 0.99;
        }
        long remainingKilowattHours = countElectricity % 1000000000L;
        totalSum += remainingKilowattHours * costPerUnit;
        return totalSum;
    }
}
