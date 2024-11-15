package pe.com.utp.service.support.auth.account.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
@Table(name = "usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido_paterno;

    @NotNull
    private String apellido_materno;

    @NotNull
    private String dni;

    @NotNull
    private String fecha_nacimiento;

    @NotNull
    private String telefono;

    @NotNull
    private String imagen;

    @Email(message = "Email incorrecto")
    @NotNull
    private String email;

    @NotNull
    private String contrasenia;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;
}
