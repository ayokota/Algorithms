package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayokota on 8/12/20.
 */
public class Validate_Equation {

    public boolean validateEquation(String equation) {
        equation.replaceAll(" ", "");
        String[] equas = equation.split("=");

        String equa1 = equas[0];
        String equa2 = equas[1];

//        Map<Character, Integer> charCount1 =

        return true;
    }

    public Map<Character, Integer> countChars(String equation) {
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if(c == '-') {

            } else if(c == '+') {

            } else {
                charCount.put(c, 0);
            }
        }

        return charCount;
    }

    public String normalize(String equation, boolean negative, Integer i) {
        StringBuilder result = new StringBuilder();

        for(; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if(c == '-' && negative) {
                result.append("+");
            } else if(c == '+' && negative) {
                result.append("-");
            } else if(c == '(') {
                result.append(normalize(equation, !negative, ++i));
            } else if(c == ')') {
                return result.toString();
            } else {
                
                result.append(c);
            }
        }

        return result.toString();
    }



    public static void main(String[] args) {
        Validate_Equation ve = new Validate_Equation();

        System.out.println(ve.validateEquation("A + ((B) + (C)) = ((B + C) + A)"));
        System.out.println(ve.validateEquation("A - (B + C) = -B + (A - C)"));
        System.out.println(ve.validateEquation("A - (B + C) = B + (A - C)"));


//        System.out.println(ve.normalize("-B+(A-C)", false));
//        System.out.println(ve.normalize("A-(B+C-(D+E-F))", false));
        System.out.println(ve.normalize("A+((B)+(C))", false, 0));

    }
}
