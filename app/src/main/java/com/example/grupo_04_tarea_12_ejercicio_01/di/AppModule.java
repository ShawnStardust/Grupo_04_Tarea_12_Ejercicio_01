package com.example.grupo_04_tarea_12_ejercicio_01.di;

import android.content.Context;

import com.example.grupo_04_tarea_12_ejercicio_01.data.local.dao.*;
import com.example.grupo_04_tarea_12_ejercicio_01.data.local.database.AppDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public static AppDataBase provideAppDatabase(@ApplicationContext Context context) {
        return AppDataBase.getInstance(context);
    }

    @Provides
    @Singleton
    public static PasajeroDao providePasajeroDao(AppDataBase database) {
        return database.pasajeroDao();
    }

    @Provides
    @Singleton
    public static ReservaDao provideReservaDao(AppDataBase database) {
        return database.reservaDao();
    }

    @Provides
    @Singleton
    public static PagoDao providePagoDao(AppDataBase database) {
        return database.pagoDao();
    }

    @Provides
    @Singleton
    public static VueloDao provideVueloDao(AppDataBase database) {
        return database.vueloDao();
    }

    @Provides
    @Singleton
    public static AsientoDao provideAsientoDao(AppDataBase database) {
        return database.asientoDao();
    }

    @Provides
    @Singleton
    public static TarifaDao provideTarifaDao(AppDataBase database) {
        return database.tarifaDao();
    }

    @Provides
    @Singleton
    public static AvionDao provideAvionDao(AppDataBase database) {
        return database.avionDao();
    }

    @Provides
    @Singleton
    public static AeropuertoDao provideAeropuertoDao(AppDataBase database) {
        return database.aeropuertoDao();
    }

    @Provides
    @Singleton
    public static PaisDao providePaisDao(AppDataBase database) {
        return database.paisDao();
    }

    @Provides
    @Singleton
    public static AerolineaDao provideAerolineaDao(AppDataBase database) {
        return database.aerolineaDao();
    }
}