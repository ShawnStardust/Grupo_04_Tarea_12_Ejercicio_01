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

public class ReservasAdapter extends RecyclerView.Adapter<ReservasAdapter.ReservaViewHolder> {

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

    @NonNull
    @Override
    public ReservaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reserva, parent, false);
        return new ReservaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservaViewHolder holder, int position) {
        Reserva reserva = reservasList.get(position);

        holder.tvReservaId.setText("Reserva #" + reserva.getIdReserva());
        holder.tvReservaFecha.setText(dateFormat.format(reserva.getFecha()));
        holder.tvReservaInfo.setText("Pasajero ID: " + reserva.getIdPasajero() +
                " | Vuelo ID: " + reserva.getIdVuelo());
        holder.tvReservaCosto.setText(String.format(Locale.getDefault(),
                "Costo: $%.2f", reserva.getCosto()));
        holder.tvReservaObservacion.setText(reserva.getObservacion() != null ?
                reserva.getObservacion() : "Sin observaciones");

        holder.btnEditReserva.setOnClickListener(v -> {
            if (editListener != null) {
                editListener.onClick(reserva);
            }
        });

        holder.btnDeleteReserva.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onClick(reserva);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reservasList.size();
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
}