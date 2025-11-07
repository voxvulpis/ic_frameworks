package br.unesp.entity;

import java.io.Serializable;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Acesso extends PanacheEntityBase implements Serializable{
    private static final long serialVersionUID = 1L;
    @Column(name = "acesso_usuario")
    private String usuario;
    @Column(name = "acesso_senha")
    private String senha;

    public Acesso(){}
}
