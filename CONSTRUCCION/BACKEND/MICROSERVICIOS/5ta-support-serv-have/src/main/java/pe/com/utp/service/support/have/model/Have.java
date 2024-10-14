package pe.com.utp.service.support.have.model;

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
@Table(name = "haber")
@Entity
public class Have {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_haber")
    private Integer idHaber;
    @Column(name = "H001")
    @NotNull
    private String h001;
    @Column(name = "H002")
    @NotNull
    private String h002;
    @Column(name = "H003")
    @NotNull
    private String h003;
    @Column(name = "H004")
    @NotNull
    private String h004;
    @Column(name = "H006")
    @NotNull
    private String h006;
    @Column(name = "H008")
    @NotNull
    private String h008;
    @Column(name = "H009")
    @NotNull
    private String h009;
    @Column(name = "H010")
    @NotNull
    private String h010;
    @Column(name = "H012")
    @NotNull
    private String h012;
    @Column(name = "H014")
    @NotNull
    private String h014;
    @Column(name = "H017")
    @NotNull
    private String h017;
    @Column(name = "H023")
    @NotNull
    private String h023;
    @Column(name = "H024")
    @NotNull
    private String h024;
    @Column(name = "H025")
    @NotNull
    private String h025;
    @Column(name = "H026")
    @NotNull
    private String h026;
    @Column(name = "H033")
    @NotNull
    private String h033;
    @Column(name = "H079")
    @NotNull
    private String h079;
    @Column(name = "H080")
    @NotNull
    private String h080;
    @Column(name = "H082")
    @NotNull
    private String h082;
    @Column(name = "H090")
    @NotNull
    private String h090;
    @Column(name = "H092")
    @NotNull
    private String h092;
    @Column(name = "H099")
    @NotNull
    private String h099;
    @Column(name = "H100")
    @NotNull
    private String h100;
    @Column(name = "H136")
    @NotNull
    private String h136;
    @Column(name = "H150")
    @NotNull
    private String h150;
    @Column(name = "H162")
    @NotNull
    private String h162;
    @Column(name = "H170")
    @NotNull
    private String h170;
    @Column(name = "H177")
    @NotNull
    private String h177;
    @Column(name = "H178")
    @NotNull
    private String h178;
    @Column(name = "H181")
    @NotNull
    private String h181;
    @Column(name = "H185")
    @NotNull
    private String h185;
    @Column(name = "H206")
    @NotNull
    private String h206;
    @Column(name = "H231")
    @NotNull
    private String h231;
    @Column(name = "H244")
    @NotNull
    private String h244;
    @Column(name = "H259")
    @NotNull
    private String h259;
    @Column(name = "H261")
    @NotNull
    private String h261;
    @Column(name = "H263")
    @NotNull
    private String h263;
    @Column(name = "H264")
    @NotNull
    private String h264;
    @Column(name = "H271")
    @NotNull
    private String h271;
    @Column(name = "H277")
    @NotNull
    private String h277;
    @Column(name = "H288")
    @NotNull
    private String h288;
    @Column(name = "H303")
    @NotNull
    private String h303;
    @Column(name = "H309")
    @NotNull
    private String h309;
    @Column(name = "H310")
    @NotNull
    private String h310;
    @Column(name = "id_planilla_colaborador")
    @NotNull
    private Integer idPlanillaColaborador;
}
