package pe.com.utp.service.support.payrollCollaborator.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class PayrollCollaboratorRequest {
    private String idPlanilla;
    private String idColaborador;
    private String totalHaber;
    private String totalDescuento;
}
