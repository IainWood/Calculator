package edu.purdue.iwoodbur.calculator;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Iain Woodburn on 02-Dec-15.
 */
public class CalculatorView implements CalculatorViewInterface {

    private TextView resultDisplay;
    private TextView errorDisplay;

    public CalculatorView(TextView resultDisplay , TextView errorDisplay) {
        this.resultDisplay = resultDisplay;
        this.errorDisplay = errorDisplay;
    } //end CalculatorView

    public void display(String str) {
        errorDisplay.setVisibility(View.GONE);
        resultDisplay.setText(str);
    } //end display

    public void invalid() {
        errorDisplay.setVisibility(View.VISIBLE);
    } //end invalid

} //end CalculatorView
