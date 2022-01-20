package Jama;

import Jama.LUDecomposition;
import Jama.Matrix;

public class Calibration {


    public static void main(String[]args){

        // M*X = Y*N

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
        Matrix M1_inv = M1.inverse();
        Matrix M2_inv = M2.inverse();

        double[][] a = {{M1_inv.get(0,0) * N1.get(0,0), M1_inv.get(0,1) * N1.get(0,0), M1_inv.get(0,2) * N1.get(0,0), M1_inv.get(0,0) * N1.get(1,0), M1_inv.get(0,1) * N1.get(1,0), M1_inv.get(0,2) * N1.get(1,0), M1_inv.get(0,0) * N1.get(2,0), M1_inv.get(0,1) * N1.get(2,0), M1_inv.get(0,2) * N1.get(2,0), 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {M1_inv.get(1,0) * N1.get(0,0), M1_inv.get(1,1) * N1.get(0,0), M1_inv.get(1,2) * N1.get(0,0), M1_inv.get(1,0) * N1.get(1,0), M1_inv.get(1,1) * N1.get(1,0), M1_inv.get(1,2) * N1.get(1,0), M1_inv.get(1,0) * N1.get(2,0), M1_inv.get(1,1) * N1.get(2,0), M1_inv.get(1,2) * N1.get(2,0), 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {M1_inv.get(2,0) * N1.get(0,0), M1_inv.get(2,1) * N1.get(0,0), M1_inv.get(2,2) * N1.get(0,0), M1_inv.get(2,0) * N1.get(1,0), M1_inv.get(2,1) * N1.get(1,0), M1_inv.get(2,2) * N1.get(1,0), M1_inv.get(2,0) * N1.get(2,0), M1_inv.get(2,1) *N1.get(2,0), M1_inv.get(2,2) * N1.get(2,0), 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},

                {M1_inv.get(0,0) * N1.get(0,1), M1_inv.get(0,1) * N1.get(0,1), M1_inv.get(0,2) * N1.get(0,1), M1_inv.get(0,0) * N1.get(1,1), M1_inv.get(0,1) * N1.get(1,1), M1_inv.get(0,2) * N1.get(1,1), M1_inv.get(0,0) * N1.get(2,1), M1_inv.get(0,1) * N1.get(2,1), M1_inv.get(0,2) * N1.get(2,1), 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {M1_inv.get(1,0) * N1.get(0,1), M1_inv.get(1,1) * N1.get(0,1), M1_inv.get(1,2) * N1.get(0,1), M1_inv.get(1,0) * N1.get(1,1), M1_inv.get(1,1) * N1.get(1,1), M1_inv.get(1,2) * N1.get(1,1), M1_inv.get(1,0) * N1.get(2,1), M1_inv.get(1,1) * N1.get(2,1), M1_inv.get(1,2) * N1.get(2,1), 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {M1_inv.get(2,0) * N1.get(0,1), M1_inv.get(2,1) * N1.get(0,1), M1_inv.get(2,2) * N1.get(0,1), M1_inv.get(2,0) * N1.get(1,1), M1_inv.get(2,1) * N1.get(1,1), M1_inv.get(2,2) * N1.get(1,1), M1_inv.get(2,0) * N1.get(2,1), M1_inv.get(2,1) * N1.get(2,1), M1_inv.get(2,2) * N1.get(2,1), 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},

                {M1_inv.get(0,0) * N1.get(0,2), M1_inv.get(0,1) * N1.get(0,2), M1_inv.get(0,2) * N1.get(0,2), M1_inv.get(0,0) * N1.get(1,2), M1_inv.get(0,1) * N1.get(1,2), M1_inv.get(0,2) * N1.get(1,2), M1_inv.get(0,0) * N1.get(2,2), M1_inv.get(0,1) * N1.get(2,2), M1_inv.get(0,2) * N1.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {M1_inv.get(1,0) * N1.get(0,2), M1_inv.get(1,1) * N1.get(0,2), M1_inv.get(1,2) * N1.get(0,2), M1_inv.get(1,0) * N1.get(1,2), M1_inv.get(1,1) * N1.get(1,2), M1_inv.get(1,2) * N1.get(1,2), M1_inv.get(1,0) * N1.get(2,2), M1_inv.get(1,1) * N1.get(2,2), M1_inv.get(1,2) * N1.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {M1_inv.get(2,0) * N1.get(0,2), M1_inv.get(2,1) * N1.get(0,2), M1_inv.get(2,2) * N1.get(0,2), M1_inv.get(2,0) * N1.get(1,2), M1_inv.get(2,1) * N1.get(1,2), M1_inv.get(2,2) * N1.get(1,2), M1_inv.get(2,0) * N1.get(2,2), M1_inv.get(2,1) * N1.get(2,2), M1_inv.get(2,2) * N1.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},

                {M1_inv.get(0,0) * N1.get(0,3), M1_inv.get(0,1) * N1.get(0,3), M1_inv.get(0,2) * N1.get(0,3), M1_inv.get(0,0) * N1.get(1,3), M1_inv.get(0,1) * N1.get(1,3), M1_inv.get(0,2) * N1.get(1,3), M1_inv.get(0,0) * N1.get(2,3), M1_inv.get(0,1) * N1.get(2,3), M1_inv.get(0,2) * N1.get(2,3), M1_inv.get(0,0), M1_inv.get(0,1), M1_inv.get(0,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {M1_inv.get(1,0) * N1.get(0,3), M1_inv.get(1,1) * N1.get(0,3), M1_inv.get(1,2) * N1.get(0,3), M1_inv.get(1,0) * N1.get(1,3), M1_inv.get(1,1) * N1.get(1,3), M1_inv.get(1,2) * N1.get(1,3), M1_inv.get(1,0) * N1.get(2,3), M1_inv.get(1,1) * N1.get(2,3), M1_inv.get(1,2) * N1.get(2,3), M1_inv.get(1,0), M1_inv.get(1,1), M1_inv.get(1,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {M1_inv.get(2,0) * N1.get(0,3), M1_inv.get(2,1) * N1.get(0,3), M1_inv.get(2,2) * N1.get(0,3), M1_inv.get(2,0) * N1.get(1,3), M1_inv.get(2,1) * N1.get(1,3), M1_inv.get(2,2) * N1.get(1,3), M1_inv.get(2,0) * N1.get(2,3), M1_inv.get(2,1) * N1.get(2,3), M1_inv.get(2,2) * N1.get(2,3), M1_inv.get(2,0), M1_inv.get(2,1), M1_inv.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},



                {M2_inv.get(0,0) * N2.get(0,0), M2_inv.get(0,1) * N2.get(0,0), M2_inv.get(0,2) * N2.get(0,0), M2_inv.get(0,0) * N2.get(1,0), M2_inv.get(0,1) * N2.get(1,0), M2_inv.get(0,2) * N2.get(1,0), M2_inv.get(0,0) * N2.get(2,0), M2_inv.get(0,1) * N2.get(2,0), M2_inv.get(0,2) * N2.get(2,0), 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {M2_inv.get(1,0) * N2.get(0,0), M2_inv.get(1,1) * N2.get(0,0), M2_inv.get(1,2) * N2.get(0,0), M2_inv.get(1,0) * N2.get(1,0), M2_inv.get(1,1) * N2.get(1,0), M2_inv.get(1,2) * N2.get(1,0), M2_inv.get(1,0) * N2.get(2,0), M2_inv.get(1,1) * N2.get(2,0), M2_inv.get(1,2) * N2.get(2,0), 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {M2_inv.get(2,0) * N2.get(0,0), M2_inv.get(2,1) * N2.get(0,0), M2_inv.get(2,2) * N2.get(0,0), M2_inv.get(2,0) * N2.get(1,0), M2_inv.get(2,1) * N2.get(1,0), M2_inv.get(2,2) * N2.get(1,0), M2_inv.get(2,0) * N2.get(2,0), M2_inv.get(2,1) * N2.get(2,0), M2_inv.get(2,2) * N2.get(2,0), 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},

                {M2_inv.get(0,0) * N2.get(0,1), M2_inv.get(0,1) * N2.get(0,1), M2_inv.get(0,2) * N2.get(0,1), M2_inv.get(0,0) * N2.get(1,1), M2_inv.get(0,1) * N2.get(1,1), M2_inv.get(0,2) * N2.get(1,1), M2_inv.get(0,0) * N2.get(2,1), M2_inv.get(0,1) * N2.get(2,1), M2_inv.get(0,2) * N2.get(2,1), 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {M2_inv.get(1,0) * N2.get(0,1), M2_inv.get(1,1) * N2.get(0,1), M2_inv.get(1,2) * N2.get(0,1), M2_inv.get(1,0) * N2.get(1,1), M2_inv.get(1,1) * N2.get(1,1), M2_inv.get(1,2) * N2.get(1,1), M2_inv.get(1,0) * N2.get(2,1), M2_inv.get(1,1) * N2.get(2,1), M2_inv.get(1,2) * N2.get(2,1), 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {M2_inv.get(2,0) * N2.get(0,1), M2_inv.get(2,1) * N2.get(0,1), M2_inv.get(2,2) * N2.get(0,1), M2_inv.get(2,0) * N2.get(1,1), M2_inv.get(2,1) * N2.get(1,1), M2_inv.get(2,2) * N2.get(1,1), M2_inv.get(2,0) * N2.get(2,1), M2_inv.get(2,1) * N2.get(2,1), M2_inv.get(2,2) * N2.get(2,1), 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},

                {M2_inv.get(0,0) * N2.get(0,2), M2_inv.get(0,1) * N2.get(0,2), M2_inv.get(0,2) * N2.get(0,2), M2_inv.get(0,0) * N2.get(1,2), M2_inv.get(0,1) * N2.get(1,2), M2_inv.get(0,2) * N2.get(1,2), M2_inv.get(0,0) * N2.get(2,2), M2_inv.get(0,1) * N2.get(2,2), M2_inv.get(0,2) * N2.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {M2_inv.get(1,0) * N2.get(0,2), M2_inv.get(1,1) * N2.get(0,2), M2_inv.get(1,2) * N2.get(0,2), M2_inv.get(1,0) * N2.get(1,2), M2_inv.get(1,1) * N2.get(1,2), M2_inv.get(1,2) * N2.get(1,2), M2_inv.get(1,0) * N2.get(2,2), M2_inv.get(1,1) * N2.get(2,2), M2_inv.get(1,2) * N2.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {M2_inv.get(2,0) * N2.get(0,2), M2_inv.get(2,1) * N2.get(0,2), M2_inv.get(2,2) * N2.get(0,2), M2_inv.get(2,0) * N2.get(1,2), M2_inv.get(2,1) * N2.get(1,2), M2_inv.get(2,2) * N2.get(1,2), M2_inv.get(2,0) * N2.get(2,2), M2_inv.get(2,1) * N2.get(2,2), M2_inv.get(2,2) * N2.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},

                {M2_inv.get(0,0) * N2.get(0,3), M2_inv.get(0,1) * N2.get(0,3), M2_inv.get(0,2) * N2.get(0,3), M2_inv.get(0,0) * N2.get(1,3), M2_inv.get(0,1) * N2.get(1,3), M2_inv.get(0,2) * N2.get(1,3), M2_inv.get(0,0) * N2.get(2,3), M2_inv.get(0,1) * N2.get(2,3), M2_inv.get(0,2) * N2.get(2,3), M2_inv.get(0,0), M2_inv.get(0,1), M2_inv.get(0,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {M2_inv.get(1,0) * N2.get(0,3), M2_inv.get(1,1) * N2.get(0,3), M2_inv.get(1,2) * N2.get(0,3), M2_inv.get(1,0) * N2.get(1,3), M2_inv.get(1,1) * N2.get(1,3), M2_inv.get(1,2) * N2.get(1,3), M2_inv.get(1,0) * N2.get(2,3), M2_inv.get(1,1) * N2.get(2,3), M2_inv.get(1,2) * N2.get(2,3), M2_inv.get(1,0), M2_inv.get(1,1), M2_inv.get(1,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {M2_inv.get(2,0) * N2.get(0,3), M2_inv.get(2,1) * N2.get(0,3), M2_inv.get(2,2) * N2.get(0,3), M2_inv.get(2,0) * N2.get(1,3), M2_inv.get(2,1) * N2.get(1,3), M2_inv.get(2,2) * N2.get(1,3), M2_inv.get(2,0) * N2.get(2,3), M2_inv.get(2,1) * N2.get(2,3), M2_inv.get(2,2) * N2.get(2,3), M2_inv.get(2,0), M2_inv.get(2,1), M2_inv.get(2,2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},

        };

        Matrix A = new Matrix(a);



        double[][] b = { {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {-M1.get(0,3)}, {-M1.get(1,3)}, {-M1.get(2,3)}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {-M2.get(0,3)}, {-M2.get(1,3)}, {-M2.get(2,3)}};
        Matrix B = new Matrix(b);



        System.out.println("size A: " + A.getRowDimension()+ "x" + A.getColumnDimension());
        System.out.println("size B: " + B.getRowDimension()+ "x" + B.getColumnDimension());
        
        System.out.println("rank a: " + A.rank());
        Matrix W = A.solve(B);

        double[][] x = {{W.get(0,0), W.get(3,0), W.get(6,0), W.get(9,0)},
                {W.get(1,0), W.get(4,0), W.get(7,0), W.get(10,0)},
                {W.get(2,0), W.get(5,0), W.get(8,0), W.get(11,0)},
                {0, 0, 0, 1}};

        double[][] y = {{ W.get(12,0), W.get(15,0), W.get(18,0), W.get(21,0)},
                {W.get(13,0), W.get(16,0), W.get(19,0), W.get(22,0)},
                {W.get(14,0), W.get(17,0), W.get(20,0), W.get(23,0)},
                {0, 0, 0, 1}};


        Matrix X = new Matrix(x);
        Matrix Y = new Matrix(y);

        System.out.println("W = ");
        for(int i = 0; i < 24; i++){
            System.out.println(W.get(i,0) + " ");
        }
        System.out.println("\n");
        System.out.println("X = ");
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(X.getArray()[i][j] + " ");
            }
            System.out.println("\n");
        }

        /*
        System.out.println("\n");
        System.out.println("Y = ");
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(Y.getArray()[i][j]+ " ");
            }
            System.out.println("\n");
        }

        System.out.println("\n");
        System.out.println("A = ");
        for(int i = 0; i < 24; i++){
            for(int j = 0; j < 24; j++){
                System.out.print(A.getArray()[i][j]+ " ");
            }
            System.out.println("\n");
        }


        System.out.println("\n");
        System.out.println("B = ");

        for(int j = 0; j < 24; j++){
            System.out.println(B.getArray()[j][0]+ " ");
        }
        System.out.println("\n");
*/

    }

}
