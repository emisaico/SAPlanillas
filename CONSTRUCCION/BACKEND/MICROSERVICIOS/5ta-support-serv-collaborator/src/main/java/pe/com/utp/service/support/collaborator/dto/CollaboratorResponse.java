package pe.com.utp.service.support.collaborator.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CollaboratorResponse {
    private String idColaborador;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroDocumento;
    private String codigoModular;
    private String codigoSecuencial;
}