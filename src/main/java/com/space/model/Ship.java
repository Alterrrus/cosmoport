package com.space.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "ship")

public class Ship {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //ID корабля
    @Column(name = "name")
    String name;
    //Название корабля (до 50 знаков включительно)
    @Column(name = "planet")
    String planet;
    //Планета пребывания (до 50 знаков включительно)
    @Column(name = "shipType")
            @Enumerated(EnumType.STRING)
    ShipType shipType;
    //Тип корабля
    @Column(name = "prodDate")
    Date prodDate;
    //Дата выпуска.    Диапазон значений года 2800..3019 включительно
    @Column(name = "isUsed")
    Boolean isUsed;
    //Использованный / новый
    @Column(name = "speed")
    Double speed;
    //Максимальная скорость корабля. Диапазон значений 0,01..0,99 включительно. Используй математическое     округление до сотых.
    @Column(name = "crewSize")
    Integer crewSize;
    //Количество членов экипажа. Диапазон значений 1..9999 включительно.
    @Column(name = "rating")
    Double rating;
    //Рейтинг корабля. Используй математическое округление до сотых.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Double rating(){
        double result;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(prodDate);
        double v = speed;
        double k;
        if (isUsed) {k=0.5d;} else {k=1d;}
        long y = 3019;
        long y2 = calendar.get(Calendar.YEAR);
        result= ((80 * v * k) / (y - y2 + 1));
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
