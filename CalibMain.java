package Jama;

import java.util.ArrayList;

public class CalibMain {

    public static void main(String[] args) {

        ArrayList<Matrix> Ms = new ArrayList<>();
        ArrayList<Matrix> Ns = new ArrayList<>();

        double[][] m1 = {{-0.18, 0, 0.98, 928.232},
                {0.01, 1, 0, 8.509},
                {-0.98, 0.01, -0.18, 392.979},
                {0, 0, 0, 1}};

        double[][] m2 = {{-0.24, -0.18, 0.95, 889.02},
                {0.28, 0.93, 0.25, 226.827},
                {-0.93, 0.33, -0.17, 173.287},
                {0, 0, 0, 1}};

        double[][] n1 = {{-0.13, 0.4, -1, -36.3},
                {-0.05, -1, -0.03, -175.7},
                {-1, 0.04, 0.13, -1285.77},
                {0, 0, 0, 1}};

        double[][] n2 = {{-0.12, -0.23, -0.97, 173.64},
                {-0.32, -0.91, 0.26, 53.77},
                {-0.94, 0.34, 0.03, -1320.49},
                {0, 0, 0, 1}};

        Matrix M1 = new Matrix(m1);
        Matrix M2 = new Matrix(m2);
        Matrix N1 = new Matrix(n1);
        Matrix N2 = new Matrix(n2);

        Ms.add(M1);
        Ms.add(M2);
        Ns.add(N1);
        Ns.add(N2);


        Calib calib = new Calib();
        calib.calibrate(Ms, Ns);
    }
}
