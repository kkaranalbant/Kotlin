//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        "asddsa"

        "asdxsa"
    }


    public static String longestPalindromicSubstring(String s) {
        int maxLength = 1;
        int start = 0;
        int finish = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j + 1 <= 3 || dp[j + 1][i - 1])) {
                    dp[j][i] = true ;
                    if (i-j+1 > maxLength) {
                        maxLength = i-j+1 ;
                        start = j ;
                        finish = i ;
                    }
                }
            }
        }

        return s.substring(start,finish+1) ;

    }


}