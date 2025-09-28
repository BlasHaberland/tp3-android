package com.example.tp3.ui.cargarproducto;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp3.MainActivity;
import com.example.tp3.models.Producto;

public class AgregarProductoViewModel extends AndroidViewModel {

    private MutableLiveData<String> mMensajeError;
    private MutableLiveData<String> mMensajeExito;

    public AgregarProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMensajeError() {
        if (mMensajeError == null) {
            mMensajeError = new MutableLiveData<>();
        }
        return mMensajeError;
    }

    public LiveData<String> getMensajeExito() {
        if (mMensajeExito == null) {
            mMensajeExito = new MutableLiveData<>();
        }
        return mMensajeExito;
    }

    public void agregarProducto(String codigo, String descripcion, String precio) {
        boolean datosValidos = validarDatos(codigo, descripcion, precio);

            if (datosValidos) {
                double precioValido;
                try {
                    precioValido = Double.parseDouble(precio);
                } catch (NumberFormatException e) {
                    mMensajeError.setValue("El precio debe ser un numero valido");
                    return;
                }
                MainActivity.agregarProducto(new Producto(codigo,descripcion, precioValido));
                mMensajeExito.setValue("Producto agregado exitosamente.");
            }

    }


    private boolean validarDatos(String id, String descripcion, String precio) {

        // todos los campos tienen que estar presentes
        if (id.isEmpty() || descripcion.isEmpty() || precio.isEmpty()) {
            mMensajeError.setValue("Por favor, complete todos los campos correctamente.");
            return false;
        }

        // valido que el id no exista
        if (MainActivity.listaProductos.contains(new Producto(id, "", 0))) {
            mMensajeError.setValue("Ya existe un producto con ese ID");
            return false;
        }

        return true;
    }

}
