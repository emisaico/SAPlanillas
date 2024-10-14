package pe.com.utp.service.support.payroll.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "planilla")
@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planilla")
    private Integer idPlanilla;
    @NotNull
    @Column(name = "tipo_planilla")
    private String tipoPlanilla;
    @NotNull
    @Column(name = "periodo")
    private String periodo;
    @NotNull
    @Column(name = "codigo_ugel", length = 2)
    private String codigoUgel;
    @NotNull
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

}
