package com.example.tp3.ui.eliminarproducto;

import androidx.annotation.NavigationRes;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp3.R;
import com.example.tp3.databinding.FragmentEliminarProductoBinding;

public class EliminarProductoFragment extends Fragment {
    private FragmentEliminarProductoBinding binding;
    private EliminarProductoViewModel viewModel;


    public static EliminarProductoFragment newInstance() {
        return new EliminarProductoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentEliminarProductoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(EliminarProductoViewModel.class);

        //CODIGO
        binding.btnBuscar.setOnClickListener(v -> {
            String codigo = binding.etCodigo.getText().toString().trim();
            viewModel.buscarProductoPorCodigo(codigo);
        });

        viewModel.getMensaje().observe(getViewLifecycleOwner(), mensaje -> {
                binding.tvMensaje.setText(mensaje);
                binding.tvMensaje.setTextColor(getResources().getColor(android.R.color.holo_red_dark));

                binding.etCodigo.setText("");
        });

        viewModel.getProducto().observe(getViewLifecycleOwner(), producto -> {
                if (producto != null) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("producto", producto);
                    Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.confirmarEliminarFragment, bundle);
                    viewModel.limpiarPorducto();
                }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding  = null; }
    }