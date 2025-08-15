package com.vendedores.backend_vendedores.DTO;

import com.vendedores.backend_vendedores.models.Seller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SellerRequest {
    @NotBlank(message = "Name can not be null")
    @Size(min = 5, max = 255, message = "Name length min = 5 and max = 255")
    private String name;

    @NotBlank(message = "Salary can not be null")
    @Min(value = 1, message = "salary min value = 1")
    private double salary;

    @NotBlank(message = "Bonus can not be null")
    @Min(value = 0, message = "bonus min value = 0")
    @Max(value = 100, message = "bonus max value = 100")
    private double bonus;
    
    @NotBlank(message = "gender can not be null")
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
