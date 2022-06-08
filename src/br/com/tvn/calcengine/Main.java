package br.com.tvn.calcengine;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //performCalculations();
        Divider divider = new Divider();
        doCalculation(divider, 100.0, 50.0);

        Adder adder = new Adder();
        doCalculation(adder, 25.0, 92.0);

        executeInteractively();
    }

    static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperations(parts);
    }

    private static void performOperations(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = Double.parseDouble(parts[1]);
        double rightVal = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, leftVal, rightVal);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());
    }

    private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal) {
        CalculateBase calculation = null;
        switch (operation) {
            case ADD:
                calculation = new Adder(leftVal, rightVal);
                break;
            case SUBTRACT:
                calculation = new Subtractor(leftVal, rightVal);
                break;
            case MULTIPLY:
                calculation = new Multiplier(leftVal, rightVal);
                break;
            case DIVIDE:
                calculation = new Divider(leftVal, rightVal);
                break;
        }

        return calculation;
    }

    static void doCalculation(CalculateBase calculation, double leftVal, double rightVal) {
        calculation.setLeftVal(leftVal);
        calculation.setRightVal(rightVal);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

    private static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation( 'a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0);

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overloaded result with doubles: " + equationOverload.getResult());

        MathEquation equationOverloadInt = new MathEquation('d');
        int leftInt = 9;
        int rightInt = 4;
        equationOverloadInt.execute(leftInt, rightInt);
        System.out.println("Overloaded result with doubles: " + equationOverloadInt.getResult());
    }
}