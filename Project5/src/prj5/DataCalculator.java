/**
 * DataCalculator Class
 */
package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- campbell dalen (cdalen)
// -- camille schmidt (camillekschmidt)

/**
 * sorts song lists into arrays from the data reader class
 * 
 * @author Campbell Dalen (cdalen)
 * @author camille schmidt (camillekschmidt)
 * @version 11.18.19
 */
public class DataCalculator {

    private DLList<Song> songList;
    private DLList<Student> studentList;


    /**
     * New DataCalulator
     * 
     * @param songs
     *            - list of songs
     * @param students
     *            - list of students
     */
    public DataCalculator(DLList<Song> songs, DLList<Student> students) {
        songList = songs;
        studentList = students;
    }


    /**
     * Sorts the data by genre
     * 
     * @return an array sorted alphabetically by song genre
     */
    public Object[] sortByGenre() {
        Object[] songArray = songList.toArray();
        Song temp;
        for (int i = 0; i < songArray.length; i++) {
            for (int j = i + 1; j < songArray.length; j++) {
                if (((Song)songArray[i]).getGenre().compareTo(
                    ((Song)songArray[j]).getGenre()) > 0) {
                    temp = (Song)songArray[i];
                    songArray[i] = songArray[j];
                    songArray[j] = temp;
                }
            }
        }
        return songArray;
    }


    /**
     * sorts song list by title
     * 
     * @return an array sorted alphabetically by song title
     */
    public Object[] sortByTitle() {
        Object[] songArray = songList.toArray();
        Song temp;
        for (int i = 0; i < songArray.length; i++) {
            for (int j = i + 1; j < songArray.length; j++) {
                if (((Song)songArray[i]).getName().compareTo(
                    ((Song)songArray[j]).getName()) > 0) {
                    temp = (Song)songArray[i];
                    songArray[i] = songArray[j];
                    songArray[j] = temp;
                }
            }
        }
        return songArray;
    }


    /**
     * Calculates the total number of students with certain hobby
     * 
     * @param hobby - hobby to check total for
     * @return double - number of students with hobby
     */
    public double totalHobby(HobbyEnum hobby) {
        int hobbyLikes = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getHobby().equals(hobby)) {
                hobbyLikes++;
            }
        }
        return hobbyLikes;
    }


    /**
     * Sorts the data by year
     * 
     * @return Object[] song array sorted by year released
     */
    public Object[] sortByYear() {
        Object[] songArray = songList.toArray();
        Song temp;
        for (int i = 0; i < songArray.length; i++) {
            for (int j = i + 1; j < songArray.length; j++) {
                if (((Song)songArray[i]).getYearReleased()
                    - (((Song)songArray[j]).getYearReleased()) > 0) {
                    temp = (Song)songArray[i];
                    songArray[i] = songArray[j];
                    songArray[j] = temp;
                }
            }
        }
        return songArray;
    }


    /**
     * Sorts the data by year
     * 
     * @return Object[] song array sorted by artist name
     */
    public Object[] sortByArtist() {
        Object[] songArray = songList.toArray();
        Song temp;
        for (int i = 0; i < songArray.length; i++) {
            for (int j = i + 1; j < songArray.length; j++) {
                if (((Song)songArray[i]).getArtist().compareTo(
                    ((Song)songArray[j]).getArtist()) > 0) {
                    temp = (Song)songArray[i];
                    songArray[i] = songArray[j];
                    songArray[j] = temp;
                }
            }
        }
        return songArray;
    }
}
