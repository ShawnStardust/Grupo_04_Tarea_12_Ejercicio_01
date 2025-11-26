package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.pagos;

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
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.usecase.PagoUseCase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PagosListFragment extends Fragment {

    @Inject
    PagoUseCase pagoUseCase;

    private RecyclerView recyclerViewPagos;
    private TextView tvEmptyPagos;
    private FloatingActionButton fabAddPago;
    private PagosAdapter adapter;
    private List<Pago> pagosList;

    public PagosListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagos_list, container, false);

        // Inicializar vistas
        recyclerViewPagos = view.findViewById(R.id.recyclerViewPagos);
        tvEmptyPagos = view.findViewById(R.id.tvEmptyPagos);
        fabAddPago = view.findViewById(R.id.fabAddPago);

        // Configurar RecyclerView
        recyclerViewPagos.setLayoutManager(new LinearLayoutManager(getContext()));
        pagosList = new ArrayList<>();
        adapter = new PagosAdapter(pagosList, this::onEditPago, this::onDeletePago);
        recyclerViewPagos.setAdapter(adapter);

        // Configurar FAB
        fabAddPago.setOnClickListener(v -> openPagoForm(null));

        // Cargar datos
        loadPagos();

        return view;
    }

    private void loadPagos() {
        // Ejecutar en un hilo separado
        new Thread(() -> {
            List<Pago> pagos = pagoUseCase.getAllPagos();

            // Actualizar UI en el hilo principal
            if (getActivity() != null) {
                getActivity().runOnUiThread(() -> {
                    pagosList.clear();
                    pagosList.addAll(pagos);
                    adapter.notifyDataSetChanged();

                    // Mostrar mensaje si está vacío
                    if (pagosList.isEmpty()) {
                        recyclerViewPagos.setVisibility(View.GONE);
                        tvEmptyPagos.setVisibility(View.VISIBLE);
                    } else {
                        recyclerViewPagos.setVisibility(View.VISIBLE);
                        tvEmptyPagos.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }

    private void openPagoForm(Pago pago) {
        // Aquí abrirías un dialog o fragment para crear/editar
        // Por ahora solo recargaremos la lista
        loadPagos();
    }

    private void onEditPago(Pago pago) {
        openPagoForm(pago);
    }

    private void onDeletePago(Pago pago) {
        new Thread(() -> {
            pagoUseCase.deletePago(pago);

            if (getActivity() != null) {
                getActivity().runOnUiThread(this::loadPagos);
            }
        }).start();
    }
}