package br.com.fiap.revisao.model;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name="hostel", sequenceName="SQ_T_HOTEL", allocationSize = 1)
public class Hotel {
    @Id
    @GeneratedValue(generator = "hotal", strategy = GenerationType.SEQUENCE)
    @Column(name="cd_hotel")
    private int codigo;
    @Column(name="nm_hotel")
    private String nome;
    @Column(name="boolean_aceitaAnimais")
    private boolean aceitaAnimais;
    @Column(name="dt_abertura")
    private LocalDate dataAbertura;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAceitaAnimais() {
        return aceitaAnimais;
    }

    public void setAceitaAnimais(boolean aceitaAnimais) {
        this.aceitaAnimais = aceitaAnimais;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
