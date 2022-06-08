package br.com.tvn.calcengine;

public class Multiplier extends CalculateBase implements MathProcessing{

    public Multiplier() {}

    public Multiplier(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "multiply";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal * rightVal;
    }
}
