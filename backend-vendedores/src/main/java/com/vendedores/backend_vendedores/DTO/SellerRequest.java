package com.vendedores.backend_vendedores.DTO;

import com.vendedores.backend_vendedores.models.Seller;

public class SellerRequest {
    private String name;
    private double salary;
    private double bonus;
    private int gender;

    public Seller toEntity() {
        Seller seller = new Seller();
        seller.setName(name);
        seller.setSalary(salary);
        seller.setBonus(bonus);
        seller.setGender(gender);

        return seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
