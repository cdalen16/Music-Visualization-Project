/**
 * StudentTest Class
 */
package prj5;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//--Gustavus de Andrade (gustavusd)
import student.TestCase;

/**
 * Tests the methods in Student
 * 
 * @author Gustavus de Andrade gustavusd
 * @version 11/18/2019
 *
 */
public class StudentTest extends TestCase {

    private Student student;
    private Song song;


    /**
     * Sets up the tests
     */
    public void setUp() {
        student = new Student(MajorEnum.COMPUTER_SCIENCE, StateEnum.NORTHEAST,
            HobbyEnum.READING);
        song = new Song("Hello", "Adele", 2015, "Pop");
    }


    /**
     * Tests add likes
     */
    public void testLikesSong() {
        assertTrue(student.getLikedSongs().isEmpty());
        student.likesSong(song);
        assertEquals(student.getLikedSongs().size(), 1);
    }


    /**
     * Tests add heard
     */
    public void testHeardSong() {
        assertTrue(student.getHeardSongs().isEmpty());
        student.heardSong(song);
        assertEquals(student.getHeardSongs().size(), 1);
    }


    /**
     * Tests getMajor
     */
    public void testGetMajor() {
        assertTrue(student.getMajor().equals(MajorEnum.COMPUTER_SCIENCE));
    }


    /**
     * Tests getHobby
     */
    public void testGetHobby() {
        assertTrue(student.getHobby().equals(HobbyEnum.READING));
    }


    /**
     * Tests getMajor
     */
    public void testGetState() {
        assertTrue(student.getRegion().equals(StateEnum.NORTHEAST));
    }
}
