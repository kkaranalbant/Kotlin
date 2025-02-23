import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {

    public static void main(String[] args) {

    }

    public void generate(String s, int n, List<String> result) {
        boolean reachedRight = reached(s, n, ')');
        boolean reachedLeft = reached(s, n, '(');
        if (!reachedRight && !reachedLeft) {
            generate(s + "(", n, result);
        }
        if (!reachedRight) {
            generate(s + ")", n, result);
        }
        if (reachedLeft && reachedRight && isValid(s)) {
            result.add(s);
        }
    }

    private boolean reached(String s, int n, char character) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == character) counter++;
        }
        return counter == n;
    }

    private boolean isValid (String s) {
        if (s.startsWith(")") || s.endsWith(")")) return false ;
        Map<Integer,Boolean> map = new HashMap<>() ;
        for (int i = 0; i <s.length(); i++) {
            map.put(i,false);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i-1 >= 0 && s.charAt(i-1) == '(') {
                map.put(i,true);
                map.put(i-1,true);
            }
        }
        for(Boolean value : map.values()) {
            if (!value) return false ;
        }
        return true ;
    }

}
