package com.example.tp3.ui.eliminarproducto;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.tp3.MainActivity;
import com.example.tp3.models.Producto;

public class ConfirmarEliminarViewModel extends AndroidViewModel {


    public ConfirmarEliminarViewModel(@NonNull Application application) {
        super(application);
    }

    public void eliminarProducto(Producto producto) {
        MainActivity.eliminarProducto(producto);
    }
}