package com.example.tankstellenbackend.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bon")
public class Bon {

    @Id
    private UUID id;

    @NotEmpty
    private String tankstellenName;

    @NotNull
    private LocalDate datum;

    @NotNull
    private float benzinPreis;

    @NotNull
    private float tankVolumen;

    @NotNull
    private float endPreis;

    public Bon(){
        this.id = UUID.randomUUID();
    }

    public Bon(String tankstellenName, float benzinPreis, float tankVolumen, float endPreis) {
        this.id = UUID.randomUUID();
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

    /*public void setDatum(String datum){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate tmpDatum = LocalDate.parse(datum, formatter);
            this.datum = Date.from(tmpDatum.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e){
            System.out.println("Formatierungsfehler Datum ..." + datum);
        }
    }*/

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

    public String getMonat(){
        return this.datum.getMonth().toString();
    }

    public void setId(){
        this.id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Bon{" +
                "id=" + id +
                ", tankstellenName='" + tankstellenName + '\'' +
                ", datum=" + datum +
                ", benzinPreis=" + benzinPreis +
                ", tankVolumen=" + tankVolumen +
                ", endPreis=" + endPreis +
                '}';
    }
}
