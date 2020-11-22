/**
 * DataCalculatorTest Class
 */
package prj5;

import java.util.Arrays;
import student.TestCase;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- camille schmidt (camillekschmidt)

/**
 * tests the methods of the data calculator class
 * 
 * @author Camille Schmidt (camillekschmidt)
 * @version december 3, 2019
 *
 */
public class DataCalculatorTest extends TestCase {
    private DataCalculator calculator;
    private DLList<Song> songList;
    private DLList<Student> studentList;


    /**
     * sets up for each test method to be run
     */
    public void setUp() {
        Song creep = new Song("Creep", "Radiohead", 1992, "Alternative");
        Song allOfMe = new Song("All of Me", "John Legend", 2013, "R&B");
        Song myHeart = new Song("My Heart Will Go On", "Celine Dion", 1997,
            "Pop");

        Student one = new Student(MajorEnum.MATH_CMDA, StateEnum.NORTHEAST,
            HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.OTHER_US,
            HobbyEnum.SPORTS);
        Student three = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        songList = new DLList<Song>();
        songList.add(creep);
        songList.add(allOfMe);
        songList.add(myHeart);
        studentList = new DLList<Student>();
        studentList.add(one);
        studentList.add(two);
        studentList.add(three);

        calculator = new DataCalculator(songList, studentList);
    }


    /**
     * tests the sort by genre method
     */
    public void testSortByGenre() {
        Object[] genre = new Object[3];
        genre[0] = new Song("Creep", "Radiohead", 1992, "Alternative");
        genre[1] = new Song("My Heart Will Go On", "Celine Dion", 1997, "Pop");
        genre[2] = new Song("All of Me", "John Legend", 2013, "R&B");
        assertTrue(Arrays.deepEquals(genre, calculator.sortByGenre()));
    }


    /**
     * tests the sort by title method
     */
    public void testSortByTitle() {
        Object[] title = new Object[3];
        title[0] = new Song("All of Me", "John Legend", 2013, "R&B");
        title[1] = new Song("Creep", "Radiohead", 1992, "Alternative");
        title[2] = new Song("My Heart Will Go On", "Celine Dion", 1997, "Pop");

        assertTrue(Arrays.deepEquals(title, calculator.sortByTitle()));
    }


    /**
     * tests the sort by year method
     */
    public void testSortByYear() {
        Object[] year = new Object[3];
        year[2] = new Song("All of Me", "John Legend", 2013, "R&B");
        year[0] = new Song("Creep", "Radiohead", 1992, "Alternative");
        year[1] = new Song("My Heart Will Go On", "Celine Dion", 1997, "Pop");

        assertTrue(Arrays.deepEquals(year, calculator.sortByYear()));
    }


    /**
     * tests the sort by artist name method
     */
    public void testSortByArtist() {
        Object[] artist = new Object[3];
        artist[1] = new Song("All of Me", "John Legend", 2013, "R&B");
        artist[2] = new Song("Creep", "Radiohead", 1992, "Alternative");
        artist[0] = new Song("My Heart Will Go On", "Celine Dion", 1997, "Pop");

        assertTrue(Arrays.deepEquals(artist, calculator.sortByArtist()));
    }


    /**
     * tests the total hobby method
     */
    public void testTotalHobby() {
        assertEquals(1.0, calculator.totalHobby(HobbyEnum.READING), 0.1);
        assertEquals(1.0, calculator.totalHobby(HobbyEnum.SPORTS), 0.1);
        assertEquals(1.0, calculator.totalHobby(HobbyEnum.MUSIC), 0.1);
        assertEquals(0.0, calculator.totalHobby(HobbyEnum.ART), 0.1);
    }


    /**
     * tests when the array is already in order
     */
    public void testAlreadyInOrder() {
        Song creep = new Song("Creep", "Radiohead", 1992, "Alternative");
        Song allOfMe = new Song("All of Me", "John Legend", 2013, "R&B");
        Song myHeart = new Song("My Heart Will Go On", "Celine Dion", 1997,
            "Pop");

        Student one = new Student(MajorEnum.MATH_CMDA, StateEnum.NORTHEAST,
            HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.OTHER_US,
            HobbyEnum.SPORTS);
        Student three = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        songList = new DLList<Song>();
        songList.add(myHeart);
        songList.add(allOfMe);
        songList.add(creep);
        studentList = new DLList<Student>();
        studentList.add(one);
        studentList.add(two);
        studentList.add(three);
        Object[] artist = new Object[3];
        artist[1] = new Song("All of Me", "John Legend", 2013, "R&B");
        artist[2] = new Song("Creep", "Radiohead", 1992, "Alternative");
        artist[0] = new Song("My Heart Will Go On", "Celine Dion", 1997, "Pop");
        calculator = new DataCalculator(songList, studentList);

        assertTrue(Arrays.deepEquals(artist, calculator.sortByArtist()));
    }

}
