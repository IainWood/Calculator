package edu.purdue.iwoodbur.calculator;
/**
 * Created by Iain Woodburn on 02-Dec-15.
 */

import java.text.DecimalFormat;
import java.util.Stack;

public class Calculator {

    private CalculatorViewInterface view;
    private Stack <String> stack = new Stack<>();
    private Stack <String> storedStack = new Stack<>();
    private boolean calledEquals;
    DecimalFormat df = new DecimalFormat("#.00");

    public Calculator(CalculatorViewInterface view) {
        this.view = view;
    } //end Calculator

    //Assume all are valid
    public void inputDigit(char act) {

        boolean hasOperator = stack.contains(" + ") || stack.contains(" - ")
                || stack.contains(" * ") || stack.contains(" / "); //checks if there is already an operator
        int locOfOp = Math.max(stack.search(" + ") , Math.max(stack.search(" - ") ,
                Math.max(stack.search(" * ") , stack.search(" / "))));
        int locOfDot = stack.search(".");

        if (calledEquals) {
            calledEquals = false;
            stack.clear();
        } //end if

        if (stack.contains(".")) {

            if (stack.size() - stack.lastIndexOf(".") <= 2) {
                stack.push(String.valueOf(act));
                view.display(getString(this.stack));
            } else if (hasOperator || locOfOp > locOfDot) {
                stack.push(String.valueOf(act));
                view.display(getString(this.stack));
            } else {
                view.invalid();
            } //end if

        } else {
            stack.push(String.valueOf(act));
            view.display(getString(this.stack));
        } //end if

    } //end inputDigit

    @SuppressWarnings("unchecked")
    public void equal() {

        String num1 = "";
        String num2 = "";
        String oper = "";
        Double answer = 0.0;
        boolean done = false;
        boolean hasOperator = stack.contains(" + ") || stack.contains(" - ")
                || stack.contains(" * ") || stack.contains(" / "); //checks if there is already an operator

        storedStack = (Stack<String>)stack.clone(); //Handles the "delete after equals" scenario

        if (stack.size() != 0 && !stack.peek().trim().matches("[0-9]") || !hasOperator) {
            view.invalid();
        } else {

            while (!done) {

                if (stack.peek().trim().matches("[0-9]") || stack.peek().trim().equals(".")) {
                    num2 = stack.pop() + num2;
                } else if (stack.peek().trim().equals("+") || stack.peek().trim().equals("-")
                        || stack.peek().trim().equals("*") || stack.peek().trim().equals("/")) {
                    oper = stack.pop().trim();
                    done = true;
                } //end if

            } //end while

            while (!stack.empty()) {
                num1 = stack.pop() + num1;
            } //end while

            switch (oper) {

                case "+":
                    answer = Double.parseDouble(num1) + Double.parseDouble(num2);
                    break;
                case "-":
                    answer = Double.parseDouble(num1) - Double.parseDouble(num2);
                    break;
                case "*":
                    answer = Double.parseDouble(num1) * Double.parseDouble(num2);
                    break;
                case "/":
                    answer = Double.parseDouble(num1) / Double.parseDouble(num2);
                default:
                    System.out.print("Something went wrong");

            } //end switch

            if (Double.parseDouble(num2) == 0) {

                if (Double.parseDouble(num1) == 0) {
                    stack.push("NaN");
                } else if (Double.parseDouble(num1) > 0) {
                    stack.push("Infinity");
                } else {
                    stack.push("-Infinity");
                } //end if

            } else { //String.format("%04d", messageNum)
                stack.push(String.format( "%.2f" , answer));
                calledEquals = true;
            } //end if

            view.display(getString(this.stack));

        } //end if

    } //end equal

    public void dot() {

        int locOfOp = Math.max(stack.search(" + ") , Math.max(stack.search(" - ") ,
                Math.max(stack.search(" * ") , stack.search(" / "))));
        int locOfDot = stack.search(".");

        if (stack.size() == 0 || stack.peek().trim().equals("+") || stack.peek().trim().equals("-")
                || stack.peek().trim().equals("*") || stack.peek().trim().equals("/")) {
            view.invalid();
        } else {

            if (stack.peek().trim().matches("[0-9]") &&
                    (locOfDot < 0 || (locOfDot > -1 && locOfOp > -1 && locOfDot > locOfOp))) {
                stack.push(".");
                view.display(getString(this.stack));
            } else {
                view.invalid();
            } //end if

        } //end if

    } //end dot

    @SuppressWarnings("unchecked")
    public void delete() {

        if (calledEquals) {

            stack = (Stack<String>)storedStack.clone();
            calledEquals = false;

            try {
                view.display(getString(this.stack));
            } catch (Exception e) {
                e.printStackTrace();
            } //end try

        } else {

            try {
                stack.pop();
                view.display(getString(this.stack));
            } catch (Exception e) {
                e.printStackTrace();
            } //end try

        } //end if

    } //end delete

    public void operator(char op) {

        boolean hasOperator = stack.contains(" + ") || stack.contains(" - ")
                || stack.contains(" * ") || stack.contains(" / "); //checks if there is already an operator
        String top = "";
        if (stack.size() != 0) {
            top = stack.peek().trim();
        } else {
            view.invalid();
        } //end if

        if (stack.size() != 0 && (top.equals("NaN") || top.equals("Infinity") || top.equals("-Infinity"))) {
            view.invalid();
        } else {

            if (stack.size() != 0 && (stack.peek().trim().equals("+") || stack.peek().trim().equals("-")
                    || stack.peek().trim().equals("*") || stack.peek().trim().equals("/"))) {
                stack.pop(); //TODO: consider calling delete()
                stack.push(" " + String.valueOf(op) + " ");
                view.display(getString(this.stack));
            } else if (stack.size() != 0 && !hasOperator) {
                stack.push(" " + String.valueOf(op) + " ");
                view.display(getString(this.stack));
            } else {
                view.invalid();
            } //end if

        } //end if

    } //end operator

    public String getString(Stack stk) {

        String result = "";
        Stack temp = (Stack)stk.clone();

        while (!temp.empty()) {
            result = temp.pop().toString() + result;
        } //end while
        return result;
    } //end getString

} //end Calculator
