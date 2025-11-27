package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.reservas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Reserva;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ReservasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    private List<Reserva> reservasList;
    private OnReservaClickListener editListener;
    private OnReservaClickListener deleteListener;
    private SimpleDateFormat dateFormat;

    public interface OnReservaClickListener {
        void onClick(Reserva reserva);
    }

    public ReservasAdapter(List<Reserva> reservasList,
                           OnReservaClickListener editListener,
                           OnReservaClickListener deleteListener) {
        this.reservasList = reservasList;
        this.editListener = editListener;
        this.deleteListener = deleteListener;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    }

    @Override
    public int getItemViewType(int position) {
        if (position == reservasList.size()) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_FOOTER) {
            View view = new View(parent.getContext());
            view.setLayoutParams(new RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    600
            ));
            return new FooterViewHolder(view);
        }

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reserva, parent, false);
        return new ReservaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_FOOTER) {
            return;
        }

        Reserva reserva = reservasList.get(position);
        ReservaViewHolder vh = (ReservaViewHolder) holder;

        vh.tvReservaId.setText("Reserva #" + reserva.getIdReserva());
        vh.tvReservaFecha.setText(dateFormat.format(reserva.getFecha()));
        vh.tvReservaInfo.setText("Pasajero ID: " + reserva.getIdPasajero() +
                " | Vuelo ID: " + reserva.getIdVuelo());
        vh.tvReservaCosto.setText(String.format(Locale.getDefault(),
                "Costo: $%.2f", reserva.getCosto()));
        vh.tvReservaObservacion.setText(reserva.getObservacion() != null ?
                reserva.getObservacion() : "Sin observaciones");

        vh.btnEditReserva.setOnClickListener(v -> {
            if (editListener != null) editListener.onClick(reserva);
        });

        vh.btnDeleteReserva.setOnClickListener(v -> {
            if (deleteListener != null) deleteListener.onClick(reserva);
        });
    }

    @Override
    public int getItemCount() {
        return reservasList.size() + 1;
    }

    static class ReservaViewHolder extends RecyclerView.ViewHolder {
        TextView tvReservaId;
        TextView tvReservaFecha;
        TextView tvReservaInfo;
        TextView tvReservaCosto;
        TextView tvReservaObservacion;
        Button btnEditReserva;
        Button btnDeleteReserva;

        public ReservaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReservaId = itemView.findViewById(R.id.tvReservaId);
            tvReservaFecha = itemView.findViewById(R.id.tvReservaFecha);
            tvReservaInfo = itemView.findViewById(R.id.tvReservaInfo);
            tvReservaCosto = itemView.findViewById(R.id.tvReservaCosto);
            tvReservaObservacion = itemView.findViewById(R.id.tvReservaObservacion);
            btnEditReserva = itemView.findViewById(R.id.btnEditReserva);
            btnDeleteReserva = itemView.findViewById(R.id.btnDeleteReserva);
        }
    }

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}