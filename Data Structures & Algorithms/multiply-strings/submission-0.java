public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i1 = 0; i1 < num1.length(); i1++) {
            for (int i2 = 0; i2 < num2.length(); i2++) {
                int digit = (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0');
                res[i1 + i2] += digit;
                res[i1 + i2 + 1] += res[i1 + i2] / 10;
                res[i1 + i2] %= 10;
            }
        }

        StringBuilder result = new StringBuilder();
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        while (i >= 0) {
            result.append(res[i--]);
        }
        return result.toString();
    }
}
