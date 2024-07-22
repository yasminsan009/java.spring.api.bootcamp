package me.dio.api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_OpeningHours")
public class OpeningHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String weekDay;
    private String weeknd;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getWeekDay() {
        return weekDay;
    }
    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }
    public String getWeeknd() {
        return weeknd;
    }
    public void setWeeknd(String weeknd) {
        this.weeknd = weeknd;
    }
}