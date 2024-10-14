package pe.com.utp.service.support.payroll.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayrollRequest {
    private String tipoPlanilla;
    private String periodo;
    private String codigoUgel;
    private String fechaRegistro;
    private String fechaModificacion;
}
