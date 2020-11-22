/**
 * Song Class
 */
package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- campbell dalen (cdalen)
// -- camille schmidt (camillekschmidt)
// --Gustavus de Andrade (gustavusd)

/**
 * This class creates a song object
 * 
 * @author Gustavus de Andrade gustavusd
 * @author Camille Kathleen Schmidt camillekschmidt
 * @author Campbell Dalen (cdalen)
 * @version 11/17/2019
 *
 */
public class Song {

    private String name;
    private String artist;
    private String genre;
    private int yearReleased;

    private DLList<Student> studentLikes;
    private DLList<Student> studentHeard;
    private DLList<Student> studentNotHeard;
    private DLList<Student> studentNotLikes;


    /**
     * New Song object
     * 
     * @param songName
     *            - name of song
     * @param songArtist
     *            - artist of song
     * @param releaseDate
     *            - year released
     * @param songGenre
     *            - genre of song
     */
    public Song(
        String songName,
        String songArtist,
        int releaseDate,
        String songGenre) {
        name = songName;
        artist = songArtist;
        genre = songGenre;
        yearReleased = releaseDate;
        studentLikes = new DLList<Student>();
        studentHeard = new DLList<Student>();
        studentNotLikes = new DLList<Student>();
        studentNotHeard = new DLList<Student>();
    }


    /**
     * Adds a like to the total like count and one of the each category
     * of likes
     * 
     * Adding a get method for iterator which is the same as remove
     * but doesnt remove the element
     * 
     * @param student
     *            - student to add to list
     */
    public void addLikes(Student student) {
        studentLikes.add(student);
    }


    /**
     * Adds a heard to the total heard count and one of the each category
     * of likes
     * 
     * Adding a get method for iterator which is the same as remove
     * but doesnt remove the element
     * 
     * @param student
     *            - student to add to list
     */
    public void addHeard(Student student) {
        studentHeard.add(student);
    }


    /**
     * Adds a heard to the total heard count and one of the each category
     * of likes
     * 
     * Adding a get method for iterator which is the same as remove
     * but doesnt remove the element
     * 
     * @param student
     *            - student to add to list
     */
    public void addNotHeard(Student student) {
        studentNotHeard.add(student);
    }


    /**
     * Adds a heard to the total heard count and one of the each category
     * of likes
     * 
     * Adding a get method for iterator which is the same as remove
     * but doesnt remove the element
     * 
     * @param student
     *            - student to add to list
     */
    public void addNotLikes(Student student) {
        studentNotLikes.add(student);
    }


    /**
     * gets the likes for a song of people with that hobby
     * 
     * @param hobby
     *            the hobby you want to find likes for
     * @return number of people who liked a song with that hobby
     */
    public double getHobbyLikes(HobbyEnum hobby) {
        int hobbyLikes = 0;
        for (int i = 0; i < studentLikes.size(); i++) {
            if (studentLikes.get(i).getHobby().equals(hobby)) {
                hobbyLikes++;
            }
        }
        return hobbyLikes;
    }


    /**
     * gets the hears for a song of people with that hobby
     * 
     * @param hobby
     *            the hobby you want to find hears for
     * @return the number of people who heard that song with that hobby
     */
    public double getHobbyHeard(HobbyEnum hobby) {
        int hobbyHeard = 0;
        for (int i = 0; i < studentHeard.size(); i++) {
            if (studentHeard.get(i).getHobby().equals(hobby)) {
                hobbyHeard++;
            }
        }
        return hobbyHeard;
    }


    /**
     * gets the hears for a song of people with that hobby
     * 
     * @param hobby
     *            - major to be tested
     * @return int - number of students that heard song with hobby
     */
    public double getHobbyNotHeard(HobbyEnum hobby) {
        int hobbyNotHeard = 0;
        for (int i = 0; i < studentNotHeard.size(); i++) {
            if (studentNotHeard.get(i).getHobby() == hobby) {
                hobbyNotHeard++;
            }
        }
        return hobbyNotHeard;
    }


    /**
     * gets the hears for a song of people with that hobby
     * 
     * @param hobby
     *            - hobby to be tested
     * @return int - number of students that heard song with hobby
     */
    public double getHobbyNotLikes(HobbyEnum hobby) {
        int hobbyNotLikes = 0;
        for (int i = 0; i < studentNotLikes.size(); i++) {
            if (studentNotLikes.get(i).getHobby() == hobby) {
                hobbyNotLikes++;
            }
        }
        return hobbyNotLikes;
    }


