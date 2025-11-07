package br.unesp.entity;

// import java.io.Serializable;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Introspected
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
@Serdeable
public class Acesso{
    // private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "acesso_usuario")
    private String usuario;
    @Column(name = "acesso_senha")
    private String senha;

    public Acesso(){}
}
