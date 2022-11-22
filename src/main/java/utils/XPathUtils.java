package utils;

import java.util.Formatter;

public class XPathUtils {

    public static String formatSearch(String xpath, Object... args) {
        xpath = "." + xpath.replace("|", "|.");
        return new Formatter().format(xpath, args).toString();
    }
}
