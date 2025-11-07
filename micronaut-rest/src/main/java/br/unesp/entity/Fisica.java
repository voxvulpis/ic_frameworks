package br.unesp.entity;

import java.time.LocalDate;
// import java.util.Date;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
// import jakarta.persistence.Temporal;
// import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Introspected
@Table(name = "PessoaFisica")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"dataNascimento"})
@ToString(callSuper = true, includeFieldNames = true)
@Serdeable
public class Fisica extends Pessoa{
    // private static final long serialVersionUID = 1L;
    @Column(name = "cpf", unique = true)
    private String cpf;
    // @Temporal(TemporalType.TIMESTAMP)
    private LocalDate dataNascimento;

    public Fisica(){}
}
