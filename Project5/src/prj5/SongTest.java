/**
 * SongTest Class
 */
package prj5;

/**
 * tests the methods of the song class
 * 
 * @author Camille Schmidt
 * @version november 18, 2019
 *
 */
public class SongTest extends student.TestCase {
    private Song song;


    /**
     * sets up for each test method to be run
     */
    public void setUp() {
        song = new Song("Hallelujah", "Panic! At The Disco", 2016, "rock");

    }


    /**
     * tests getName()
     */
    public void testGetName() {
        assertEquals("Hallelujah", song.getName());
    }


    /**
     * tests get artist
     */
    public void testGetArtist() {
        assertEquals("Panic! At The Disco", song.getArtist());
    }


    /**
     * tests get year released
     */
    public void testGetYearReleased() {
        assertEquals(2016, song.getYearReleased());
    }


    /**
     * tests the get genre method
     */
    public void testGetGenre() {
        assertEquals("rock", song.getGenre());
    }


    /**
     * tests the getHobby heard for READING
     */
    public void testGetHobbyHeard() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.ART);
        Student four = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.MUSIC);
        song.addHeard(one);
        song.addHeard(two);
        song.addHeard(three);
        song.addHeard(four);
        song.addHeard(five);
        assertEquals(2.0, song.getHobbyHeard(HobbyEnum.READING), 0.1);
        assertEquals(1.0, song.getHobbyHeard(HobbyEnum.SPORTS), 0.1);
        assertEquals(1.0, song.getHobbyHeard(HobbyEnum.MUSIC), 0.1);
        assertEquals(1.0, song.getHobbyHeard(HobbyEnum.ART), 0.1);
    }


    /**
     * tests the getHobby
     */
    public void testGetHobbyLikes() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.ART);
        Student four = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.MUSIC);
        song.addLikes(one);
        song.addLikes(two);
        song.addLikes(three);
        song.addLikes(four);
        song.addLikes(five);
        assertEquals(2.0, song.getHobbyLikes(HobbyEnum.READING), 0.1);
        assertEquals(1.0, song.getHobbyLikes(HobbyEnum.ART), 0.1);
        assertEquals(1.0, song.getHobbyLikes(HobbyEnum.SPORTS), 0.1);
        assertEquals(1.0, song.getHobbyLikes(HobbyEnum.MUSIC), 0.1);
    }


    /**
     * tests the get majorHeard
     * 
     */
    public void testGetMajorHeard() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.OTHER_ENGINEERING,
            StateEnum.SOUTHEAST, HobbyEnum.ART);
        Student four = new Student(MajorEnum.OTHER, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        song.addHeard(one);
        song.addHeard(two);
        song.addHeard(three);
        song.addHeard(four);
        song.addHeard(five);
        assertEquals(2, song.getMajorHeard(MajorEnum.COMPUTER_SCIENCE));
        assertEquals(1, song.getMajorHeard(MajorEnum.MATH_CMDA));
        assertEquals(1, song.getMajorHeard(MajorEnum.OTHER_ENGINEERING));
        assertEquals(1, song.getMajorHeard(MajorEnum.OTHER));

    }


    /**
     * tests get major likes
     */
    public void testGetMajorLikes() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.OTHER_ENGINEERING,
            StateEnum.SOUTHEAST, HobbyEnum.ART);
        Student four = new Student(MajorEnum.OTHER, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        song.addLikes(one);
        song.addLikes(two);
        song.addLikes(three);
        song.addLikes(four);
        song.addLikes(five);
        assertEquals(2, song.getMajorLikes(MajorEnum.COMPUTER_SCIENCE));
        assertEquals(1, song.getMajorLikes(MajorEnum.MATH_CMDA));
        assertEquals(1, song.getMajorLikes(MajorEnum.OTHER_ENGINEERING));
        assertEquals(1, song.getMajorLikes(MajorEnum.OTHER));
    }


    /**
     * tests get region heard
     */
    public void testGetRegionHeard() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.OTHER_ENGINEERING,
            StateEnum.OTHER_US, HobbyEnum.ART);
        Student four = new Student(MajorEnum.OTHER, StateEnum.OUTSIDE_US,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        song.addHeard(one);
        song.addHeard(two);
        song.addHeard(three);
        song.addHeard(four);
        song.addHeard(five);
        assertEquals(2, song.getRegionHeard(StateEnum.SOUTHEAST));
        assertEquals(1, song.getRegionHeard(StateEnum.OUTSIDE_US));
        assertEquals(1, song.getRegionHeard(StateEnum.NORTHEAST));
        assertEquals(1, song.getRegionHeard(StateEnum.OTHER_US));
    }


    /**
     * tests get region likes
     */
    public void testRegionLikes() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.OTHER_ENGINEERING,
            StateEnum.OTHER_US, HobbyEnum.ART);
        Student four = new Student(MajorEnum.OTHER, StateEnum.OUTSIDE_US,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        song.addLikes(one);
        song.addLikes(two);
        song.addLikes(three);
        song.addLikes(four);
        song.addLikes(five);
        assertEquals(2, song.getRegionLikes(StateEnum.SOUTHEAST));
        assertEquals(1, song.getRegionLikes(StateEnum.OUTSIDE_US));
        assertEquals(1, song.getRegionLikes(StateEnum.NORTHEAST));
        assertEquals(1, song.getRegionLikes(StateEnum.OTHER_US));

    }


    /**
     * tests equals for null
     */
    public void testEqualsNull() {
        Song nothing = null;
        assertFalse(song.equals(nothing));
    }


    /**
     * tests equals for a different object
     */
    public void testEqualsDiffObj() {
        String notASong = "this isn't a song";
        assertFalse(song.equals(notASong));
    }


    /**
     * tests equals for a song that doesn't equal the current song at all
     */
    public void testNotEqualAtAll() {
        Song red = new Song("Red", "Taylor Swift", 2012, "country");
        assertFalse(song.equals(red));
    }


    /**
     * tests when everything is equal
     */
    public void testAllEqual() {
        Song copy = new Song("Hallelujah", "Panic! At The Disco", 2016, "rock");
        assertTrue(song.equals(copy));
    }


    /**
     * tests same name conditions
     */
    public void testNameEquals() {
        Song tfff = new Song("Hallelujah", "Rufus Wainwright", 2001, "folk");
        Song tttf = new Song("Hallelujah", "Panic! At The Disco", 2016,
            "country");
        Song ttft = new Song("Hallelujah", "Panic! At The Disco", 2011, "rock");
        Song ttff = new Song("Hallelujah", "Panic! At The Disco", 2011,
            "country");
        Song tftt = new Song("Hallelujah", "Jesus", 2016, "rock");
        Song tftf = new Song("Hallelujah", "Jesus", 2016, "folk");
        Song tfft = new Song("Hallelujah", "Jesus", 2005, "rock");

        assertFalse(song.equals(tfff));
        assertFalse(song.equals(tttf));
        assertFalse(song.equals(ttft));
        assertFalse(song.equals(ttff));
        assertFalse(song.equals(tftf));
        assertFalse(song.equals(tftt));
        assertFalse(song.equals(tfft));

    }


    /**
     * tests different name conditions
     */
    public void testDifferentName() {
        Song fttt = new Song("Death Of A Bachelor", "Panic! At The Disco", 2016,
            "rock");
        Song fttf = new Song("Death Of A Bachelor", "Panic! At The Disco", 2016,
            "country");
        Song ftft = new Song("Death Of A Bachelor", "Panic! At The Disco", 2011,
            "rock");
        Song ftff = new Song("Death Of A Bachelor", "Panic! At The Disco", 2011,
            "country");
        Song fftt = new Song("Death Of A Bachelor", "Jesus", 2016, "rock");
        Song fftf = new Song("Death Of A Bachelor", "Jesus", 2016, "folk");
        Song ffft = new Song("Death Of A Bachelor", "Elvis", 2005, "rock");

        assertFalse(song.equals(fttt));
        assertFalse(song.equals(fttf));
        assertFalse(song.equals(ftft));
        assertFalse(song.equals(ftff));
        assertFalse(song.equals(fftt));
        assertFalse(song.equals(fftf));
        assertFalse(song.equals(ffft));

    }


    /**
     * tests when all likes and heards are 0
     */
    public void testNoLikesOrHeards() {
        assertEquals(0.0, song.getHobbyHeard(HobbyEnum.ART), 0.1);
        assertEquals(0.0, song.getHobbyHeard(HobbyEnum.SPORTS), 0.1);
        assertEquals(0.0, song.getHobbyHeard(HobbyEnum.MUSIC), 0.1);
        assertEquals(0.0, song.getHobbyHeard(HobbyEnum.READING), 0.1);
        assertEquals(0.0, song.getHobbyLikes(HobbyEnum.ART), 0.1);
        assertEquals(0.0, song.getHobbyLikes(HobbyEnum.SPORTS), 0.1);
        assertEquals(0.0, song.getHobbyLikes(HobbyEnum.MUSIC), 0.1);
        assertEquals(0.0, song.getHobbyLikes(HobbyEnum.READING), 0.1);

        assertEquals(0.0, song.getRegionHeard(StateEnum.NORTHEAST), 0.1);
        assertEquals(0.0, song.getRegionHeard(StateEnum.SOUTHEAST), 0.1);
        assertEquals(0.0, song.getRegionHeard(StateEnum.OUTSIDE_US), 0.1);
        assertEquals(0.0, song.getRegionHeard(StateEnum.OTHER_US), 0.1);
        assertEquals(0.0, song.getRegionLikes(StateEnum.NORTHEAST), 0.1);
        assertEquals(0.0, song.getRegionLikes(StateEnum.SOUTHEAST), 0.1);
        assertEquals(0.0, song.getRegionLikes(StateEnum.OUTSIDE_US), 0.1);
        assertEquals(0.0, song.getRegionLikes(StateEnum.OTHER_US), 0.1);

        assertEquals(0.0, song.getMajorHeard(MajorEnum.COMPUTER_SCIENCE), 0.1);
        assertEquals(0.0, song.getMajorHeard(MajorEnum.MATH_CMDA), 0.1);
        assertEquals(0.0, song.getMajorHeard(MajorEnum.OTHER_ENGINEERING), 0.1);
        assertEquals(0.0, song.getMajorHeard(MajorEnum.OTHER), 0.1);
        assertEquals(0.0, song.getMajorLikes(MajorEnum.COMPUTER_SCIENCE), 0.1);
        assertEquals(0.0, song.getMajorLikes(MajorEnum.MATH_CMDA), 0.1);
        assertEquals(0.0, song.getMajorLikes(MajorEnum.OTHER_ENGINEERING), 0.1);
        assertEquals(0.0, song.getMajorLikes(MajorEnum.OTHER), 0.1);

    }


    /**
     * tests when there's none of a certain major in a list
     */
    public void testNoHeardLikesMajor() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.ART);
        Student four = new Student(MajorEnum.OTHER, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        song.addLikes(one);
        song.addLikes(two);
        song.addLikes(three);
        song.addLikes(four);
        song.addLikes(five);
        song.addHeard(one);
        song.addHeard(two);
        song.addHeard(three);
        song.addHeard(four);
        song.addHeard(five);
        assertEquals(0, song.getMajorHeard(MajorEnum.OTHER_ENGINEERING));
        assertEquals(0, song.getMajorLikes(MajorEnum.OTHER_ENGINEERING));

    }


    /**
     * tests when there's none of a certain hobby in likes and heards
     */
    public void testNoHeardLikesHobby() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.READING);
        Student four = new Student(MajorEnum.OTHER, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        song.addLikes(one);
        song.addLikes(two);
        song.addLikes(three);
        song.addLikes(four);
        song.addLikes(five);
        song.addHeard(one);
        song.addHeard(two);
        song.addHeard(three);
        song.addHeard(four);
        song.addHeard(five);
        assertEquals(0.0, song.getHobbyHeard(HobbyEnum.ART), 0.1);
        assertEquals(0.0, song.getHobbyLikes(HobbyEnum.ART), 0.1);
    }


    /**
     * tests when there's none of a certain state in likes or heards
     */
    public void testNoHeardLikesState() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.READING);
        Student four = new Student(MajorEnum.OTHER, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.SOUTHEAST, HobbyEnum.MUSIC);
        song.addLikes(one);
        song.addLikes(two);
        song.addLikes(three);
        song.addLikes(four);
        song.addLikes(five);
        song.addHeard(one);
        song.addHeard(two);
        song.addHeard(three);
        song.addHeard(four);
        song.addHeard(five);
        assertEquals(0, song.getRegionHeard(StateEnum.OUTSIDE_US));
        assertEquals(0, song.getRegionLikes(StateEnum.OUTSIDE_US));
    }
    
    /**
     * Tests addNotLike method
     */
    public void testAddNotLikes() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.ART);
        Student four = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.MUSIC);
        assertEquals(song.getHobbyNotLikes(HobbyEnum.MUSIC), 0.0, 0.1);
        assertEquals(song.getMajorNotLikes(MajorEnum.MATH_CMDA), 0.0, 0.1);
        assertEquals(song.getRegionNotLikes(StateEnum.SOUTHEAST), 0.0, 0.1);
        song.addNotLikes(one);
        song.addNotLikes(two);
        song.addNotLikes(three);
        song.addNotLikes(four);
        song.addNotLikes(five);
        assertEquals(song.getHobbyNotLikes(HobbyEnum.MUSIC), 1.0, 0.1);
        assertEquals(song.getMajorNotLikes(MajorEnum.MATH_CMDA), 4.0, 0.1);
        assertEquals(song.getRegionNotLikes(StateEnum.SOUTHEAST), 4.0, 0.1);
    }
    
    /**
     * Tests addNotHeard method
     */
    public void testAddNotHeard() {
        Student one = new Student(MajorEnum.COMPUTER_SCIENCE,
            StateEnum.NORTHEAST, HobbyEnum.READING);
        Student two = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.READING);
        Student three = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.ART);
        Student four = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.SPORTS);
        Student five = new Student(MajorEnum.MATH_CMDA, StateEnum.SOUTHEAST,
            HobbyEnum.MUSIC);
        assertEquals(song.getHobbyNotLikes(HobbyEnum.MUSIC), 0.0, 0.1);
        assertEquals(song.getMajorNotLikes(MajorEnum.MATH_CMDA), 0.0, 0.1);
        assertEquals(song.getRegionNotLikes(StateEnum.SOUTHEAST), 0.0, 0.1);
        song.addNotHeard(one);
        song.addNotHeard(two);
        song.addNotHeard(three);
        song.addNotHeard(four);
        song.addNotHeard(five);
        assertEquals(song.getHobbyNotHeard(HobbyEnum.MUSIC), 1.0, 0.1);
        assertEquals(song.getMajorNotHeard(MajorEnum.MATH_CMDA), 4.0, 0.1);
        assertEquals(song.getRegionNotHeard(StateEnum.SOUTHEAST), 4.0, 0.1);
    }

}
