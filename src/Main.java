import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        //problem1();
        //problem2();
        //problem3();
        //problem4();
        //problem5();
        //problem6();
        //problem7();
        //problem8();
        //problem9();
        //problem10();
        //problem11();
      problem28();
    }
    public static void problem28(){
      int sum = 0;
      for (int i = 3; i <= 1001; i += 2) {
        sum += 4*(i*i) - (i-1)*6;
      }
      sum++;
      System.out.println(sum);
    }

    public static void problem1(){
        int sum = 0;
        for (int i = 1; i < 1000 ; i++) {
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        System.out.println("Die Summe ist:" + sum);
    }

    public static void problem2(){
        int first = 1;
        int second = 2;
        int third;
        int sum = 0;
        while(first <= 4000000){
            if(first % 2 == 0){
                sum += first;
            }
            /*if(second % 2 == 0){
                sum += second;
            }*/
            third = first + second;
            first = second;
            second = third;

        }
        System.out.println("Die Summe ist:" + sum);
    }

    private static void problem3(){
        long number = 600851475143L;
        long p;
        while (true) {
            p = smallestFactor(number);
            if(p < number){
                number /= p;
            }
            else{
                System.out.println("Die Zahl ist: "+ number);
                return;
            }
        }


    }
    private static long smallestFactor(long n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i;
            }

        }
        return n; //n is a prime
    }

    private static void problem4(){
        int product;
        int biggest = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                product = i * j;
                if(isPalindrome(product)){
                    if(product > biggest) {
                        biggest = product;
                    }
                }
            }

        }
        System.out.println("Das grßte Palindrom ist: " + biggest);
    }

    private static boolean isPalindrome(int n){
        String stringn = Integer.toString(n);
        int slenght = stringn.length();
        for (int i = 0,k = slenght-1; i < slenght/2; i++, k--) {
            if(stringn.charAt(i) != stringn.charAt(k)){
                return false;
            }
        }
        return true;
    }

    private static void problem5(){
        int number = 1;
        boolean flag = true;
        while (true) {
            for (int i = 1; i < 21; i++) {
                flag = true;
                if(number % i != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            number++;
        }
        System.out.println("Die kleinste Zahl ist: " + number);
    }

    private static void problem6(){
        long sumOfSquares = 0L;
        long squareofSums = 0L;
        for (int i = 1; i < 101; i++) {
            sumOfSquares += Math.pow(i,2);
        }
        for (int i = 1; i < 101; i++) {
            squareofSums += i;
        }
        squareofSums = (long) Math.pow(squareofSums, 2.0);
        System.out.println("Die Differenz ist: " + (squareofSums - sumOfSquares));
    }

    private static void problem7(){
        int counter = 0;
        int number = 1;
        while (counter < 10002) {
            if(isPrime(number)){
                counter++;
                number++;
            }
            else number++;
        }
        number--;
        System.out.println(number);
    }

    private static boolean isPrime(int n){
        if(n == 1) return false;
        if(n == 2) return true;
        if(n == 3) return true;
        if(n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    private static void problem8(){
        String BigNumberString =
                "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        int BigNumberLength = BigNumberString.length();
        int BiggestProductStart = 0;
        long BiggestProduct = 1; //Long wichtig, höchster Wert ist 9^13 > Int MAX_VALUE

        for (int i = 0; i < BigNumberLength - 13; i++) {
            long product = 1;
            for (int j = i; j < i + 13; j++) {
                    product *= Integer.parseInt(String.valueOf(BigNumberString.charAt(j)));
            }
            if(product > BiggestProduct){
                BiggestProduct = product;
                BiggestProductStart = i;
            }
        }
        System.out.println("Das größte Produkt ist: " + BiggestProduct);
        System.out.println("Der Start ist : " + BiggestProductStart);
    }

    private static void problem9(){
        final int OneThousand = 1000;
        for(int a = 1; a<OneThousand; a++){
            for (int b = a + 1; b < OneThousand; b++) {
                int c = OneThousand - a - b;
                if(a*a + b*b == c*c){
                    System.out.println("Das Produkt ist:" +(a*b*c));
                    System.out.printf("A:%d B:%d C:%d",a,b,c);
                }
            }
        }
    }

    private static void problem10(){
        List<Integer> numberlist = new ArrayList<>();
        numberlist.add(2); //Weil die Schleife erst bei 3 beginnt
        long sum = 0L;
        final int TwoMillion = 2000000;
        /*for (int i = 1; i < TwoMillion; i++) {
            if(isPrime(i)){
                System.out.println(i);
                sum += i;
            }
        }*/
        for (int i = 3; i < TwoMillion; i+=2) {
            numberlist.add(i);
        }
        for (int p: numberlist) {
            if(isPrime(p)){
                sum += p;
                System.out.println(p);
            }
        }
        System.out.println("Die Summe ist:" + sum);
    }

    private static void problem11() {
        int[][] SQUARE = {
                {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
                {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
                {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65},
                {52, 70, 95, 23, 4, 60, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91},
                {22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40, 28, 66, 33, 13, 80},
                {24, 47, 32, 60, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 20, 35, 17, 12, 50},
                {32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70, 66, 18, 38, 64, 70},
                {67, 26, 20, 68, 2, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40, 91, 66, 49, 94, 21},
                {24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72},
                {21, 36, 23, 9, 75, 0, 76, 44, 20, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95},
                {78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 80, 4, 62, 16, 14, 9, 53, 56, 92},
                {16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57},
                {86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 60, 21, 58, 51, 54, 17, 58},
                {19, 80, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 40},
                {4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66},
                {88, 36, 68, 87, 57, 62, 20, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69},
                {4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 40, 62, 76, 36},
                {20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16},
                {20, 73, 35, 29, 78, 31, 90, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54},
                {1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48},
        };
        int xlength = SQUARE[0].length;
        int ylength = SQUARE.length;
        int max = 1, newmax = 1;
        int vertical =1, horizontal=1, diagonal=1, column;
        for (int row = 0; row < SQUARE.length; row++) {
            column = 0;
            for (column = 0; column < SQUARE[row].length; column++) {
                if(column <= xlength - 4) {
                    horizontal = SQUARE[row][column] * SQUARE[row][column + 1] * SQUARE[row][column + 2] * SQUARE[row][column + 3];

                }
                if(row <= ylength - 4){
                    vertical = SQUARE[row][column] * SQUARE[row+1][column] * SQUARE[row+2][column] * SQUARE[row+3][column];
                }
                if(row <= ylength - 4 && column <= xlength - 4){
                    diagonal = SQUARE[row][column] * SQUARE[row+1][column+1] * SQUARE[row+2][column+2] * SQUARE[row+3][column+3];
                }
                newmax = Math.max(Math.max(horizontal,diagonal),vertical);
                if(newmax > max){
                    max = newmax;
                }

            }

        }
        System.out.println("Das Ergebnis ist: " +max);
    }
}
