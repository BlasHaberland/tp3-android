package com.example.tp3.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp3.MainActivity;
import com.example.tp3.models.Producto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private MutableLiveData<List<Producto>> mListaProducto;


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Producto>> getListaProducto() {
        if (mListaProducto == null) {
            mListaProducto = new MutableLiveData<>();
        }
        return mListaProducto;
    }

    public void cargarProductos() {
        List<Producto> lista = MainActivity.listaProductos;

        List<Producto> listaCopia = new ArrayList<>(lista);
        Collections.sort(listaCopia);
        mListaProducto.setValue(listaCopia);
    }


}