package pe.com.utp.service.support.discount.model;

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
@Table(name = "descuento")
@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento")
    private Integer idDescuento;
    @NotNull
    @Column(name = "D0001")
    @NotNull
    private String d0001;
    @Column(name = "D0002")
    @NotNull
    private String d0002;
    @Column(name = "D0004")
    @NotNull
    private String d0004;
    @Column(name = "D0005")
    @NotNull
    private String d0005;
    @Column(name = "D0006")
    @NotNull
    private String d0006;
    @Column(name = "D0008")
    @NotNull
    private String d0008;
    @Column(name = "D0009")
    @NotNull
    private String d0009;
    @Column(name = "D0015")
    @NotNull
    private String d0015;
    @Column(name = "D0021")
    @NotNull
    private String d0021;
    @Column(name = "D0023")
    @NotNull
    private String d0023;
    @Column(name = "D0026")
    @NotNull
    private String d0026;
    @Column(name = "D0054")
    @NotNull
    private String d0054;
    @Column(name = "D0109")
    @NotNull
    private String d0109;
    @Column(name = "D0113")
    @NotNull
    private String d0113;
    @Column(name = "D0115")
    @NotNull
    private String d0115;
    @Column(name = "D0118")
    @NotNull
    private String d0118;
    @Column(name = "D0121")
    @NotNull
    private String d0121;

    @Column(name = "D0130")
    @NotNull
    private String d0130;
    @Column(name = "D0139")
    @NotNull
    private String d0139;
    @Column(name = "D0140")
    @NotNull
    private String d0140;
    @Column(name = "D0143")
    @NotNull
    private String d0143;
    @Column(name = "D0151")
    @NotNull
    private String d0151;
    @Column(name = "D0190")
    @NotNull
    private String d0190;
    @Column(name = "D0417")
    @NotNull
    private String d0417;
    @Column(name = "D0418")
    @NotNull
    private String d0418;
    @Column(name = "D0856")
    @NotNull
    private String d0856;
    @Column(name = "D1010")
    @NotNull
    private String d1010;
    @Column(name = "D1145")
    @NotNull
    private String d1145;
    @Column(name = "D1146")
    @NotNull
    private String d1146;
    @Column(name = "D1723")
    @NotNull
    private String d1723;
    @Column(name = "D1763")
    @NotNull
    private String d1763;
    @Column(name = "D1784")
    @NotNull
    private String d1784;
    @Column(name = "D1819")
    @NotNull
    private String d1819;
    @Column(name = "D1829")
    @NotNull
    private String d1829;
    @Column(name = "id_planilla_colaborador")
    @NotNull
    private Integer idPlanillaColaborador;
}
