package br.com.tvn.calcengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] leftVals = {100.0, 25.0, 255.0, 11.0};
        double[] rightVals = {50.0, 92.0, 17.0, 3.0};
        char[] opCodes = {'d','a', 's', 'm'};
        double[] results = new double[opCodes.length];
        double value1 = 100.0d;
        double value2 = 50.0d;
        double result = 0.0d;
        char opCode = 'd';


        for (int i = 0; i < opCodes.length; i++) {
            switch (opCodes[i]) {
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    break;
                case 'd':
                    results[i] = rightVals[i] != 0 ? leftVals[i] / rightVals[i] : 0.0d; //ignored
                    break;
                default:
                    System.out.println("Invalid opCode: " + opCode);
                    results[i] = 0.0d;
                    break;
            }
        }

        for (double currentVal : results) {
            System.out.println(currentVal);
        }
    }
}
