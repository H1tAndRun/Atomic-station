package ru.academy.entity;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("morocco")
public class MoroccoEconomicDepartment implements EconomicDepartment {
    @Override
    public double computeYearIncomes(long countElectricity) {
        double costPerUnit = 5;
        double totalSum = 0;
        long thresholdValue = 5000000000L;
        if (countElectricity / 1000000000 > 5) {
            totalSum += thresholdValue * costPerUnit;
            costPerUnit = 6;
            totalSum += costPerUnit * (countElectricity % 1000000000L);
        } else {
            totalSum += countElectricity * costPerUnit;
        }
        return totalSum;
    }
}
