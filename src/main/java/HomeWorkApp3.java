import java.util.Random;
import java.util.Scanner;


public class HomeWorkApp3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("№1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0");
        System.out.println("Введите размерность массива");/*System.out.println("Insert the array's length");*/
        int n = in.nextInt();
        MakeChangeArray(n);
        System.out.println();
        System.out.println("\n№2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100");
        System.out.println("Какой элемент полученного массива вывести?");
        int g = in.nextInt();
        System.out.println(MakeArray()[g-1]);
        System.out.println("\n№3.Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2");
        ChangeArray();
        System.out.println();
        System.out.println("\n№4.Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n]");
        System.out.println("Введите размерность массива");/*System.out.println("Insert the array's length");*/
        int t = in.nextInt();
        TwoDimArray(t);
        System.out.println("\n№5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue");
        System.out.println("Введите переменные len и initialValue");
        int len = in.nextInt();
        int val = in.nextInt();
        int[] newArr = TwoDimArray2(len, val);
        for (int i = 0; i < len; i++) {
            System.out.print(newArr[i] + " ");
        }
        /*System.out.println(TwoDimArray2(len, val));*/
        System.out.println();
        System.out.println("\n№6. Задать одномерный массив и найти в нем минимальный и максимальный элементы");
        System.out.println("Введите размерность  массива");
        int d = in.nextInt();
        FindMaxMin(d, 40);
        System.out.println("\n№7.Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.");
        System.out.println("Получить массив через консоль?");
        String response = in.next();
        if (response.equalsIgnoreCase("Да")) {
            System.out.println("Введите размерность массива");
            int w = in.nextInt();
            int[] f = new int[w];
            System.out.println("Введите элементы массива по одному числу");
            for(int i = 0; i < w; i++){
                f[i] = in.nextInt();
            }
            System.out.println(FindPartSum(f));
        } else {
            int[] f = new int[]{2,2,2,1,2,2,10,1};
            System.out.println(FindPartSum(f));
        }
        System.out.println("№8.Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.");
        System.out.println("Получить массив через консоль?");
        String response2 = in.next();
        if (response2.equalsIgnoreCase("Да")) {
            System.out.println("Введите размерность массива");
            int w2 = in.nextInt();
            int[] f2 = new int[w2];
            for(int i = 0; i < w2; i++){
                f2[i] = in.nextInt();
            }
            System.out.println("Исходный массив");/*System.out.println("The initial array is");*/
            for (int i = 0; i < f2.length; i++) {
                System.out.print(f2[i]+" ");
            }
            System.out.println("\nВведите величину сдвига");
            int value = in.nextInt();
            ShiftArray(f2, value);
        } else {
            int[] f2 = new int[]{1,2,3,4,5,6,7,8,9,10};
            System.out.println("Исходный массив");/*System.out.println("The initial array is");*/
            for (int i = 0; i < f2.length; i++) {
                System.out.print(f2[i]+" ");
            }
            System.out.println("\nВведите величину сдвига");
            int value = in.nextInt();
            ShiftArray(f2, value);
        }
    }

    static void MakeChangeArray(int n) {
        int[] a = new int[n];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(2);
        }
        System.out.println("Исходный массив");/*System.out.println("The initial array is");*/
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        System.out.println("\nИзмененный массив");/*System.out.println("\nThe new array is");*/
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    static int[] MakeArray() {
        int[] a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = i+1;
            }
        return a;
    }

    static void ChangeArray() {
        int[] b = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив");
        for (int i = 0 ; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] < 6) {
                b[i] *= 2;
            }
        }
        System.out.println();
        System.out.println("Измененный массив");
        for (int i = 0 ; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
    }

    static void TwoDimArray(int dim) {
        int[][] c = new int[dim][dim];
        for (int i = 0 ; i < c.length; i++) {
            for (int j = 0 ; j < c.length; j++) {
                if (i == j || (dim - i - 1) == j) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = 0;
                }
            }
        }
        System.out.println("Полученный массив");
        for (int i = 0 ; i < c.length; i++) {
            for (int j = 0 ; j < c.length; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[] TwoDimArray2(int len, int initialValue) {
        int[] d = new int[len];
        for (int i = 0 ; i < d.length; i++) {
            d[i] = initialValue;
            }
        return d;
    }

    static void FindMaxMin(int n, int range) {
        int[] a = new int[n];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(range);
        }
        System.out.println("Исходный массив");/* System.out.println("The initial array is");*/
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        int  max = 0;
        int min = range;
        for (int i = 0; i < a.length; i++) {
            max = Math.max(a[i],max);
            min = Math.min(a[i],min);
        }
        System.out.println("\nМаксимальное значение: "+max+", минимальное значение: "+min);/*System.out.println("\nThe max value is "+max+" and min value is "+min);*/
    }

    static boolean FindPartSum(int[] array) {
        System.out.println("Иcходный массив");
        for (int i = 0 ; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int sum_first= 0, sum_second = 0;
            for (int j = 0; j < i; j++) {
                sum_first += array[j];
            }
            for (int k = array.length-1; k >= i; k--) {
                sum_second += array[k];
            }
            if (sum_second == sum_first) {
                count += 1;
            }
        }
        System.out.println();
        return (count != 0);
    }

    static int[] ShiftArray(int[] array, int value){
        if (value == 0 ) {
            return array;
        }
        if ((array.length%value == 0) && (value > 0)) {
            for (int i = 0; i < value; i++) {
                int temp1 = array[i], temp2 = 0;
                for (int j = 0; j <= array.length/value ; j++) {
                    temp2 = array[((value * j) + i)%array.length];
                    array[((value * j) + i)%array.length] = temp1;
                    temp1 = temp2;
                }
            }
        }
        if ((array.length%value == 0) && (value < 0)) {
            value *= -1;
            for (int i = 0; i < value; i++) {
                int temp1 = array[i], temp2 = 0;
                for (int j = array.length/value; j >=0 ; j--) {
                    temp2 = array[((value * j) + i)%array.length];
                    array[((value * j) + i)%array.length] = temp1;
                    temp1 = temp2;
                }
            }
        }
        if ((array.length%value != 0) && (value > 0)) {
                int temp1 = array[0], temp2 = 0;
                for (int j = 0; j <= array.length ; j++) {
                    temp2 = array[(value * j)%array.length];
                    array[(value * j)%array.length] = temp1;
                    temp1 = temp2;
                }
        }
        if ((array.length%value != 0) && (value < 0)) {
            int temp1 = array[0], temp2 = 0;
            value *= -1;
            for (int j = array.length; j >= 0 ; j--) {
                temp2 = array[(value * j)%array.length];
                array[(value * j)%array.length] = temp1;
                temp1 = temp2;
            }
        }
        System.out.println("Измененный массив");/*System.out.println("The initial array is");*/
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        return array;
    }
}

