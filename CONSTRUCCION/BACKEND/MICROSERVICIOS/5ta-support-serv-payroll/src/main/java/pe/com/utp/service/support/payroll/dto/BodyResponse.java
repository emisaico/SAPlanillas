package pe.com.utp.service.support.payroll.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BodyResponse {
    @JsonProperty("idTransaction")
    private String idTransaction;
    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("idRegistry")
    private String idRegistry;
}