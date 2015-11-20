package com.juange.digitalorigin.app.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.juange.digitalorigin.app.R;
import com.juange.digitalorigin.app.model.Product;
import java.util.ArrayList;

/**
 * Created by juange on 20/11/15.
 */
public class ProductsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Product> products = new ArrayList<>();

    public ProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_product, parent, false);
        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProductsViewHolder viewHolder = (ProductsViewHolder) holder;
        final Product product = products.get(position);
        viewHolder.txtPrice.setText(String.valueOf(product.getPrice()));
        viewHolder.txtProductName.setText(product.toString());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
