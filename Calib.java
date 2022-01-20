package Jama;

import java.util.ArrayList;

public class Calib {


    // Erwartet Anzahl Matrizen, Matrizen von M-Matizen und N-Matrizen
    public ArrayList<Matrix> calibrate(ArrayList<Matrix> Ms, ArrayList<Matrix> Ns){


        ArrayList<Matrix> Ms_inv = (ArrayList<Matrix>) Ms.clone();

        ArrayList<Matrix> As = new ArrayList<>();
        ArrayList<Matrix> Bs = new ArrayList<>();

        for(int i = 0; i < Ms_inv.size(); i++) {
            Ms_inv.set(i, Ms_inv.get(i).inverse());
        }

        for(int i = 0; i < Ms.size(); i++){
            double[][] a = {{Ms_inv.get(i).get(0, 0) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(2, 0), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(2, 0), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(2, 0), 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {Ms_inv.get(i).get(1, 0) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(2, 0), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(2, 0), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(2, 0), 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {Ms_inv.get(i).get(2, 0) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(0, 0), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(1, 0), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(2, 0), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(2, 0), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(2, 0), 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},

                    {Ms_inv.get(i).get(0, 0) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(2, 1), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(2, 1), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(2, 1), 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {Ms_inv.get(i).get(1, 0) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(2, 1), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(2, 1), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(2, 1), 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                    {Ms_inv.get(i).get(2, 0) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(0, 1), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(1, 1), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(2, 1), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(2, 1), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(2, 1), 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},

                    {Ms_inv.get(i).get(0, 0) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(2, 2), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(2, 2), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(2, 2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {Ms_inv.get(i).get(1, 0) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(2, 2), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(2, 2), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(2, 2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                    {Ms_inv.get(i).get(2, 0) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(0, 2), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(1, 2), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(2, 2), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(2, 2), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(2, 2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},

                    {Ms_inv.get(i).get(0, 0) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(0, 0) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(0, 1) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(0, 2) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(0, 0), Ms_inv.get(i).get(0, 1), Ms_inv.get(i).get(0, 2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {Ms_inv.get(i).get(1, 0) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(1, 0) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(1, 1) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(1, 2) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(1, 0), Ms_inv.get(i).get(1, 1), Ms_inv.get(i).get(1, 2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {Ms_inv.get(i).get(2, 0) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(0, 3), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(1, 3), Ms_inv.get(i).get(2, 0) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(2, 1) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(2, 2) * Ns.get(i).get(2, 3), Ms_inv.get(i).get(2, 0), Ms_inv.get(i).get(2, 1), Ms_inv.get(i).get(2, 2), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},

            };

            double[][] b = { {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {-Ms.get(i).get(0,3)}, {-Ms.get(i).get(1,3)}, {-Ms.get(i).get(2,3)}};

            As.add(new Matrix(a));
            Bs.add(new Matrix(b));

        }
        Matrix A = new Matrix(As.size()*12, 24);
        int counter = 0;
        for(int a = 0; a < As.size(); a++){
            for(int i = 0; i < 12; i++){
                for(int j = 0; j < 24; j++){
                    A.set(counter+i, j,As.get(a).get(i,j));
                    //System.out.print(A.get(counter+i, j) + " ");
                }
                System.out.println("\n");
            }
            counter = counter + 12;
        }

        Matrix B = new Matrix(Bs.size()*12, 1);
        for(int b = 0; b < Bs.size(); b++){
            for(int i = 0; i < 12; i++){
                B.set((b+1)*i, 0,Bs.get(b).get(i,0));
                //System.out.println(B.get((b+1)*i, 0));
            }
        }

        System.out.println("size A: " + A.getRowDimension()+ "x" + A.getColumnDimension());
        System.out.println("size B: " + B.getRowDimension()+ "x" + B.getColumnDimension());
        System.out.println("rank a: " + A.rank());
        Matrix W = A.solve(B);

        for(int i = 0; i<24; i++){
            System.out.println(W.get(i,0));
        }

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
/*
        System.out.println("X = ");
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(X.getArray()[i][j] + " ");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
        System.out.println("Y = ");
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(Y.getArray()[i][j]+ " ");
            }
            System.out.println("\n");
        }
*/

        ArrayList<Matrix> XY = new ArrayList<>();
        return XY;
    }

}
