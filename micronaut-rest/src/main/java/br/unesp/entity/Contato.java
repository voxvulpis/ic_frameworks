package br.unesp.entity;

// import java.io.Serializable;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Contato")
@Introspected
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@Serdeable
public class Contato{
    // private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @SequenceGenerator(name = "contatoSeq", sequenceName = "contato_id_seq", allocationSize = 1, initialValue = 1)
    // @GeneratedValue(generator = "contatoSeq")
    private long idContato;
    private String telefoneResidencial;
    private String telefoneComercial;
    private String celular;
    private String email;

    public Contato(){}

    public void setIdContato(){
    }
}
