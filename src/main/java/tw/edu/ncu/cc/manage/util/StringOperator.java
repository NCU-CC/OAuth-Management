package tw.edu.ncu.cc.manage.util;

import org.apache.commons.lang3.StringUtils;


public class StringOperator {
    public static String getEncodeString(String input){
        return StringUtils.replaceEach(input, new String[]{"&", "\"", "<", ">"}, new String[]{"&amp;", "&quot;", "&lt;", "&gt;"});
    }
}
