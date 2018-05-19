package com.example.tankstellenbackend.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.UUID;

@Entity
@Table(name = "tankstelle")
public class Tankstelle {

    @Id
    private UUID id;

    @NotEmpty
    private String name;

    @NotNull
    private File picture;

    @NotEmpty
    private String address;

    public Tankstelle(){
        this.id = UUID.randomUUID();
    }

    public Tankstelle(String name, File picture, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.picture = picture;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
