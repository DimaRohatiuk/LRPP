
public class Main {
    static int N1 = 4;
    static int N2 = 2;
    static int N3 = 6;
    static double delX = 0.003;

    public static void main(String[] args) throws Exception {
        double X1, X2, X3;

        X1 = 1.01;
        X2 = 0.56;
        X3 = 0.9;

        System.out.println("Made by: Vadym Bogorodetskyy KN-207");

        System.out.printf(
                "A) Result:\tAbs\tRel\n\tX1: %5.20f %5.20f\n\tX2: %5.20f %5.20f\n\tX3: %5.20f %5.20f\n\tFc: %5.20f %5.20f",
                getRelDeltaX(X1, N1) * X1, getRelDeltaX(X1, N1),
                getRelDeltaX(X2, N2) * X2, getRelDeltaX(X2, N2),
                getRelDeltaX(X3, N3) * X3, getRelDeltaX(X3, N3),
                getAbslFunc(X1, X2, X3), getAbslFunc(X1, X2, X3) / getFunVal(X1, X2, X3));

        System.out.printf("\nB) Result:\n\tN1: %d\n\tN2: %d\n\tN3: %d\n\tFc: %20.20f %20.20f", getN(X1), getN(X2),
                getN(X3), getAbslFuncB(X1, X2, X3), getAbslFuncB(X1, X2, X3) / getFunVal(X1, X2, X3));
    }

    public static int getFirstNum(double X) {
        X = Math.abs(X);
        if (X > 1.0) {
            while (X > 10) {
                X /= 10;
            }
            return (int) X;
        } else {
            while (X < 1.0) {
                X *= 10;
            }
            return (int) X;
        }
    }


    public static int getFirstNumPow(double X) {
        X = Math.abs(X);
        int counter = 0;
        if (X > 1.0) {
            while (X > 10) {
                X /= 10;
                counter++;
            }
            return counter;
        } else {
            while (X < 1.0) {
                X *= 10;
                counter--;
            }
            return counter;
        }
    }

    public static double getRelDeltaX(double X, int N) {
        if (N > 1) {
            double res = 1.0 / (2 * getFirstNum(X)) * Math.pow(0.1, N - 1);
            return res;
        } else {
            double res = 1.0 / getFirstNum(X) * Math.pow(0.1, N - 1);
            return res * X;
        }
    }

    public static double getAbslFunc(double X1, double X2, double X3) {
        double res = Math.abs(6 * X1 + 3 * X2 + Math.cos(X1 - X3 * X2)) * getRelDeltaX(X1, N1) * X1 +
                Math.abs(4 * X2 + 3 * X1 - 2 - X3 * Math.cos(X1 - X3 * X2)) * getRelDeltaX(X2, N2) * X2 +
                Math.abs(8 * X3 - X2 * Math.cos(X1 - X3 * X2)) * getRelDeltaX(X3, N3) * X3  ;
        return res;
    }

    public static double getAbslFuncB(double X1, double X2, double X3) {
        double res = Math.abs(6 * X1 + 3 * X2 + Math.cos(X1 - X3 * X2)) * delX +
                Math.abs(4 * X2 + 3 * X1 - 2 - X3 * Math.cos(X1 - X3 * X2)) * delX +
                Math.abs(8 * X3 - X2 * Math.cos(X1 - X3 * X2)) * delX;
        return res;
    }

    public static double getFunVal(double X1, double X2, double X3) {
        double F = 3 * X1 * X1 + 2 * X2 * X2 + 4 * X3 * X3
                + 3 * X1 * X2 - 2 * X2 + Math.sin(X1 - X3 * X2);
        return F;
    }

    public static int getN(double X) {
        int i = 0;
        for (; delX < 0.5 * Math.pow(10, i); i--) {
        }
        int n = getFirstNum(X) + 1 - ++i;
        return n;
    }
}