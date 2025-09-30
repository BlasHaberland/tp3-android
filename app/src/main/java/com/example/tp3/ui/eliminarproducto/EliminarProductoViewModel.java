package com.example.tp3.ui.eliminarproducto;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3.MainActivity;
import com.example.tp3.models.Producto;

import java.lang.invoke.MutableCallSite;
import java.util.List;

public class EliminarProductoViewModel extends AndroidViewModel {
    private List<Producto> listaProductos = MainActivity.listaProductos;
    private MutableLiveData<Producto> mProducto;
    private MutableLiveData<String> mMensaje;


    public EliminarProductoViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Producto> getProducto() {
        if (mProducto == null) {
            mProducto = new MutableLiveData<>();
        }
        return mProducto;
    }

    public LiveData<String> getMensaje() {
        if (mMensaje == null) {
            mMensaje = new MutableLiveData<>();
        }
        return mMensaje;
    }

    //Buscar
    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                Log.d("encontrado","producto encontrado " + p.getDescripcion());
                mProducto.setValue(p);
            }
        }

        return null;
    }

    public void limpiarPorducto(){
        mProducto.setValue(null);
    }


}