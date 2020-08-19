package practice;

/**
 * Created by ayokota on 8/16/20.
 */
public class decodeString {
    public String decodeString(String s) {
        return decodeString(s, 0, 1);
    }

    public String decodeString(String s, Integer idx, int factor) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < factor; i++) {
            for(Integer j = idx; j < s.length(); j++) {
                char c = s.charAt(j);
                if(Character.isDigit(c)) {
                    // get the correct multi factor
                    int multiFactor = c - '0';
                    while(Character.isDigit(s.charAt(j + 1))) {
                        multiFactor *= 10;
                        multiFactor += s.charAt(j + 1) - '0';
                        j++;
                    }

                    j += 2;
                    String substr = decodeString(s, j, multiFactor);
                    result.append(substr);

                    int lvl = 0;
                    while(!(s.charAt(j) == ']' && lvl == 0)) {
                        if(s.charAt(j) == '[')
                            lvl++;
                        else if (s.charAt(j) == ']')
                            lvl--;
                        j++;
                    }

                } else if(c == ']') {
                    break;
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new decodeString().decodeString("3[a]2[b4[F]c]"));
    }
}
