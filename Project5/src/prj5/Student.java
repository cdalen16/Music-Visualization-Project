/**
 * Student Class
 */
package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// --Gustavus de Andrade (gustavusd)

/**
 * a class that represents a student with a hobby and a list of liked and heard
 * songs
 * 
 * @author Gustavus de Andrade gustavusd
 * @version 11/17/2019
 *
 */
public class Student {

    private HobbyEnum hobby;
    private StateEnum region;
    private MajorEnum major;
    private DLList<Song> likedSongs;
    private DLList<Song> heardSongs;


    /**
     * Constructor for student
     * @param studentMajor - major of student
     * @param studentRegion - region of student
     * @param studentHobby - hobby of student
     */
    public Student(
        MajorEnum studentMajor,
        StateEnum studentRegion,
        HobbyEnum studentHobby) {
        hobby = studentHobby;
        region = studentRegion;
        major = studentMajor;
        likedSongs = new DLList<Song>();
        heardSongs = new DLList<Song>();
    }


    /**
     * determines if a student likes a song
     * 
     * @param song
     *            song to determine if the student likes
     */
    public void likesSong(Song song) {
        likedSongs.add(song);
    }


    /**
     * Determines if a student heard a song
     * 
     * @param song
     *            song to determine if the student has heard
     */
    public void heardSong(Song song) {
        heardSongs.add(song);
    }


    /**
     * gets the students major
     * 
     * @return enum representing major
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * returns the students hobby
     * 
     * @return enum representing major
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * returns students region
     * 
     * @return enum representing region
     */
    public StateEnum getRegion() {
        return region;
    }


    /**
     * gets liked songs
     * 
     * @return - DLList liked songs
     */
    public DLList<Song> getLikedSongs() {
        return likedSongs;
    }


    /**
     * gets heard songs
     * 
     * @return - DLList heard songs
     */
    public DLList<Song> getHeardSongs() {
        return heardSongs;
    }
}
