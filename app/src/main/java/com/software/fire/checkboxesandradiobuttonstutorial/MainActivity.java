package com.software.fire.checkboxesandradiobuttonstutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Integer> mCheckBoxesSelected;
    private int mRadioButtonSelected = -1;

    private CheckBox mFirstCheckbox;
    private CheckBox mSecondCheckbox;
    private CheckBox mThirdCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckBoxesSelected = new ArrayList<>(3);

        intialiseView();
    }

    private void intialiseView() {
        mFirstCheckbox = (CheckBox) findViewById(R.id.first_cb);
        mSecondCheckbox = (CheckBox) findViewById(R.id.second_cb);
        mThirdCheckbox = (CheckBox) findViewById(R.id.third_cb);

        mFirstCheckbox.setOnClickListener(this);
        mSecondCheckbox.setOnClickListener(this);
        mThirdCheckbox.setOnClickListener(this);

        findViewById(R.id.first_rb).setOnClickListener(this);
        findViewById(R.id.second_rb).setOnClickListener(this);
        findViewById(R.id.third_rb).setOnClickListener(this);

        findViewById(R.id.checkbox_button).setOnClickListener(this);
        findViewById(R.id.radio_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_cb:
                if (mFirstCheckbox.isChecked()) {
                    mCheckBoxesSelected.add(new Integer(1));
                } else {
                    mCheckBoxesSelected.remove(new Integer(1));
                }

                break;
            case R.id.second_cb:
                if(mSecondCheckbox.isChecked()){
                    mCheckBoxesSelected.add(new Integer(2));
                }else{
                    mCheckBoxesSelected.remove(new Integer(2));
                }
                break;
            case R.id.third_cb:
                if(mThirdCheckbox.isChecked()){
                    mCheckBoxesSelected.add(new Integer(3));
                }else{
                    mCheckBoxesSelected.remove(new Integer(3));
                }
                break;
            case R.id.first_rb:
                mRadioButtonSelected = 1;
                break;
            case R.id.second_rb:
                mRadioButtonSelected = 2;
                break;
            case R.id.third_rb:
                mRadioButtonSelected = 3;
                break;
            case R.id.checkbox_button:
                String checkBoxesSelected = "";
                for (int i = 0; i < mCheckBoxesSelected.size(); i++) {
                    checkBoxesSelected += mCheckBoxesSelected.get(i)  + "";
                }
                Toast.makeText(MainActivity.this, "Check Boxes selected: \n"+checkBoxesSelected, Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_button:
                Toast.makeText(MainActivity.this, "Radio Button Selected: " + mRadioButtonSelected, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
