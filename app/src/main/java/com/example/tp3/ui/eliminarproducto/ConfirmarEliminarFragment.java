package com.example.tp3.ui.eliminarproducto;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp3.MainActivity;
import com.example.tp3.R;
import com.example.tp3.databinding.FragmentConfirmarEliminarBinding;
import com.example.tp3.models.Producto;

public class ConfirmarEliminarFragment extends Fragment {
    private FragmentConfirmarEliminarBinding binding;
    private ConfirmarEliminarViewModel mViewModel;

    public static ConfirmarEliminarFragment newInstance() {
        return new ConfirmarEliminarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentConfirmarEliminarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel = new ViewModelProvider(this).get(ConfirmarEliminarViewModel.class);

        Producto producto = getArguments().getSerializable("producto") != null ?
                (Producto) getArguments().getSerializable("producto") : new Producto();

        binding.etId.setText(producto.getCodigo());
        binding.etDescripcion.setText(producto.getDescripcion());
        binding.etPrecio.setText(String.valueOf(producto.getPrecio()));

        binding.btnEliminar.setOnClickListener(v -> {

            mViewModel.eliminarProducto(producto);
            binding.tvMensaje.setText("Eliminado");
            binding.tvMensaje.postDelayed(()->{
                Navigation.findNavController(binding.getRoot()).popBackStack();
            },1500);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}