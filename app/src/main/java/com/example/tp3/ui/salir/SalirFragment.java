package com.example.tp3.ui.salir;

import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tp3.R;
import com.example.tp3.databinding.FragmentSalirBinding;

public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;
    public static SalirFragment newInstance() {
        return new SalirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //ACA VA EL CODIGO BLAS DEL FUTURO!

        //Cerrar
        binding.btnSalir.setOnClickListener(v -> {

            new AlertDialog.Builder(requireContext())
                    .setTitle("Confirmar Salida")
                    .setMessage("¿Seguro de que querés salir de la aplicación?")
                    .setPositiveButton("Sí", (dialog, which) -> {
                        requireActivity().finishAffinity();
                        System.exit(0);
                    })
                    .setNegativeButton("No",(dialog,witch) ->{
                        requireActivity().onBackPressed();
                    })
                    .setCancelable(false)
                    .show();
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}