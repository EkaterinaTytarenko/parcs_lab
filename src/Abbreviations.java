import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parcs.*;

public class Abbreviations implements AM {

    public void run(AMInfo info){

        String text = (String) info.parent.readObject();

        Pattern abbPattern = Pattern.compile("[A-Z]+\\b" );
        Matcher matchStringA = abbPattern.matcher(text);

        List<String> results=new ArrayList<>();
        while (matchStringA.find()) {
            results.add(matchStringA.group());
        }

        info.parent.write((Serializable) results);
    }

}
