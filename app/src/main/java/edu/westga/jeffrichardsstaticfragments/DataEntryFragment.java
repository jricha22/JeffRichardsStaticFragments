package edu.westga.jeffrichardsstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {
    private EditText number1;
    private EditText number2;
    private DataEntryListener listener;

    public interface DataEntryListener {
        public void onDataEntry(double num1, double num2);
    }

    /**
     * Default constructor
     */
    public DataEntryFragment() {
        // Required empty public constructor
    }

    /**
     * Action on view creation
     * @param inflater Inflator to create the view
     * @param container Container that will contain this view
     * @param savedInstanceState Saved state of the instance
     * @return New view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView =  inflater.inflate(R.layout.fragment_data_entry, container, false);
        this.number1 = (EditText) theView.findViewById(R.id.txtNum1);
        this.number2 = (EditText) theView.findViewById(R.id.txtNum2);
        Button multiplyButton = (Button) theView.findViewById(R.id.btnMultiply);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiplyButtonClicked(v);
            }
        });
        return theView;
    }

    /**
     * Event handler for multiply button click
     * @param view The parent view of the event
     */
    private void multiplyButtonClicked(View view) {
        double num1 = Double.parseDouble(this.number1.getText().toString());
        double num2 = Double.parseDouble(this.number2.getText().toString());
        listener.onDataEntry(num1, num2);
    }

    /**
     * Action taken when the fragment is attached
     * @param context The parent context of this fragment
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DataEntryListener) {
            this.listener = (DataEntryListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement DataEntryFragment.DataEntryListener");
        }
    }
}
