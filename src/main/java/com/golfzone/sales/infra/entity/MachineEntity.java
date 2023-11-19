package com.golfzone.sales.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Entity
@Table(name = "Machine")
public class MachineEntity {
    @Id
    private String id;
    private String name;

    private boolean enabled;

}
