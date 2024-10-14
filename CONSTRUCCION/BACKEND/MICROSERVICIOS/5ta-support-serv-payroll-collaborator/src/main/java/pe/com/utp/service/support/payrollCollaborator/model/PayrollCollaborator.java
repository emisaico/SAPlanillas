package pe.com.utp.service.support.payrollCollaborator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Table(name = "planilla_colaborador")
@Entity
public class PayrollCollaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planilla_colaborador")
    private Integer idPlanillaColaborador;
    @NotNull
    @Column(name = "id_planilla")
    private Integer idPlanilla;
    @NotNull
    @Column(name = "id_colaborador")
    private Integer idColaborador;
    @NotNull
    @Column(name = "total_haber")
    private Double totalHaber;
    @NotNull
    @Column(name = "total_descuento")
    private Double totalDescuento;

}
