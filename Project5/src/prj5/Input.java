/**
 * Input Class
 */
package prj5;

import java.io.FileNotFoundException;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- camille k schmidt (camillekschmidt)
// -- campbell dalen (cdalen)
// --Gustavus de Andrade (gustavusd)

/**
 * runs the music simulator
 * 
 * @author Camille Schmidt (camillekschmidt)
 * @author campbell dalen (cdalen)
 * @version december 3, 2019
 *
 */
public class Input {

    /**
     * runs the program
     * 
     * @param args
     *            the string array of the song name values a user can input
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            DataReader reader = new DataReader("MusicSurveyData2019F.csv",
                "SongList2019F.csv");
        }
        else {
            DataReader reader = new DataReader(args[0], args[1]);
        }

    }
}
