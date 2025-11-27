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

public class PagosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

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

    @Override
    public int getItemViewType(int position) {
        if (position == pagosList.size()) {
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
                .inflate(R.layout.item_pago, parent, false);
        return new PagoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_FOOTER) {
            return;
        }

        Pago pago = pagosList.get(position);
        PagoViewHolder vh = (PagoViewHolder) holder;

        vh.tvPagoId.setText("Pago #" + pago.getIdPago());
        vh.tvPagoFecha.setText(dateFormat.format(pago.getFecha()));

        vh.tvPagoComprobante.setText(
                pago.getTipoComprobante() + " - " + pago.getNumComprobante()
        );

        vh.tvPagoReserva.setText("Reserva ID: " + pago.getIdReserva());

        vh.tvPagoMonto.setText(String.format(
                Locale.getDefault(),
                "Monto: $%.2f",
                pago.getMonto()
        ));

        vh.tvPagoImpuesto.setText(String.format(
                Locale.getDefault(),
                "Impuesto: $%.2f",
                pago.getImpuesto()
        ));

        vh.btnEditPago.setOnClickListener(v -> {
            if (editListener != null) editListener.onClick(pago);
        });

        vh.btnDeletePago.setOnClickListener(v -> {
            if (deleteListener != null) deleteListener.onClick(pago);
        });
    }

    @Override
    public int getItemCount() {
        return pagosList.size() + 1;
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

    static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
