/**
 * StateEnum Enum
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
 * determines the region of the student 
 * @author Campbell Dalen (cdalen)
 * @version 11.18.19
 */
public enum StateEnum {

    NORTHEAST("Northeast"), 
    SOUTHEAST("Southeast"), 
    OTHER_US("United States (other than Southeast or Northwest)"), 
    OUTSIDE_US("Outside of United States");
 
    private String url;
 
    StateEnum(String envUrl) {
        this.url = envUrl;
    }
 
    public String getUrl() {
        return url;
    }
     
    //****** Reverse Lookup Implementation************//
 
    //Lookup table
    private static final Map<String, StateEnum> lookup = new HashMap<>();
  
    //Populate the lookup table on loading time
    static
    {
        for(StateEnum env : StateEnum.values())
        {
            lookup.put(env.getUrl(), env);
        }
    }
  
    //This method can be used for reverse lookup purpose
    public static StateEnum get(String url) 
    {
        return lookup.get(url);
    }
}
