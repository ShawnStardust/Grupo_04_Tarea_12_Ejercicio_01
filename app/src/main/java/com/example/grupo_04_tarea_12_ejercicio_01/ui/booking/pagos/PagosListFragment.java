package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.pagos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupo_04_tarea_12_ejercicio_01.MainActivity;
import com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.reservas.ReservaFormDialogFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PagosListFragment extends Fragment {

    private PagosViewModel viewModel;
    private RecyclerView recyclerViewPagos;
    private TextView tvEmptyPagos;
    private FloatingActionButton fabAddPago;
    private ImageButton btnBack;
    private PagosAdapter adapter;
    private List<Pago> pagosList;

    public PagosListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagos_list, container, false);

        viewModel = new ViewModelProvider(this).get(PagosViewModel.class);
        recyclerViewPagos = view.findViewById(R.id.recyclerViewPagos);
        tvEmptyPagos = view.findViewById(R.id.tvEmptyPagos);
        fabAddPago = view.findViewById(R.id.fabAddPago);
        btnBack = view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        recyclerViewPagos.setLayoutManager(new LinearLayoutManager(getContext()));
        pagosList = new ArrayList<>();
        adapter = new PagosAdapter(pagosList, this::onEditPago, this::onDeletePago);
        recyclerViewPagos.setAdapter(adapter);

        fabAddPago.setOnClickListener(v -> openPagoForm(null));

        observeViewModel();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setBottomNavVisibility(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).setBottomNavVisibility(true);
        }
    }

    private void observeViewModel() {
        viewModel.pagosLiveData.observe(getViewLifecycleOwner(), pagos -> {
            if (pagos != null) {
                pagosList.clear();
                pagosList.addAll(pagos);
                adapter.notifyDataSetChanged();

                if (pagosList.isEmpty()) {
                    recyclerViewPagos.setVisibility(View.GONE);
                    tvEmptyPagos.setVisibility(View.VISIBLE);
                } else {
                    recyclerViewPagos.setVisibility(View.VISIBLE);
                    tvEmptyPagos.setVisibility(View.GONE);
                }
            }
        });

        viewModel.errorLiveData.observe(getViewLifecycleOwner(), error -> {
            if (error != null && !error.isEmpty()) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openPagoForm(Pago pago) {
        PagoFormDialogFragment dialog = PagoFormDialogFragment.newInstance(pago);
        dialog.setListener(pagoGuardado -> {
            viewModel.savePago(pagoGuardado);
        });
        dialog.show(getChildFragmentManager(), "PagoFormDialog");
    }

    private void onEditPago(Pago pago) {
        openPagoForm(pago);
    }

    private void onDeletePago(Pago pago) {
        PagoDeleteConfirmationDialogFragment dialog =
                PagoDeleteConfirmationDialogFragment.newInstance(pago);

        dialog.setListener(pagoAEliminar -> {
            viewModel.deletePago(pagoAEliminar);
        });

        dialog.show(getChildFragmentManager(), "DeleteConfirmDialog");
    }
}
