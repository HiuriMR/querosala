package br.com.querosala.model;

import jakarta.persistence.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer capacidade;
    @Column(nullable = false)
    private Integer andar;
    @OneToMany(mappedBy = "sala", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    public Sala(){}

    public Sala(String nome, Integer capacidade, Integer andar){
        this.nome = nome;
        this.capacidade = capacidade;
        this.andar = andar;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public Integer getAndar() {
        return andar;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
