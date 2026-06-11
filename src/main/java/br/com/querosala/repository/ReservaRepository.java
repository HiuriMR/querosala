package br.com.querosala.repository;

import br.com.querosala.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("select r from Reserva r where r.sala.id = :salaId")
    List<Reserva> buscarReservasDaSala(Long salaId);
}
