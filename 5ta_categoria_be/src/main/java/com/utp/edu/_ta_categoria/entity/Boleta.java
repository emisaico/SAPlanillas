package com.utp.edu._ta_categoria.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "boleta")
@Entity
public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_boleta;

    private String tipo_planilla;
    @Column(name = "mes_anio")
    private String mesAnio;
    private String codmodular;
    private Integer nr_registro;
    private String nombres;
    private String cod_concepto;
    private String concepto;
    private Double monto_bruto;

    public Integer getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(Integer id_boleta) {
        this.id_boleta = id_boleta;
    }

    public String getTipo_planilla() {
        return tipo_planilla;
    }

    public void setTipo_planilla(String tipo_planilla) {
        this.tipo_planilla = tipo_planilla;
    }

    public String getMesAnio() {
        return mesAnio;
    }

    public void setMesAnio(String mesAnio) {
        this.mesAnio = mesAnio;
    }

    public String getCodmodular() {
        return codmodular;
    }

    public void setCodmodular(String codmodular) {
        this.codmodular = codmodular;
    }

    public Integer getNr_registro() {
        return nr_registro;
    }

    public void setNr_registro(Integer nr_registro) {
        this.nr_registro = nr_registro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCod_concepto() {
        return cod_concepto;
    }

    public void setCod_concepto(String cod_concepto) {
        this.cod_concepto = cod_concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getMonto_bruto() {
        return monto_bruto;
    }

    public void setMonto_bruto(Double monto_bruto) {
        this.monto_bruto = monto_bruto;
    }
}
