package com.example.tankstellenbackend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

@Entity
@Table(name = "bon")
public class Bon {

    @Id
    private UUID id;

    @NotEmpty
    private String tankstellenName;

    private Date datum;

    @NotNull
    private float benzinPreis;

    @NotNull
    private float tankVolumen;

    @NotNull
    private float endPreis;

    public Bon(){}

    public Bon(String tankstellenName, float benzinPreis, float tankVolumen, float endPreis) {
        this.id = UUID.randomUUID();
        this.tankstellenName = tankstellenName;
        this.datum = Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
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

    public UUID getId() {
        return id;
    }

    public void setId(){
        this.id = UUID.randomUUID();
    }
}
