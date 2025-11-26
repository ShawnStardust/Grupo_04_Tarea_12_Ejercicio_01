package com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.pagos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupo_04_tarea_12_ejercicio_01.R;
import com.example.grupo_04_tarea_12_ejercicio_01.domain.model.Pago;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class PagosAdapter extends RecyclerView.Adapter<PagosAdapter.PagoViewHolder> {

    private List<Pago> pagosList;
    private OnPagoClickListener editListener;
    private OnPagoClickListener deleteListener;
    private SimpleDateFormat dateFormat;

    public interface OnPagoClickListener {
        void onClick(Pago pago);
    }

    public PagosAdapter(List<Pago> pagosList,
                        OnPagoClickListener editListener,
                        OnPagoClickListener deleteListener) {
        this.pagosList = pagosList;
        this.editListener = editListener;
        this.deleteListener = deleteListener;
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    }

    @NonNull
    @Override
    public PagoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pago, parent, false);
        return new PagoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagoViewHolder holder, int position) {
        Pago pago = pagosList.get(position);

        holder.tvPagoId.setText("Pago #" + pago.getIdPago());
        holder.tvPagoFecha.setText(dateFormat.format(pago.getFecha()));
        holder.tvPagoComprobante.setText(pago.getTipoComprobante() + " - " +
                pago.getNumComprobante());
        holder.tvPagoReserva.setText("Reserva ID: " + pago.getIdReserva());
        holder.tvPagoMonto.setText(String.format(Locale.getDefault(),
                "Monto: $%.2f", pago.getMonto()));
        holder.tvPagoImpuesto.setText(String.format(Locale.getDefault(),
                "Impuesto: $%.2f", pago.getImpuesto()));

        holder.btnEditPago.setOnClickListener(v -> {
            if (editListener != null) {
                editListener.onClick(pago);
            }
        });

        holder.btnDeletePago.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onClick(pago);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pagosList.size();
    }

    static class PagoViewHolder extends RecyclerView.ViewHolder {
        TextView tvPagoId;
        TextView tvPagoFecha;
        TextView tvPagoComprobante;
        TextView tvPagoReserva;
        TextView tvPagoMonto;
        TextView tvPagoImpuesto;
        Button btnEditPago;
        Button btnDeletePago;

        public PagoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPagoId = itemView.findViewById(R.id.tvPagoId);
            tvPagoFecha = itemView.findViewById(R.id.tvPagoFecha);
            tvPagoComprobante = itemView.findViewById(R.id.tvPagoComprobante);
            tvPagoReserva = itemView.findViewById(R.id.tvPagoReserva);
            tvPagoMonto = itemView.findViewById(R.id.tvPagoMonto);
            tvPagoImpuesto = itemView.findViewById(R.id.tvPagoImpuesto);
            btnEditPago = itemView.findViewById(R.id.btnEditPago);
            btnDeletePago = itemView.findViewById(R.id.btnDeletePago);
        }
    }
}