package practice;

/**
 * Created by ayokota on 8/22/20.
 */
public class Atoi {
    public int myAtoi(String str) {
        int num = 0;
        int sign = 1;
        boolean hasPositiveSign = false;

        int i = 0;
        for(; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isDigit(c))
                break;
            else if(c == ' ')
                continue;
            else if(c == '-') {
                sign = -1;
                i++;
                break;
            }
            else if(c == '+') {
                i++;
                break;
            } else if(!Character.isDigit(c)) {
                return 0;
            }
        }

        for(; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!Character.isDigit(c)) {
                break;
            } else {
                int digit = c - '0';


                if(num != 0) {

                    if(sign == 1 && Integer.MAX_VALUE / num < 10)
                        return Integer.MAX_VALUE;
                    else if(sign == -1 && num != -1 && Integer.MIN_VALUE / num < 10)
                        return Integer.MIN_VALUE;
                }

                num *= 10;
                num += (sign * digit);
                if(sign == 1 && num < 0)
                    return Integer.MAX_VALUE;
                else if(sign == -1 && num > 0)
                    return Integer.MIN_VALUE;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Atoi().myAtoi("-123"));
    }

}
