package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.pagos;

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
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class PagoDeleteConfirmationDialogFragment extends DialogFragment {

    private Pago pago;
    private OnDeleteConfirmedListener listener;

    public interface OnDeleteConfirmedListener {
        void onDeleteConfirmed(Pago pago);
    }

    public static PagoDeleteConfirmationDialogFragment newInstance(Pago pago) {
        PagoDeleteConfirmationDialogFragment fragment = new PagoDeleteConfirmationDialogFragment();
        fragment.pago = pago;
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
        return inflater.inflate(R.layout.dialog_pago_delete_confirmation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvId = view.findViewById(R.id.tvDeletePagoId);
        TextView tvDetails = view.findViewById(R.id.tvDeletePagoDetails);
        Button btnConfirmar = view.findViewById(R.id.btnConfirmarDelete);
        Button btnCancelar = view.findViewById(R.id.btnCancelarDelete);

        if (pago != null) {
            tvId.setText("Pago #" + pago.getIdPago());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String fechaStr = pago.getFecha() != null ? sdf.format(pago.getFecha()) : "N/A";

            String detalle = String.format(
                    "Comprobante: %s - %s\nFecha: %s | Monto: $%.2f",
                    pago.getTipoComprobante(),
                    pago.getNumComprobante(),
                    fechaStr,
                    pago.getMonto()
            );


            tvDetails.setText(detalle);
        }

        btnCancelar.setOnClickListener(v -> dismiss());

        btnConfirmar.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteConfirmed(pago);
            }
            dismiss();
        });
    }
}
