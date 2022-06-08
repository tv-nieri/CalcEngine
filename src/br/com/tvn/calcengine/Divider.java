package br.com.tvn.calcengine;

public class Divider extends CalculateBase implements MathProcessing{

    public Divider() {}
    public Divider(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() / getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "divide";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return leftVal / rightVal;
    }
}
