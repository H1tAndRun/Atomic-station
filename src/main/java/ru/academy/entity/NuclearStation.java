package ru.academy.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class NuclearStation {

    private final ReactorDepartment reactorDepartment;

    @Lazy
    @Autowired
    private SecurityDepartment securityDepartment;

    private final CountryInfo countryInfo;

    private final EconomicDepartment economicDepartment;

    private BigDecimal countEnergy = new BigDecimal(0);

    private int accidentCountAllTime = 0;

    @Autowired
    public NuclearStation(ReactorDepartment reactorDepartment,
                          CountryInfo countryInfo,
                          EconomicDepartment economicDepartment) {
        this.countryInfo = countryInfo;
        this.economicDepartment = economicDepartment;
        this.reactorDepartment = reactorDepartment;
    }

    public void start(int year) {
        // System.out.println("Действия происходит в стране" + countryInfo.getCountryName());
        for (int i = 0; i < year; i++) {
            startYear();
        }
        System.out.println("Количество инцидентов за всю работу станции:" + accidentCountAllTime);
    }

    private void startYear() {
        System.out.println("Атомная станция начала работу");
        for (int i = 0; i < 365; i++) {
            try {
                countEnergy = countEnergy.add(BigDecimal.valueOf(reactorDepartment.run()));
                reactorDepartment.stop();
            } catch (Exception e) {
                System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!" + e.getMessage());
            }
        }
        System.out.println("Атомная станция закончила работу. За год выработона"
                + countEnergy.toString() + "килловат/часов");
        System.out.println("Колличество аварий за период " + securityDepartment.getAccidentCountPeriod());
        System.out.println("Доход за год составил " + economicDepartment.computeYearIncomes(countEnergy.longValue())
                + " " + countryInfo.getCurrencyName());
        countEnergy = new BigDecimal(0);
        securityDepartment.reset();
    }

    public void incrementAccident(int count) {
        accidentCountAllTime += count;
    }

    public int getAccidentCountAllTime() {
        return accidentCountAllTime;
    }

    public void setAccidentCountAllTime(int accidentCountAllTime) {
        this.accidentCountAllTime = accidentCountAllTime;
    }
}
