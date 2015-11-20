package com.juange.digitalorigin.app.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.juange.digitalorigin.app.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by juange on 20/11/15.
 */
public class ProductsViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.txt_product_name)
    public TextView txtProductName;

    @Bind(R.id.txt_price)
    public TextView txtPrice;

    public ProductsViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

}
