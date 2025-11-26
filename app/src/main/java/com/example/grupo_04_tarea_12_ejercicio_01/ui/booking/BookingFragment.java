package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.pagos.PagosListFragment;
import com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.reservas.ReservasListFragment;

public class BookingFragment extends Fragment {

    private Button btnVerReservas;
    private Button btnVerPagos;

    public BookingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking, container, false);

        // Inicializar botones
        btnVerReservas = view.findViewById(R.id.btnVerReservas);
        btnVerPagos = view.findViewById(R.id.btnVerPagos);

        // Configurar listeners
        btnVerReservas.setOnClickListener(v -> navigateToReservas());
        btnVerPagos.setOnClickListener(v -> navigateToPagos());

        return view;
    }

    private void navigateToReservas() {
        Fragment reservasListFragment = new ReservasListFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, reservasListFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void navigateToPagos() {
        Fragment pagosListFragment = new PagosListFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, pagosListFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}