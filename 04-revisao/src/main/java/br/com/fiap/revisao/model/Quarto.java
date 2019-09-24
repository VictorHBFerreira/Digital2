package br.com.fiap.revisao.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="quarto",sequenceName = "SQ_T_QUARTO",allocationSize = 1)
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quarto")
    private int codigo;

    private int numero;

    private boolean suite;

    private float valor;

    @ManyToOne
    private Hotel hotel;

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
