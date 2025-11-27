package com.example.grupo_04_tarea_12_ejercicio_01.data.mock;

import com.example.grupo_04_tarea_12_ejercicio_01.domain.Repository.PagoRepository;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class FakePagoRepositoryImpl implements PagoRepository {

    private List<Pago> pagos;
    private int nextId;

    @Inject
    public FakePagoRepositoryImpl() {
        // Cargar mock data
        this.pagos = new ArrayList<>(MockDataProvider.getPagos());

        // Detectar el siguiente ID disponible
        this.nextId = pagos.stream()
                .mapToInt(Pago::getIdPago)
                .max()
                .orElse(0) + 1;
    }

    @Override
    public void insert(Pago pago) {
        if (pago.getIdPago() == 0) {
            pago.setIdPago(nextId++);
        }
        pagos.add(pago);
    }

    @Override
    public void update(Pago pago) {
        for (int i = 0; i < pagos.size(); i++) {
            if (pagos.get(i).getIdPago() == pago.getIdPago()) {
                pagos.set(i, pago);
                break;
            }
        }
    }

    @Override
    public void delete(Pago pago) {
        pagos.removeIf(p -> p.getIdPago() == pago.getIdPago());
    }

    @Override
    public List<Pago> getAll() {
        return new ArrayList<>(pagos);
    }

    @Override
    public Pago getById(int id) {
        return pagos.stream()
                .filter(p -> p.getIdPago() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Pago> getByReserva(int idReserva) {
        return pagos.stream()
                .filter(p -> p.getIdReserva() == idReserva)
                .collect(Collectors.toList());
    }

    @Override
    public Pago getByComprobante(String numComprobante) {
        return pagos.stream()
                .filter(p -> p.getNumComprobante().equalsIgnoreCase(numComprobante))
                .findFirst()
                .orElse(null);
    }

    @Override
    public double getTotalPagadoReserva(int idReserva) {
        return pagos.stream()
                .filter(p -> p.getIdReserva() == idReserva)
                .mapToDouble(Pago::getMonto)
                .sum();
    }

    @Override
    public void deleteAll() {
        pagos.clear();
    }
}
