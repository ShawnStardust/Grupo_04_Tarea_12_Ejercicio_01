package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.pagos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PagoFormDialogFragment extends DialogFragment {

    private TextInputEditText etIdReserva, etFecha, etTipo, etNumero, etMonto, etImpuesto;
    private TextView tvDialogTitle;
    private Button btnGuardar, btnCancelar;

    private Pago pagoActual;
    private OnPagoSavedListener listener;

    private final Calendar calendar = Calendar.getInstance();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public interface OnPagoSavedListener {
        void onPagoSaved(Pago pago);
    }

    public void setListener(OnPagoSavedListener listener) {
        this.listener = listener;
    }

    public static PagoFormDialogFragment newInstance(Pago pago) {
        PagoFormDialogFragment fragment = new PagoFormDialogFragment();
        if (pago != null) fragment.pagoActual = pago;
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_pago_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        setupDatePicker();

        if (pagoActual != null) {
            populateFields();
            tvDialogTitle.setText("Editar Pago");
        }

        btnCancelar.setOnClickListener(v -> dismiss());
        btnGuardar.setOnClickListener(v -> guardarPago());
    }

    private void initViews(View view) {
        tvDialogTitle = view.findViewById(R.id.tvDialogTitlePago);

        etIdReserva = view.findViewById(R.id.etIdReservaPago);
        etFecha     = view.findViewById(R.id.etFechaPago);
        etTipo      = view.findViewById(R.id.etTipoComprobantePago);
        etNumero    = view.findViewById(R.id.etNumeroComprobantePago);
        etMonto     = view.findViewById(R.id.etMontoPago);
        etImpuesto  = view.findViewById(R.id.etImpuestoPago);

        btnGuardar = view.findViewById(R.id.btnGuardarPago);
        btnCancelar = view.findViewById(R.id.btnCancelarPago);
    }

    private void setupDatePicker() {
        etFecha.setOnClickListener(v -> {
            new DatePickerDialog(getContext(), (picker, year, month, day) -> {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                etFecha.setText(dateFormat.format(calendar.getTime()));
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
    }

    private void populateFields() {
        etIdReserva.setText(String.valueOf(pagoActual.getIdReserva()));
        etTipo.setText(pagoActual.getTipoComprobante());
        etNumero.setText(pagoActual.getNumComprobante());
        etMonto.setText(String.valueOf(pagoActual.getMonto()));
        etImpuesto.setText(String.valueOf(pagoActual.getImpuesto()));

        if (pagoActual.getFecha() != null) {
            etFecha.setText(dateFormat.format(pagoActual.getFecha()));
            calendar.setTime(pagoActual.getFecha());
        }
    }

    private void guardarPago() {
        try {
            int idReserva = Integer.parseInt(etIdReserva.getText().toString());
            Date fecha = dateFormat.parse(etFecha.getText().toString());
            String tipo = etTipo.getText().toString();
            String numero = etNumero.getText().toString();
            double monto = Double.parseDouble(etMonto.getText().toString());
            double impuesto = Double.parseDouble(etImpuesto.getText().toString());

            if (pagoActual == null) pagoActual = new Pago();

            pagoActual.setIdReserva(idReserva);
            pagoActual.setFecha(fecha);
            pagoActual.setTipoComprobante(tipo);
            pagoActual.setNumComprobante(numero);
            pagoActual.setMonto(monto);
            pagoActual.setImpuesto(impuesto);

            if (listener != null) listener.onPagoSaved(pagoActual);

            dismiss();

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Revise los valores numéricos", Toast.LENGTH_SHORT).show();
        } catch (ParseException e) {
            Toast.makeText(getContext(), "Formato de fecha incorrecto", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Complete los campos requeridos", Toast.LENGTH_SHORT).show();
        }
    }
}
