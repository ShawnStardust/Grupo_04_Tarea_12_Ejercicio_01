package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.reservas;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase.ReservaUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReservasListFragment extends Fragment {

    @Inject
    ReservaUseCase reservaUseCase;

    private RecyclerView recyclerViewReservas;
    private TextView tvEmptyReservas;
    private FloatingActionButton fabAddReserva;
    private ReservasAdapter adapter;
    private List<Reserva> reservasList;

    public ReservasListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservas_list, container, false);

        // Inicializar vistas
        recyclerViewReservas = view.findViewById(R.id.recyclerViewReservas);
        tvEmptyReservas = view.findViewById(R.id.tvEmptyReservas);
        fabAddReserva = view.findViewById(R.id.fabAddReserva);

        // Configurar RecyclerView
        recyclerViewReservas.setLayoutManager(new LinearLayoutManager(getContext()));
        reservasList = new ArrayList<>();
        adapter = new ReservasAdapter(reservasList, this::onEditReserva, this::onDeleteReserva);
        recyclerViewReservas.setAdapter(adapter);

        // Configurar FAB
        fabAddReserva.setOnClickListener(v -> openReservaForm(null));

        // Cargar datos
        loadReservas();

        return view;
    }

    private void loadReservas() {
        // Ejecutar en un hilo separado
        new Thread(() -> {
            List<Reserva> reservas = reservaUseCase.getAllReservas();

            // Actualizar UI en el hilo principal
            if (getActivity() != null) {
                getActivity().runOnUiThread(() -> {
                    reservasList.clear();
                    reservasList.addAll(reservas);
                    adapter.notifyDataSetChanged();

                    // Mostrar mensaje si está vacío
                    if (reservasList.isEmpty()) {
                        recyclerViewReservas.setVisibility(View.GONE);
                        tvEmptyReservas.setVisibility(View.VISIBLE);
                    } else {
                        recyclerViewReservas.setVisibility(View.VISIBLE);
                        tvEmptyReservas.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }

    private void openReservaForm(Reserva reserva) {
        // Aquí abrirías un dialog o fragment para crear/editar
        // Por ahora solo recargaremos la lista
        loadReservas();
    }

    private void onEditReserva(Reserva reserva) {
        openReservaForm(reserva);
    }

    private void onDeleteReserva(Reserva reserva) {
        new Thread(() -> {
            reservaUseCase.deleteReserva(reserva);

            if (getActivity() != null) {
                getActivity().runOnUiThread(this::loadReservas);
            }
        }).start();
    }
}