package br.com.tvn.calcengine;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyWord();
    double doCalculation(double leftVal, double rightVal);
}
