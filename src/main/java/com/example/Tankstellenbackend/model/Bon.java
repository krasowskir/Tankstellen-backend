package com.example.Tankstellenbackend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Bon {

    @NotEmpty
    private String tankstellenName;

    private LocalDate datum;

    @NotNull
    private float benzinPreis;

    @NotNull
    private float tankVolumen;

    @NotNull
    private float endPreis;

    public Bon(String tankstellenName, float benzinPreis, float tankVolumen, float endPreis) {
        this.tankstellenName = tankstellenName;
        this.datum = LocalDate.now();
        this.benzinPreis = benzinPreis;
        this.tankVolumen = tankVolumen;
        this.endPreis = endPreis;
    }

    public String getTankstellenName() {
        return tankstellenName;
    }

    public void setTankstellenName(String tankstellenName) {
        this.tankstellenName = tankstellenName;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public float getBenzinPreis() {
        return benzinPreis;
    }

    public void setBenzinPreis(float benzinPreis) {
        this.benzinPreis = benzinPreis;
    }

    public float getTankVolumen() {
        return tankVolumen;
    }

    public void setTankVolumen(float tankVolumen) {
        this.tankVolumen = tankVolumen;
    }

    public float getEndPreis() {
        return endPreis;
    }

    public void setEndPreis(float endPreis) {
        this.endPreis = endPreis;
    }
}
