package com.example.grupo_04_tarea_12_ejercicio_01;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.grupo_04_tarea_12_ejercicio_01.ui.booking.BookingFragment;
import com.example.grupo_04_tarea_12_ejercicio_01.ui.clientes.ClientesFragment;
import com.example.grupo_04_tarea_12_ejercicio_01.ui.flota.FlotaFragment;
import com.example.grupo_04_tarea_12_ejercicio_01.ui.vuelos.VuelosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
            return insets;
        });

        // Inicializar vistas
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();

        // Configurar listener para el bottom navigation
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            Fragment fragment = null;

            if (itemId == R.id.nav_booking) {
                fragment = new BookingFragment();
            } else if (itemId == R.id.nav_vuelos) {
                fragment = new VuelosFragment();
            } else if (itemId == R.id.nav_flota) {
                fragment = new FlotaFragment();
            } else if (itemId == R.id.nav_clientes) {
                fragment = new ClientesFragment();
            }

            if (fragment != null) {
                loadFragment(fragment);
                return true;
            }

            return false;
        });

        // Cargar el fragment inicial (Booking)
        if (savedInstanceState == null) {
            loadFragment(new BookingFragment());
            bottomNavigationView.setSelectedItemId(R.id.nav_booking);
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}