class Lab8 {

    public static void main(String args[]) {
        System.out.println(IsPrime2(19));
        System.out.println(IsPrime2(190));
        System.out.println(IsPrime2(1));
        System.out.println(IsPrime2(2));
        System.out.println(IsPrime2(571));
    }

    static boolean IsPrime(int n) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) counter++;
        }
        if (counter == 2) return true;
        return false;
    }

    static boolean IsPrime2(int n) {
        if (n == 2) return true;
        if (n < 2 || n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}