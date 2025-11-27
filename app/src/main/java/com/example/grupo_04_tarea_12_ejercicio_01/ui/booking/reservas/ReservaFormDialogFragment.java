package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.reservas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ReservaFormDialogFragment extends DialogFragment {

    private TextInputEditText etIdPasajero, etIdVuelo, etFecha, etCosto, etObservacion;
    private TextView tvDialogTitle;
    private Button btnGuardar, btnCancelar;
    private Reserva reservaActual;
    private OnReservaSavedListener listener;
    private final Calendar calendar = Calendar.getInstance();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    public interface OnReservaSavedListener {
        void onReservaSaved(Reserva reserva);
    }

    public void setListener(OnReservaSavedListener listener) {
        this.listener = listener;
    }

    public static ReservaFormDialogFragment newInstance(Reserva reserva) {
        ReservaFormDialogFragment fragment = new ReservaFormDialogFragment();
        if (reserva != null) {
            fragment.reservaActual = reserva;
        }
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_reserva_form, container, false); // Asegúrate que el nombre del XML coincida
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        setupDatePicker();

        if (reservaActual != null) {
            populateFields();
            tvDialogTitle.setText("Editar Reserva");
        }

        btnCancelar.setOnClickListener(v -> dismiss());
        btnGuardar.setOnClickListener(v -> guardarReserva());
    }

    private void initViews(View view) {
        tvDialogTitle = view.findViewById(R.id.tvDialogTitle);
        etIdPasajero = view.findViewById(R.id.etIdPasajero);
        etIdVuelo = view.findViewById(R.id.etIdVuelo);
        etFecha = view.findViewById(R.id.etFecha);
        etCosto = view.findViewById(R.id.etCosto);
        etObservacion = view.findViewById(R.id.etObservacion);
        btnGuardar = view.findViewById(R.id.btnGuardar);
        btnCancelar = view.findViewById(R.id.btnCancelar);
    }

    private void setupDatePicker() {
        etFecha.setOnClickListener(v -> {
            new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                etFecha.setText(dateFormat.format(calendar.getTime()));
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });
    }

    private void populateFields() {
        etIdPasajero.setText(String.valueOf(reservaActual.getIdPasajero()));
        etIdVuelo.setText(String.valueOf(reservaActual.getIdVuelo()));
        etCosto.setText(String.valueOf(reservaActual.getCosto()));
        etObservacion.setText(reservaActual.getObservacion());
        if (reservaActual.getFecha() != null) {
            etFecha.setText(dateFormat.format(reservaActual.getFecha()));
            calendar.setTime(reservaActual.getFecha());
        }
    }

    private void guardarReserva() {
        try {
            int idPasajero = Integer.parseInt(etIdPasajero.getText().toString());
            int idVuelo = Integer.parseInt(etIdVuelo.getText().toString());
            double costo = Double.parseDouble(etCosto.getText().toString());
            Date fecha = dateFormat.parse(etFecha.getText().toString());
            String observacion = etObservacion.getText().toString();

            if (reservaActual == null) {
                reservaActual = new Reserva();
            }

            reservaActual.setIdPasajero(idPasajero);
            reservaActual.setIdVuelo(idVuelo);
            reservaActual.setCosto(costo);
            reservaActual.setFecha(fecha);
            reservaActual.setObservacion(observacion);

            if (listener != null) {
                listener.onReservaSaved(reservaActual);
            }
            dismiss();

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Por favor revise los números ingresados", Toast.LENGTH_SHORT).show();
        } catch (ParseException e) {
            Toast.makeText(getContext(), "Formato de fecha inválido", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getContext(), "Complete todos los campos requeridos", Toast.LENGTH_SHORT).show();
        }
    }
}