package pe.com.utp.service.support.collaborator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador")
@Entity
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colaborador")
    private Integer idColaborador;
    @NotNull
    @Column(name = "nombres")
    private String nombres;
    @NotNull
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @NotNull
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @NotNull
    @Column(name = "numero_documento")
    private Integer numeroDocumento;
    @NotNull
    @Column(name = "codigo_modular")
    private Long codigoModular;
}
