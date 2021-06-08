package com.devdro.dextra_challenge.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

    @Column
    protected String name;

    public NamedEntity(String name) {
        this.name = name;
    }

    public NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }
}
