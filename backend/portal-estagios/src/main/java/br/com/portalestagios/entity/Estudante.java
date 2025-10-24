package br.com.portalestagios.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String curso;
    private String email;
    private String telefone;

    @ManyToMany
    private Set<AreaInteresse> interesses;
}
