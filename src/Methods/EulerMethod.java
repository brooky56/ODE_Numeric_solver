package Methods;

import Helpers.Function;
import Helpers.Logs;

import java.io.IOException;
import java.util.ArrayList;

public class EulerMethod {

    private ArrayList<Double> arrX = new ArrayList<>();
    private ArrayList<Double> arrY = new ArrayList<>();

    private static Function _Function;

    public EulerMethod(double step, int m, double x0, double y0, Logs logs, Function function) throws IOException {

        _Function = function;
        EM(step, m, x0, y0);
        saveLogs(logs);

    }

    public ArrayList<Double> getArrX() {
        return arrX;
    }

    public ArrayList<Double> getArrY() {
        return arrY;
    }

    private void EM(double step, int m, double initialX, double initialY) throws IOException {

        arrX.add(initialX);
        arrY.add(initialY);

        for (int i = 1; i < m + 1; i++) {
            arrX.add((myEulerX(step, arrX.get(i - 1))));
        }

        for (int i = 1; i < m + 1; i++) {
            arrY.add(myEulerY(step, arrX.get(i - 1), arrY.get(i - 1)));
        }
    }

    private void saveLogs(Logs logs) throws IOException {

        logs.writer.write("EM_X: " + arrX.toString() + "\n");
        logs.writer.write("EM_Y: " + arrY.toString() + "\n");
        logs.writer.write("---------------------------------------------------------------------------------------------------\n");
    }

    private static double myEulerX(double h, double xPre) {

        return xPre + h;
    }

    private static double myEulerY(double h, double xPre, double yPre) {

        return yPre + h * _Function.GetFunctionValue(xPre, yPre);
    }

}
