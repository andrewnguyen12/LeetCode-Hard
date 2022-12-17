import java.net.SocketOption;
import java.util.regex.Pattern;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean result = Pattern.matches(p,s);
        return result;
    }
}
