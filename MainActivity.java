package edu.purdue.iwoodbur.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CalculatorView view;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = new CalculatorView((TextView) findViewById(R.id.displayAns)
                , (TextView) findViewById(R.id.errBox));
        calculator = new Calculator(view);

        /*Button zeroButton = (Button) findViewById(R.id.zeroButton);
        Button oneButton = (Button) findViewById(R.id.oneButton);
        Button twoButton = (Button) findViewById(R.id.twoButton);
        Button threeButton = (Button) findViewById(R.id.threeButton);
        Button fourButton = (Button) findViewById(R.id.fourButton);
        Button fiveButton = (Button) findViewById(R.id.fiveButton);
        Button sixButton = (Button) findViewById(R.id.sixButton);
        Button sevenButton = (Button) findViewById(R.id.sevenButton);
        Button eightButton = (Button) findViewById(R.id.eightButton);
        Button nineButton = (Button) findViewById(R.id.nineButton);

        TextView resultDisplay = (TextView) findViewById(R.id.displayAns);
        TextView errorDisplay = (TextView) findViewById(R.id.errBox);*/

    }

    public void zeroButton(View view) {
        calculator.inputDigit('0');
    } //end zeroButton

    public void oneButton(View view) {
        calculator.inputDigit('1');
    } //end oneButton

    public void twoButton(View view) {
        calculator.inputDigit('2');
    } //end twoButton

    public void threeButton(View view) {
        calculator.inputDigit('3');
    } //end threeButton

    public void fourButton(View view) {
        calculator.inputDigit('4');
    } //end fourButton

    public void fiveButton(View view) {
        calculator.inputDigit('5');
    } //end fiveButton

    public void sixButton(View view) {
        calculator.inputDigit('6');
    } //end sixButton

    public void sevenButton(View view) {
        calculator.inputDigit('7');
    } //end sevenButton

    public void eightButton(View view) {
        calculator.inputDigit('8');
    } //end eightButton

    public void nineButton(View view) {
        calculator.inputDigit('9');
    } //end nineButton

    public void plusButton(View view) {
        calculator.operator('+');
    } //end plusButton

    public void minusButton(View view) {
        calculator.operator('-');
    } //end minusButton

    public void multButton(View view) {
        calculator.operator('*');
    } //end multButton

    public void divButton(View view) {
        calculator.operator('/');
    } //end divButton

    public void dotButton(View view) {
        calculator.dot();
    } //end dotButton

    public void deleteButton(View view) {
        calculator.delete();
    } //end deleteButton

    public void equalsButton(View view) {
        calculator.equal();
    } //end equalsButton

} //end MainActivity
