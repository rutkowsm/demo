package com.musicstore.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value = "Instrument", description = "Instrument in the offer")
@Entity
public class Instrument {

    @Id
    @ApiModelProperty(value = "Unique identifier if the given instrument", readOnly = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private InstrumentType instrumentType;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    private String model;
    private int yearOfProduction;
    private int price;
    @ApiModelProperty(value = "Information whether an instrument is available")
    private boolean isAvailable;

    public Instrument(){

    }

    public Instrument(Long id, InstrumentType instrumentType, Brand brand, String model, int yearOfProduction, int price, boolean isAvailable) {
        this.id = id;
        this.instrumentType = instrumentType;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id: " + id +
                "Type: " + instrumentType +
                "Brand: " + brand +
                "Model: " + model +
                "Year of production: " + yearOfProduction +
                "Price(pln): " + price +
                "Availability: " + isAvailable + "}";
    }
}
