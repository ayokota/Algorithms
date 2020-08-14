package practice;

/**
 * Created by ayokota on 8/13/20.
 */
public class solveEquation {
    public static String solveEquation(String equation) {
        String[] segments = equation.split("=");
        String p1 = segments[0];
        String p2 = segments[1];

        int[] a = simplify(p1);
        int[] b = simplify(p2);

        System.out.println(a[0] + ":" + b[0]);
        System.out.println(a[1] + ":" + b[1]);

        if(a[0] == b[0] && b[1] != a[1]) {
            return "x=0";
        }
        else if(b[1] == a[1] && b[0] == a[0])
            return "Infinite solutions";
        else if(b[1] == a[1])
            return "No solution";

        StringBuilder result = new StringBuilder();

        //print x
        int numX = a[1] - b[1];
        int sign = numX > 0 ? 1 : -1;
        numX = Math.abs(numX);
        if(numX > 1)
            result.append(numX);
        result.append("x");

        result.append("=");

        int diff = a[0] - b[0];
        if(diff < 0)
            sign *= -1;
        result.append(Math.abs(diff));

        return result.toString();
    }

    //[0] == number, [1] == number of x
    public static int[] simplify(String equation) {
        int num = 0;
        int x = 0;

        int sign = 1;
        for(int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if(Character.isDigit(c)) {
                int sum = c - '0';
                while(i + 1 < equation.length() && Character.isDigit(equation.charAt(i + 1)) ) {
                    char newc = equation.charAt(i + 1);

                    sum = sum * 10 + (equation.charAt(i + 1) - '0');
                    i++;
                }
                if(i + 1 < equation.length() && equation.charAt(i + 1) == 'x') {
                    x += sign * sum;
                    i++;
                } else {
                    num += sign * sum;
                }
            }
            else if(c == '+')
                sign = 1;
            else if(c == '-')
                sign = -1;
            else if(c == 'x' )
                x += sign * 1;
        }
        return new int[]{num, x};
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("2x+3x-6x=x+2"));
    }
}
