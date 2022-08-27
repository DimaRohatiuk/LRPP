public class number {
    public static void main(int numb) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        int result = 2;
        if (numb == 1) {
            result = 1;
            System.out.println("Result = [" + result + "]");
        }
        if (numb == 2) {
            result = 2;
            System.out.println("Result = [" + result + "]");
        }
        if (numb >= 3) {
            for (int i = 3; i <= numb; i++) {
                n2 = n0 + n1; //Додаємо теперішнє число до минулого
                n0 = n1; //Зберігаємо значення числа
                n1 = n2;
                result += (n2 * n2);
            }
            System.out.println("Result = [" + result + "]");
        }
    }
}