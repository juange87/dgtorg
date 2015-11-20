package com.juange.digitalorigin.app;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.juange.digitalorigin.app.model.Cap;
import com.juange.digitalorigin.app.model.Mug;
import com.juange.digitalorigin.app.model.Order;
import com.juange.digitalorigin.app.model.Product;
import com.juange.digitalorigin.app.model.Sticker;
import com.juange.digitalorigin.app.model.Tshirt;
import com.juange.digitalorigin.app.view.ProductsAdapter;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    @Bind(R.id.txt_result)
    TextView txtResult;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    ProductsAdapter adapter;

    Order order;

    public MainActivityFragment() {}

    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        adapter = new ProductsAdapter(new ArrayList<Product>());
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        order = new Order();
    }

    private void showAlertDialog() {
        AlertDialog.Builder productSelectionDialog = new AlertDialog.Builder(getActivity());
        productSelectionDialog.setTitle("Select One Product:");

        final ArrayAdapter<Product> arrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add(new Cap());
        arrayAdapter.add(new Tshirt());
        arrayAdapter.add(new Mug());
        arrayAdapter.add(new Sticker());

        productSelectionDialog.setNegativeButton(R.string.dialog_cancel,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        productSelectionDialog.setAdapter(
                arrayAdapter,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Product item = arrayAdapter.getItem(which);
                        adapter.addProduct(item);
                        adapter.notifyDataSetChanged();

                        order.addProduct(item);
                        final String value = "Reduced: " + order.getReducedBill() + "\nTotal: " + order.getBill();
                        txtResult.setText(String.valueOf(value));

                        Snackbar.make(getView(), getString(R.string.dialog_result_adding) + item.toString(),
                                Snackbar.LENGTH_LONG).show();
                    }
                });

        productSelectionDialog.show();
    }
}
