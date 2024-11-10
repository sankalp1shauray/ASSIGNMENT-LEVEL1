public class Number {
    public static void main(String[] args) {
        MyNumber ob = new MyNumber();
        //Example:---
       
        System.out.println("Is 112 a Spy Number? " + ob.isSpyNumber(112));
        System.out.println("Is 203 a Duck Number? " + ob.isDuckNumber(203));
        System.out.println("Is 3025 a Tech Number? " + ob.isTechNumber(3025));
        System.out.println("Is 49 a Buzz Number? " + ob.isBuzzNumber(49));
        System.out.println("Is 175 a Disarium Number? " + ob.isDisariumNumber(175));
       // System.out.println("n th Tribonacci Number: " + ob.TribonacciNumber());
        System.out.println("Is 1729 a Magic Number? " + ob.isMagicNumber(1729));
        System.out.println("Is 18 an Abundant Number? " + ob.isAbundantNumber(18));
        System.out.println("Is 9 a Neon Number? " + ob.isNeonNumber(9));
        System.out.println("Is 153 an Armstrong Number? " + ob.isArmstrongNumber(153));
        System.out.println("Is 20 a Pronic Number? " + ob.isPronicNumber(20));
        System.out.println("Is 1729 a Harshad Number? " + ob.isHarshadNumber(1729));
        System.out.println("Is 1729 a Harshad-Magic Number? " + ob.HarshadMagicNumber(1729));
        System.out.println("Is 512 a Dudeney Number? " + ob.isDudeneyNumber(512));
        System.out.println("Is 24 a Niven Number? " + ob.isNivenNumber(24));
        System.out.println("Is 253 a Bouncy Number? " + ob.isBouncyNumber(253));
    }
}

class MyNumber {
    boolean isSpyNumber(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return sum == product;
    }

    boolean isDuckNumber(int n) {
        String str = String.valueOf(n);
        if (str.charAt(0) == '0') 
            return false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '0') 
                return true;
        }
        return false;
    }

    boolean isTechNumber(int n) {
        String str = String.valueOf(n);
        if (str.length() % 2 != 0) 
            return false;
        
        int halfLength = str.length() / 2;
        int firstHalf = Integer.parseInt(str.substring(0, halfLength));
        int secondHalf = Integer.parseInt(str.substring(halfLength));
        int sum = (firstHalf + secondHalf) * (firstHalf + secondHalf);

        return sum == n;
    }

    boolean isBuzzNumber(int n) {
        return (n % 7 == 0) || (n % 10 == 7);
    }

    boolean isDisariumNumber(int n) {
        int sum = 0, temp = n;
        int count = String.valueOf(n).length();
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, count--);
            temp /= 10;
        }
        return sum == n;
    }

    long TribonacciNumber(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        long a = 0, b = 1, c = 1, result = 0;
        for (int i = 3; i <= n; i++) {
            result = a + b + c;
            a = b;
            b = c;
            c = result;
        }
        return result;
    }

    boolean isMagicNumber(int num) {
        while (num >= 10) {
            int sumOfSquares = 0;
            while (num > 0) {
                int digit = num % 10;
                sumOfSquares += digit * digit;
                num /= 10;
            }
            num = sumOfSquares;
        }
        return (num == 1);
    }

    boolean isAbundantNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) 
                sum += i;
        }
        return sum > n;
    }

    boolean isNeonNumber(int n) {
        int square = n * n;
        int sum = 0;
        while (square > 0) {
            int digit = square % 10;
            sum += digit;
            square /= 10;
        }
        return n == sum;
    }

    boolean isArmstrongNumber(int n) {
        int sum = 0, temp = n;
        int count = String.valueOf(n).length();
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, count);
            temp /= 10;
        }
        return sum == n;
    }

    boolean isPronicNumber(int n) {
        int k = (int) Math.sqrt(n);
        return k * (k + 1) == n;
    }

    boolean isHarshadNumber(int n) {
        int sum = 0, temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        return n % sum == 0;
    }

    boolean HarshadMagicNumber(int n) {
        return isHarshadNumber(n) && isMagicNumber(n);
    }

    boolean isDudeneyNumber(int n) {
        int sum = 0, temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        int cubeRoot = (int) Math.cbrt(n);
        return sum == cubeRoot;
    }

    boolean isNivenNumber(int n) {
        return isHarshadNumber(n);
    }

    boolean isBouncyNumber(int n) {
        String str = String.valueOf(n);
        boolean hasIncreasing = false, hasDecreasing = false;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) < str.charAt(i + 1)) 
                hasIncreasing = true;
            else if (str.charAt(i) > str.charAt(i + 1)) 
                hasDecreasing = true;
        }
        return hasIncreasing && hasDecreasing;
    }
}