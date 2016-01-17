package edu.westga.jeffrichardsstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataSumDisplayFragment extends Fragment {
    TextView sumText;

    public DataSumDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_sum_display, container, false);
        this.sumText = (TextView) theView.findViewById(R.id.lblSum);
        return theView;
    }

    public void displaySum(double num1, double num2) {
        this.sumText.setText(Double.toString(num1 + num2));
    }

}
