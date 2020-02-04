package Helpers;

import org.mariuszgromada.math.mxparser.*;

public class Function {

    private static org.mariuszgromada.math.mxparser.Function _DiffEquation;

    private static org.mariuszgromada.math.mxparser.Function _ExactEquation;

    public Function(String functionStr, String exactFunctionStr) {
        /**
         * f(y,x) = x*x-2*y
         * */
        _DiffEquation = new org.mariuszgromada.math.mxparser.Function(functionStr);
        /**
         * f(x) = x*x-2*x+4*x
         * */
        _ExactEquation = new org.mariuszgromada.math.mxparser.Function(exactFunctionStr);
    }

    public double GetFunctionValue(double x, double y) {

        Argument xPre = new Argument(String.format("x = %s", Double.toString(x)));
        Argument yPre = new Argument(String.format("y = %s", Double.toString(y)));

        Expression e = new Expression("f(y,x)", _DiffEquation, yPre, xPre);

        return e.calculate();
    }

    public double GetExactSolutionFunctionValue(double x){

        Argument xPre = new Argument(String.format("x = %s", Double.toString(x)));
        System.out.println(String.format("x = %s", Double.toString(x)));

        Expression e = new Expression("f(x)", _ExactEquation, xPre);

        return e.calculate();
    }

}
