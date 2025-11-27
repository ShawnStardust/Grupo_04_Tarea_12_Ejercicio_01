package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.reservas;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ReservaDeleteConfirmationDialogFragment extends DialogFragment {

    private Reserva reserva;
    private OnDeleteConfirmedListener listener;

    public interface OnDeleteConfirmedListener {
        void onDeleteConfirmed(Reserva reserva);
    }

    public static ReservaDeleteConfirmationDialogFragment newInstance(Reserva reserva) {
        ReservaDeleteConfirmationDialogFragment fragment = new ReservaDeleteConfirmationDialogFragment();
        fragment.reserva = reserva;
        return fragment;
    }

    public void setListener(OnDeleteConfirmedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_reserva_delete_confirmation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvId = view.findViewById(R.id.tvDeleteReservaId);
        TextView tvDetails = view.findViewById(R.id.tvDeleteReservaDetails);
        Button btnConfirmar = view.findViewById(R.id.btnConfirmarDelete);
        Button btnCancelar = view.findViewById(R.id.btnCancelarDelete);

        if (reserva != null) {
            tvId.setText("Reserva #" + reserva.getIdReserva());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String fechaStr = reserva.getFecha() != null ? sdf.format(reserva.getFecha()) : "N/A";

            String detalle = String.format("Pasajero: %d | Vuelo: %d\nFecha: %s | Costo: $%.2f",
                    reserva.getIdPasajero(), reserva.getIdVuelo(), fechaStr, reserva.getCosto());
            tvDetails.setText(detalle);
        }

        btnCancelar.setOnClickListener(v -> dismiss());

        btnConfirmar.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteConfirmed(reserva);
            }
            dismiss();
        });
    }
}