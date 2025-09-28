package com.example.tp3.ui.cargarproducto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp3.R;
import com.example.tp3.databinding.FragmentAgregarProductoBinding;

public class AgregarProductoFragment extends Fragment {
    private FragmentAgregarProductoBinding binding;
    private AgregarProductoViewModel viewModel;

    public static AgregarProductoFragment newInstance() {
        return new AgregarProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAgregarProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(AgregarProductoViewModel.class);
        //ACA VA EL CODIGO BLAS DEL FUTURO!

        binding.btnAgregar.setOnClickListener(v -> {
            String id = binding.etId.getText().toString().trim();
            String descripcion = binding.etDescripcion.getText().toString();
            String precio = binding.etPrecio.getText().toString().trim();

            viewModel.agregarProducto(id,descripcion,precio);
        });

        viewModel.getMensajeExito().observe(getViewLifecycleOwner(), mensaje -> {
                binding.tvMensaje.setText(mensaje);
                binding.tvMensaje.setTextColor( ContextCompat.getColor(requireContext(), android.R.color.holo_green_light));

                // Limpio loscampos
            binding.etId.setText("");
            binding.etDescripcion.setText("");
            binding.etPrecio.setText("");
        });

        viewModel.getMensajeError().observe(getViewLifecycleOwner(), mensaje -> {
            binding.tvMensaje.setText(mensaje);
            binding.tvMensaje.setTextColor(
                    ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark)
            );
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}