    /**
     * Getter for the song name
     * 
     * @return String - name of song
     */
    public String getName() {
        return name;
    }


    /**
     * Getter for artist name
     * 
     * @return String - name of artist
     */
    public String getArtist() {
        return artist;
    }


    /**
     * Getter for genre
     * 
     * @return String - genre of song
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Getter for the year released
     * 
     * @return int - year released
     */
    public int getYearReleased() {
        return yearReleased;
    }


    /**
     * Equals method for song
     * 
     * @param obj
     *            - obj to compare to
     * @return bool - true if equal, false if not
     */
    public boolean equals(Object obj) {
        if ((obj == null) || (this.getClass() != obj.getClass())) {
            return false;
        }
        else {
            Song other = (Song)obj;
            if ((name.equals(other.getName()) && (artist.equals(other
                .getArtist())) && (genre.equals(other.getGenre())))
                && (yearReleased == other.getYearReleased())) {
                return true;
            }
        }

        return false;

    }


    /**
     * gets the likes for a song of people with that region
     * 
     * @param state
     *            the region you want to find likes for
     * @return number of people who liked a song with that region
     */
    public int getRegionLikes(StateEnum state) {
        int regionLikes = 0;
        for (int i = 0; i < studentLikes.size(); i++) {
            if (studentLikes.get(i).getRegion() == state) {
                regionLikes++;
            }
        }
        return regionLikes;
    }


    /**
     * gets the hears for a song of people with that state
     * 
     * @param state
     *            the region you want to find hears for
     * @return the number of people who heard that song with that region
     */
    public int getRegionHeard(StateEnum state) {
        int regionHeard = 0;
        for (int i = 0; i < studentHeard.size(); i++) {
            if (studentHeard.get(i).getRegion() == state) {
                regionHeard++;
            }
        }
        return regionHeard;
    }
    
    /**
     * gets the hears for a song of people with that Region
     * 
     * @param region
     *            - major to be tested
     * @return int - number of students that heard song with Region
     */
    public double getRegionNotHeard(StateEnum region) {
        int regionNotHeard = 0;
        for (int i = 0; i < studentNotHeard.size(); i++) {
            if (studentNotHeard.get(i).getRegion() == region) {
                regionNotHeard++;
            }
        }
        return regionNotHeard;
    }


    /**
     * gets the hears for a song of people with that Region
     * 
     * @param region
     *            - Region to be tested
     * @return int - number of students that heard song with Region
     */
    public double getRegionNotLikes(StateEnum region) {
        int regionNotLikes = 0;
        for (int i = 0; i < studentNotLikes.size(); i++) {
            if (studentNotLikes.get(i).getRegion() == region) {
                regionNotLikes++;
            }
        }
        return regionNotLikes;
    }


    /**
     * gets the likes for a song of people with that major
     * 
     * @param major
     *            - major to be checked
     * @return int - number of people in major that heard song
     */
    public int getMajorLikes(MajorEnum major) {
        int majorLikes = 0;
        for (int i = 0; i < studentLikes.size(); i++) {
            if (studentLikes.get(i).getMajor() == major) {
                majorLikes++;
            }
        }
        return majorLikes;
    }


    /**
     * gets the hears for a song of people with that hobby
     * 
     * @param major
     *            - major to be tested
     * @return int - number of students that heard song with major
     */
    public int getMajorHeard(MajorEnum major) {
        int majorHeard = 0;
        for (int i = 0; i < studentHeard.size(); i++) {
            if (studentHeard.get(i).getMajor() == major) {
                majorHeard++;
            }
        }
        return majorHeard;
    }
    
    /**
     * gets the hears for a song of people with that Major
     * 
     * @param major
     *            - major to be tested
     * @return int - number of students that heard song with Major
     */
    public double getMajorNotHeard(MajorEnum major) {
        int majorNotHeard = 0;
        for (int i = 0; i < studentNotHeard.size(); i++) {
            if (studentNotHeard.get(i).getMajor() == major) {
                majorNotHeard++;
            }
        }
        return majorNotHeard;
    }


    /**
     * gets the hears for a song of people with that Major
     * 
     * @param major
     *            - Major to be tested
     * @return int - number of students that heard song with Major
     */
    public double getMajorNotLikes(MajorEnum major) {
        int majorNotLikes = 0;
        for (int i = 0; i < studentNotLikes.size(); i++) {
            if (studentNotLikes.get(i).getMajor() == major) {
                majorNotLikes++;
            }
        }
        return majorNotLikes;
    }


}
