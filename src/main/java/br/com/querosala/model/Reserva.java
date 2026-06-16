package br.com.querosala.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public Reserva() {
    }

    public Reserva(LocalDateTime dataHoraInicio,
                   LocalDateTime dataHoraFim,
                   Sala sala) {
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public Sala getSala() {
        return sala;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}