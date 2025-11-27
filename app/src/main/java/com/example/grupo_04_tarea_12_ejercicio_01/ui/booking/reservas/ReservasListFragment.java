package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.reservas;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton; // Importar ImageButton
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.example.grupo_04_tarea_12_ejercicio_01.MainActivity; // Importar MainActivity
import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ReservasListFragment extends Fragment {

    private ReservasViewModel viewModel;
    private RecyclerView recyclerViewReservas;
    private TextView tvEmptyReservas;
    private FloatingActionButton fabAddReserva;
    private ImageButton btnBack;
    private ReservasAdapter adapter;
    private List<Reserva> reservasList;

    public ReservasListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservas_list, container, false);

        viewModel = new ViewModelProvider(this).get(ReservasViewModel.class);
        recyclerViewReservas = view.findViewById(R.id.recyclerViewReservas);
        tvEmptyReservas = view.findViewById(R.id.tvEmptyReservas);
        fabAddReserva = view.findViewById(R.id.fabAddReserva);
        btnBack = view.findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });

        recyclerViewReservas.setLayoutManager(new LinearLayoutManager(getContext()));
        reservasList = new ArrayList<>();
        adapter = new ReservasAdapter(reservasList, this::onEditReserva, this::onDeleteReserva);
        recyclerViewReservas.setAdapter(adapter);

        fabAddReserva.setOnClickListener(v -> openReservaForm(null));

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
        viewModel.reservasLiveData.observe(getViewLifecycleOwner(), reservas -> {
            if (reservas != null) {
                reservasList.clear();
                reservasList.addAll(reservas);
                adapter.notifyDataSetChanged();

                if (reservasList.isEmpty()) {
                    recyclerViewReservas.setVisibility(View.GONE);
                    tvEmptyReservas.setVisibility(View.VISIBLE);
                } else {
                    recyclerViewReservas.setVisibility(View.VISIBLE);
                    tvEmptyReservas.setVisibility(View.GONE);
                }
            }
        });

        viewModel.errorLiveData.observe(getViewLifecycleOwner(), error -> {
            if (error != null && !error.isEmpty()) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openReservaForm(Reserva reserva) {
        ReservaFormDialogFragment dialog = ReservaFormDialogFragment.newInstance(reserva);
        dialog.setListener(reservaGuardada -> {
            viewModel.saveReserva(reservaGuardada);
        });
        dialog.show(getChildFragmentManager(), "ReservaFormDialog");
    }

    private void onEditReserva(Reserva reserva) {
        openReservaForm(reserva);
    }

    private void onDeleteReserva(Reserva reserva) {
        ReservaDeleteConfirmationDialogFragment dialog = ReservaDeleteConfirmationDialogFragment.newInstance(reserva);
        dialog.setListener(reservaAEliminar -> {
            viewModel.deleteReserva(reservaAEliminar);
        });
        dialog.show(getChildFragmentManager(), "DeleteConfirmDialog");
    }
}