package com.example.grupo_04_tarea_12_ejercicio_01.data.mock;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.ReservaRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class FakeReservaRepositoryImpl implements ReservaRepository {

    private List<Reserva> reservas;
    private int nextId;

    @Inject
    public FakeReservaRepositoryImpl() {
        // Cargar datos mock
        this.reservas = new ArrayList<>(MockDataProvider.getReservas());
        // Calcular el próximo ID disponible
        this.nextId = reservas.stream()
                .mapToInt(Reserva::getIdReserva)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public void insert(Reserva reserva) {
        if (reserva.getIdReserva() == 0) {
            reserva.setIdReserva(nextId++);
        }
        reservas.add(reserva);
    }

    @Override
    public void update(Reserva reserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdReserva() == reserva.getIdReserva()) {
                reservas.set(i, reserva);
                break;
            }
        }
    }

    @Override
    public void delete(Reserva reserva) {
        reservas.removeIf(r -> r.getIdReserva() == reserva.getIdReserva());
    }

    @Override
    public List<Reserva> getAll() {
        return new ArrayList<>(reservas);
    }

    @Override
    public Reserva getById(int id) {
        return reservas.stream()
                .filter(r -> r.getIdReserva() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reserva> getByPasajero(int idPasajero) {
        return reservas.stream()
                .filter(r -> r.getIdPasajero() == idPasajero)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> getByVuelo(int idVuelo) {
        return reservas.stream()
                .filter(r -> r.getIdVuelo() == idVuelo)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> getReservasPasajeroOrdenadas(int idPasajero) {
        List<Reserva> reservasPasajero = getByPasajero(idPasajero);
        Collections.sort(reservasPasajero, new Comparator<Reserva>() {
            @Override
            public int compare(Reserva r1, Reserva r2) {
                return r2.getFecha().compareTo(r1.getFecha()); // Orden descendente
            }
        });
        return reservasPasajero;
    }

    @Override
    public void deleteAll() {
        reservas.clear();
    }
}