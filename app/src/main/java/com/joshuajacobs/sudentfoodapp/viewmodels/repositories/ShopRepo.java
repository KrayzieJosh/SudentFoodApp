package com.joshuajacobs.sudentfoodapp.viewmodels.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.joshuajacobs.sudentfoodapp.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "Steak Gatsby", 110, true, "" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Beef Burger", 50, true, "" ));
        productList.add(new Product(UUID.randomUUID().toString(), "Coke 500ml", 15, true, "" ));
        mutableProductList.setValue(productList);
    }
}

