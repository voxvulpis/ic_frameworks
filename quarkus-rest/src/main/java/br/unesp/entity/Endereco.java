package br.unesp.entity;

import java.io.Serializable;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Endereco")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Endereco extends PanacheEntityBase implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEndereco;
    private String rua;
    private int numero;
    private String bairro;
    private String cep;
    private String estado;
    private String cidade;

    public void setIdEndereco(){

    }
}
