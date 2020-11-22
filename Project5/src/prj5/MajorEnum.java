/**
 * MajorEnum Enum
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
 * enums to represent different possible majors
 * 
 * @author Campbell Dalen
 * @version 11.18.19
 */
public enum MajorEnum {
    /**
     * math or CMDA major
     */
    MATH_CMDA("Math or CMDA"),
    /**
     * computer science major
     */
    COMPUTER_SCIENCE("Computer Science"),
    /**
     * other engineering major
     */
    OTHER_ENGINEERING("Other Engineering"),
    /**
     * other major
     */
    OTHER("Other");

    private String url;


    MajorEnum(String envUrl) {
        this.url = envUrl;
    }


    /**
     * returns URL of enum
     * 
     * @return url of enum
     */
    public String getUrl() {
        return url;
    }

    // ****** Reverse Lookup Implementation************//

    // Lookup table
    private static final Map<String, MajorEnum> lookup = new HashMap<>();

    // Populate the lookup table on loading time
    static {
        for (MajorEnum env : MajorEnum.values()) {
            lookup.put(env.getUrl(), env);
        }
    }


    // This method can be used for reverse lookup purpose
    /**
     * looks up the enum for the given url
     * 
     * @param url
     *            the url you want the enum for
     * @return the major enum it represents
     */
    public static MajorEnum get(String url) {
        return lookup.get(url);
    }
}
