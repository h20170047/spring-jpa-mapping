package com.svj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int engId;
    private String name;
    private String dept;
    private String email;
}
