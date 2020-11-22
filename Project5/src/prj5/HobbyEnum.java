/**
 * HobbyEnum Enum
 */
package prj5;
//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- campbell dalen (cdalen)

import java.util.HashMap;
import java.util.Map;

/**
 * determines the hobby of the student
 * 
 * @author Campbell Dalen
 * @version 11.18.19
 */
public enum HobbyEnum {

    SPORTS("sports"), MUSIC("music"), ART("art"), READING("reading");

    private String url;


    HobbyEnum(String envUrl) {
        this.url = envUrl;
    }


    public String getUrl() {
        return url;
    }

    // ****** Reverse Lookup Implementation************//

    // Lookup table
    private static final Map<String, HobbyEnum> lookup = new HashMap<>();

    // Populate the lookup table on loading time
    static {
        for (HobbyEnum env : HobbyEnum.values()) {
            lookup.put(env.getUrl(), env);
        }
    }


    // This method can be used for reverse lookup purpose
    public static HobbyEnum get(String url) {
        return lookup.get(url);
    }
}
