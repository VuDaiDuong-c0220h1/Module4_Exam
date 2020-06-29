package com.codegym.exam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotNull(message = "Không được để trống")
    @Size(min = 2, message = "Tên thành phố ít nhất có 2 ký tự")
    private String cityName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    @Min(value = 1, message = "Diện tích phải lớn hơn 0")
    @NotNull(message = "Không được để trống")
    private double area;

    @Column(nullable = false)
    @Min(value = 1, message = "Dân số phải lớn hơn 0")
    @NotNull(message = "Không được để trống")
    private int population;

    @Column(nullable = false)
    @Min(value = 1, message = "GDP phải lớn hơn 0")
    @NotNull(message = "Không được để trống")
    private double gdp;

    @Column(nullable = false)
    @Size(min = 5, message = "Tối thiểu 5 chữ cái")
    @NotNull(message = "Không được để trống")
    private String description;
}
