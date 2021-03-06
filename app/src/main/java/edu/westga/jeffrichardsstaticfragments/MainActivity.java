package edu.westga.jeffrichardsstaticfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.DataEntryListener, DataDisplayFragment.DataAddListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Create menu handler
     * @param menu Menu being created
     * @return True
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Action bar click handler
     * @param item Item clicked
     * @return Status of click
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handler for multiply button clicked in data entry fragment
     * @param num1 First number entered
     * @param num2 Second number entered
     */
    @Override
    public void onDataEntry(double num1, double num2) {
        DataDisplayFragment displayFragment = (DataDisplayFragment) getSupportFragmentManager().findFragmentById(R.id.dataDisplayFragment);
        displayFragment.setNum1(num1);
        displayFragment.setNum2(num2);
        displayFragment.multiply();
        displayFragment.displayProduct();
    }

    /**
     * Handler for add button clicked in data result fragment
     */
    @Override
    public void onDataAdd() {
        DataEntryFragment entryFragment = (DataEntryFragment) getSupportFragmentManager().findFragmentById(R.id.dataEntryFragment);
        DataSumDisplayFragment sumFragment = (DataSumDisplayFragment) getSupportFragmentManager().findFragmentById((R.id.dataSumDisplayFragment));
        sumFragment.displaySum(entryFragment.getNum1(), entryFragment.getNum2());
    }
}
