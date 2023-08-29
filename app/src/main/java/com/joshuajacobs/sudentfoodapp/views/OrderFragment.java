package com.joshuajacobs.sudentfoodapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.joshuajacobs.sudentfoodapp.CardFormActivity;
import com.joshuajacobs.sudentfoodapp.R;
import com.joshuajacobs.sudentfoodapp.databinding.FragmentOrderBinding;
import com.joshuajacobs.sudentfoodapp.viewmodels.ShopViewModel;


public class OrderFragment extends Fragment {

    NavController navController;
    FragmentOrderBinding fragmentOrderBinding;
    ShopViewModel shopViewModel;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_order, container, false);
        fragmentOrderBinding = FragmentOrderBinding.inflate(inflater, container, false);
        return fragmentOrderBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);

        fragmentOrderBinding.payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopViewModel.resetCart();
                navController.navigate(R.id.action_orderFragment_to_shopFragment);
            }
        });

        TextView totalAmountTxt = fragmentOrderBinding.textView29;

        // In the second fragment
        Bundle bundle = getArguments();
        if (bundle != null) {
            String receivedString = bundle.getString("stringValue", "");
            totalAmountTxt.setText(receivedString);

        }

        //Add New Card Button:
        fragmentOrderBinding.addNewCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // In your fragment
                Intent intent = new Intent(getActivity(), CardFormActivity.class);
                startActivity(intent);
            }
        });

    }

}

