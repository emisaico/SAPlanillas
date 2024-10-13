package pe.com.utp.service.uit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UitResponse {
    @JsonProperty("anio")
    int anio;
    @JsonProperty("valor")
    int valor;
    @JsonProperty("baseLegal")
    String baseLegal;
    @JsonProperty("observaciones")
    String observaciones;
}