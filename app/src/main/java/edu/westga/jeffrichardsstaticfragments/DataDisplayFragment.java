package edu.westga.jeffrichardsstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {
    private TextView productText;
    private double num1;
    private double num2;
    private double product;
    private DataAddListener listener;

    public interface DataAddListener {
        void onDataAdd();
    }

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    /**
     * Action taken when view is created. Initializes default numbers to 0.0
     * @param inflater Inflater to create the view
     * @param container Container that is going to contain this view
     * @param savedInstanceState Saved state of the view
     * @return The inflated view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);
        this.productText = (TextView) theView.findViewById(R.id.lblProduct);
        this.num1 = 0.0;
        this.num2 = 0.0;
        this.product = 0.0;
        Button addButton = (Button) theView.findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addButtonClicked(v);
            }
        });
        return theView;
    }

    /**
     * Set first number
     * @param num1 First number
     */
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    /**
     * Set the second number
     * @param num2 Second number
     */
    public void setNum2(double num2) {
        this.num2 = num2;
    }

    /**
     * Multiply the two numbers stored
     */
    public void multiply() {
        this.product = this.num1 * this.num2;
    }

    /**
     * Displays the product
     */
    public void displayProduct() {
        this.productText.setText(Double.toString(this.product));
    }

    /**
     * Event handler for multiply button click
     * @param view The parent view of the event
     */
    private void addButtonClicked(View view) {
        listener.onDataAdd();
    }

    /**
     * Action taken when the fragment is attached
     * @param context The parent context of this fragment
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataAddListener) {
            this.listener = (DataAddListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement DataDisplayFragment.DataAddListener");
        }
    }
}
