/**
 * GUIProjectWindow Class
 */
package prj5;

import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;
import java.util.Arrays;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- campbell dalen (cdalen)
// -- camille schmidt (camillekschmidt)
// --Gustavus de Andrade (gustavusd)

/**
 * creates a window to display data
 * 
 * @author Camille Schmidt
 * @author Campbell Dalen (cdalen)
 * @version november 18 2019
 *
 */
public class GUIProjectWindow {
    private Window window;
    private Button artistSort;
    private Button titleSort;
    private Button yearSort;
    private Button genreSort;
    private Button next;
    private Button prev;
    private Button representHobby;
    private Button representMajor;
    private Button representRegion;
    private Button quit;
    private Shape legend;
    private DataCalculator calculator;
    private TextShape criteria1;
    private TextShape criteria2;
    private TextShape criteria3;
    private TextShape criteria4;
    private TextShape legendTitle;
    private Object[] currentArray;
    private int pageNum = 1;
    private int pageMax = 0;
    private String sort = "";


    /**
     * creates a new GUI project window object
     * 
     * @param calc
     *            the data calculator to get the information from
     */
    public GUIProjectWindow(DataCalculator calc) {
        calculator = calc;
        window = new Window();
        window.setSize(1000, 600);
        window.setTitle("camillekschmidt cdalen gustavusd");

        prev = new Button("Prev");
        window.addButton(prev, WindowSide.NORTH);
        prev.onClick(this, "clickedPrev");

        artistSort = new Button("Sort By Artist Name");
        window.addButton(artistSort, WindowSide.NORTH);
        artistSort.onClick(this, "clickedArtistSort");

        titleSort = new Button("Sort By Song Title");
        window.addButton(titleSort, WindowSide.NORTH);
        titleSort.onClick(this, "clickedTitleSort");

        yearSort = new Button("Sort By Release Year");
        window.addButton(yearSort, WindowSide.NORTH);
        yearSort.onClick(this, "clickedYearSort");

        genreSort = new Button("Sort By Genre");
        window.addButton(genreSort, WindowSide.NORTH);
        genreSort.onClick(this, "clickedGenreSort");

        next = new Button("Next");
        window.addButton(next, WindowSide.NORTH);
        next.onClick(this, "clickedNext");

        representHobby = new Button("Represent Hobby");
        window.addButton(representHobby, WindowSide.SOUTH);
        representHobby.onClick(this, "clickedRepHobby");

        representMajor = new Button("Represent Major");
        window.addButton(representMajor, WindowSide.SOUTH);
        representMajor.onClick(this, "clickedRepMajor");

        representRegion = new Button("Represent Region");
        window.addButton(representRegion, WindowSide.SOUTH);
        representRegion.onClick(this, "clickedRepRegion");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.SOUTH);
        quit.onClick(this, "clickedQuit");

        legend = new Shape(825, 300, 200, 300);
        legend.setBackgroundColor(Color.WHITE);
        legend.setForegroundColor(Color.BLACK);

        if (pageNum == 1) {
            prev.disable();
        }

    }


    /**
     * creates the legend in the bottom righthand corner
     */
    public void createLegend() {

        TextShape songTitle = new TextShape(840, 400, "Song Title",
            Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);

        TextShape heard = new TextShape(legendTitle.getX(), songTitle.getY()
            + songTitle.getHeight() + 10, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);

        Shape bar = new Shape(heard.getX() + heard.getWidth() + 20, heard
            .getY(), 3, 30, Color.BLACK);

        TextShape likes = new TextShape(bar.getX() + 10, heard.getY(), "Likes",
            Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);

        window.addShape(legendTitle);
        window.addShape(criteria1);
        window.addShape(criteria2);
        window.addShape(criteria3);
        window.addShape(criteria4);

        window.addShape(songTitle);
        window.addShape(heard);
        window.addShape(bar);
        window.addShape(likes);
        window.addShape(legend);

    }


    /**
     * determines if previous has been selected
     * 
     * @param buttonIN
     *            the button pressed
     */
    public void clickedPrev(Button buttonIN) {
        window.removeAllShapes();
        pageNum = pageNum - 1;
        if (Arrays.deepEquals(currentArray, calculator.sortByTitle())) {
            displayTitles(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByArtist())) {
            displayArtists(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByGenre())) {
            displayGenres(pageNum);
        }
        else {
            displayYears(pageNum);
        }
        if (pageNum < pageMax) {
            next.enable();
        }
        if (pageNum == 1) {
            prev.disable();
        }

        if (sort == "region") {
            updateBarsRegion(pageNum);
        }
        else if (sort == "hobby") {
            updateBarsHobby(pageNum);
        }
        else if (sort == "major") {
            updateBarsMajor(pageNum);
        }
    }


    /**
     * determines if next has been selected
     * 
     * @param buttonIN
     *            the button pressed
     */
    public void clickedNext(Button buttonIN) {
        window.removeAllShapes();
        pageNum = pageNum + 1;
        if (Arrays.deepEquals(currentArray, calculator.sortByTitle())) {
            displayTitles(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByArtist())) {
            displayArtists(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByGenre())) {
            displayGenres(pageNum);
        }
        else {
            displayYears(pageNum);
        }
        if (pageNum > 0) {
            prev.enable();
        }
        if (pageMax == pageNum) {
            next.disable();
        }

        if (sort == "region") {
            updateBarsRegion(pageNum);
        }
        else if (sort == "hobby") {
            updateBarsHobby(pageNum);
        }
        else if (sort == "major") {
            updateBarsMajor(pageNum);
        }
    }


    /**
     * closes the window
     * 
     * @param buttonIN
     *            the button that was clicked
     */
    public void clickedQuit(Button buttonIN) {
        System.exit(0);

    }


    /**
     * determines if artist sort is selected and sorts by artist
     * 
     * @param buttonIN
     *            the button pressed
     */
    public void clickedArtistSort(Button buttonIN) {
        window.removeAllShapes();
        pageNum = 1;
        prev.disable();
        next.enable();
        displayArtists(pageNum);
        if (sort == "region") {
            updateBarsRegion(pageNum);
        }
        else if (sort == "hobby") {
            updateBarsHobby(pageNum);
        }
        else if (sort == "major") {
            updateBarsMajor(pageNum);
        }
    }


    /**
     * determines if title sort is selected and sorts by title
     * 
     * @param buttonIN
     *            button pressed
     */
    public void clickedTitleSort(Button buttonIN) {
        window.removeAllShapes();
        pageNum = 1;
        prev.disable();
        next.enable();
        displayTitles(pageNum);
        if (sort == "region") {
            updateBarsRegion(pageNum);
        }
        else if (sort == "hobby") {
            updateBarsHobby(pageNum);
        }
        else if (sort == "major") {
            updateBarsMajor(pageNum);
        }
    }


    /**
     * determines if year sort is selected and sorts by year
     * 
     * @param buttonIN
     *            button pressed
     */
    public void clickedYearSort(Button buttonIN) {
        window.removeAllShapes();
        pageNum = 1;
        prev.disable();
        next.enable();
        displayYears(pageNum);
        if (sort == "region") {
            updateBarsRegion(pageNum);
        }
        else if (sort == "hobby") {
            updateBarsHobby(pageNum);
        }
        else if (sort == "major") {
            updateBarsMajor(pageNum);
        }
    }


    /**
     * determines if genre sort has been selected and sorts by genre
     * 
     * @param buttonIN
     *            button pressed
     */
    public void clickedGenreSort(Button buttonIN) {
        window.removeAllShapes();
        pageNum = 1;
        prev.disable();
        next.enable();
        displayGenres(pageNum);
        if (sort == "region") {
            updateBarsRegion(pageNum);
        }
        else if (sort == "hobby") {
            updateBarsHobby(pageNum);
        }
        else if (sort == "major") {
            updateBarsMajor(pageNum);
        }

    }


    /**
     * sorts songs by people who like a song who have a certain hobby
     * 
     * @param buttonIN
     *            the button pressed
     */
    public void clickedRepHobby(Button buttonIN) {
        if (criteria1 != null) {
            removePreviousCriteria();
        }
        if (currentArray == null) {
            this.displayTitles(1);
        }

        legendTitle = new TextShape(840, 310, "Hobby Legend", Color.BLACK);
        legendTitle.setBackgroundColor(Color.WHITE);
        criteria1 = new TextShape(legendTitle.getX(), legendTitle.getY()
            + legendTitle.getHeight(), "Read", Color.MAGENTA);
        criteria1.setBackgroundColor(Color.WHITE);

        criteria2 = new TextShape(legendTitle.getX(), criteria1.getY()
            + criteria1.getHeight(), "Art", Color.BLUE);
        criteria2.setBackgroundColor(Color.WHITE);

        criteria3 = new TextShape(legendTitle.getX(), criteria2.getY()
            + criteria2.getHeight(), "Sports", Color.ORANGE);
        criteria3.setBackgroundColor(Color.WHITE);

        criteria4 = new TextShape(legendTitle.getX(), criteria3.getY()
            + criteria3.getHeight(), "Music", Color.GREEN);
        criteria4.setBackgroundColor(Color.WHITE);

        window.removeAllShapes();
        sort = "hobby";

        if (Arrays.deepEquals(currentArray, calculator.sortByTitle())) {
            displayTitles(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByArtist())) {
            displayArtists(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByGenre())) {
            displayGenres(pageNum);
        }
        else {
            displayYears(pageNum);
        }

        updateBarsHobby(pageNum);
        createLegend();

    }


    /**
     * sorts songs by people of a major who like them
     * 
     * @param buttonIN
     *            button pressed
     */
    public void clickedRepMajor(Button buttonIN) {
        if (criteria1 != null) {
            removePreviousCriteria();
        }
        if (currentArray == null) {
            this.displayTitles(1);
        }

        legendTitle = new TextShape(840, 310, "Major Legend", Color.BLACK);
        legendTitle.setBackgroundColor(Color.WHITE);

        criteria1 = new TextShape(legendTitle.getX(), legendTitle.getY()
            + legendTitle.getHeight(), "Computer Science", Color.MAGENTA);
        criteria1.setBackgroundColor(Color.WHITE);

        criteria2 = new TextShape(legendTitle.getX(), criteria1.getY()
            + criteria1.getHeight(), "Other Engineering", Color.BLUE);
        criteria2.setBackgroundColor(Color.WHITE);

        criteria3 = new TextShape(legendTitle.getX(), criteria2.getY()
            + criteria2.getHeight(), "Math or CMDA", Color.ORANGE);
        criteria3.setBackgroundColor(Color.WHITE);

        criteria4 = new TextShape(legendTitle.getX(), criteria3.getY()
            + criteria3.getHeight(), "Other", Color.GREEN);
        criteria4.setBackgroundColor(Color.WHITE);

        window.removeAllShapes();
        sort = "major";

        if (Arrays.deepEquals(currentArray, calculator.sortByTitle())) {
            displayTitles(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByArtist())) {
            displayArtists(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByGenre())) {
            displayGenres(pageNum);
        }
        else {
            displayYears(pageNum);
        }

        updateBarsMajor(pageNum);
        createLegend();

    }


    /**
     * shows song data by people who like them by a region
     * 
     * @param buttonIN
     *            button pressed
     */
    public void clickedRepRegion(Button buttonIN) {
        if (criteria1 != null) {
            this.removePreviousCriteria();
        }
        if (currentArray == null) {
            this.displayTitles(1);
        }

        legendTitle = new TextShape(840, 310, "Region Legend", Color.BLACK);
        legendTitle.setBackgroundColor(Color.WHITE);
        criteria1 = new TextShape(legendTitle.getX(), legendTitle.getY()
            + legendTitle.getHeight(), "Northeast US", Color.MAGENTA);
        criteria1.setBackgroundColor(Color.WHITE);

        criteria2 = new TextShape(legendTitle.getX(), criteria1.getY()
            + criteria1.getHeight(), "Southeast US", Color.BLUE);
        criteria2.setBackgroundColor(Color.WHITE);

        criteria3 = new TextShape(legendTitle.getX(), criteria2.getY()
            + criteria2.getHeight(), "Rest of US", Color.ORANGE);
        criteria3.setBackgroundColor(Color.WHITE);

        criteria4 = new TextShape(legendTitle.getX(), criteria3.getY()
            + criteria3.getHeight(), "Outside US", Color.GREEN);
        criteria4.setBackgroundColor(Color.WHITE);

        window.removeAllShapes();
        sort = "region";

        if (Arrays.deepEquals(currentArray, calculator.sortByTitle())) {
            displayTitles(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByArtist())) {
            displayArtists(pageNum);
        }
        else if (Arrays.deepEquals(currentArray, calculator.sortByGenre())) {
            displayGenres(pageNum);
        }
        else {
            displayYears(pageNum);
        }

        updateBarsRegion(pageNum);
        createLegend();

    }


    /**
     * creates a glyph for a song
     * 
     * @param graphSong
     *            song to make a graph for
     */
    public void createGlyph(Song graphSong) {
        Shape middle = new Shape(120, 50, 10, 80, Color.BLACK);
        Shape topBar = new Shape(100, 50, 50, 20, Color.MAGENTA);
        Shape secBar = new Shape(100, 70, 50, 20, Color.BLUE);
        Shape thirdBar = new Shape(100, 90, 50, 20, Color.ORANGE);
        Shape bottomBar = new Shape(100, 110, 50, 20, Color.GREEN);
        window.addShape(middle);
        window.addShape(topBar);
        window.addShape(secBar);
        window.addShape(thirdBar);
        window.addShape(bottomBar);

    }


    /**
     * displays text for when songs are sorted by title
     * 
     * @param page
     *            an int representing the current page of songs the list is on
     *            in the array
     */
    public void displayTitles(int page) {
        if (criteria1 != null) {
            createLegend();
        }
        currentArray = calculator.sortByTitle();
        if (currentArray.length % 9 == 0) {
            pageMax = currentArray.length / 9;
        }
        else {
            pageMax = (currentArray.length / 9) + 1;
        }
        int counter = 0;
        if (page < pageMax) {
            for (int i = (page * 9) - 9; i < (page * 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String create = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 30, create,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String create = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 190, create,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String create = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 330, create,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                counter++;
            }

        }
        else if (page == pageMax) {
            for (int i = (page * 9) - 9; i < (currentArray.length % 9) + ((page
                * 9) - 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String create = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 30, create,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String create = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 190, create,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String create = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 330, create,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                counter++;
            }
        }

    }


    /**
     * displays text for the songs when sorted by genre
     * 
     * @param page
     *            an int representing the current page of songs the list is on
     *            in the array
     */
    public void displayGenres(int page) {
        if (criteria1 != null) {
            createLegend();
        }
        currentArray = calculator.sortByGenre();
        if (currentArray.length % 9 == 0) {
            pageMax = currentArray.length / 9;
        }
        else {
            pageMax = (currentArray.length / 9) + 1;
        }
        int counter = 0;
        if (page < pageMax) {
            for (int i = (page * 9) - 9; i < (page * 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String type = "genre: " + ((Song)currentArray[i])
                        .getGenre();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape genre = new TextShape(title.getX(), 30, type,
                        Color.black);
                    genre.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(genre);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String type = "genre: " + ((Song)currentArray[i])
                        .getGenre();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape genre = new TextShape(title.getX(), 190, type,
                        Color.black);
                    genre.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(genre);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String type = "genre: " + ((Song)currentArray[i])
                        .getGenre();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape genre = new TextShape(title.getX(), 330, type,
                        Color.black);
                    genre.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(genre);
                }
                counter++;
            }

        }
        else if (page == pageMax) {
            for (int i = (page * 9) - 9; i < (currentArray.length % 9) + ((page
                * 9) - 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String type = "genre: " + ((Song)currentArray[i])
                        .getGenre();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape genre = new TextShape(title.getX(), 30, type,
                        Color.black);
                    genre.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(genre);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String type = "genre: " + ((Song)currentArray[i])
                        .getGenre();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape genre = new TextShape(title.getX(), 190, type,
                        Color.black);
                    genre.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(genre);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String type = "genre: " + ((Song)currentArray[i])
                        .getGenre();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape genre = new TextShape(title.getX(), 330, type,
                        Color.black);
                    genre.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(genre);
                }
                counter++;
            }
        }

    }


    /**
     * displays text for songs when sorted by artist
     * 
     * @param page
     *            an int representing the current page of songs the list is on
     *            in the array
     */
    public void displayArtists(int page) {
        if (criteria1 != null) {
            createLegend();
        }
        currentArray = calculator.sortByArtist();
        if (currentArray.length % 9 == 0) {
            pageMax = currentArray.length / 9;
        }
        else {
            pageMax = (currentArray.length / 9) + 1;
        }
        int counter = 0;
        if (page < pageMax) {
            for (int i = (page * 9) - 9; i < (page * 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String arist = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 30, arist,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String arist = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 190, arist,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String arist = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 330, arist,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                counter++;
            }

        }
        else if (page == pageMax) {
            for (int i = (page * 9) - 9; i < (currentArray.length % 9) + ((page
                * 9) - 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String arist = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 30, arist,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String arist = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 190, arist,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String arist = "By " + ((Song)currentArray[i]).getArtist();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape artist = new TextShape(title.getX(), 330, arist,
                        Color.black);
                    artist.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(artist);
                }
                counter++;
            }
        }

    }


    /**
     * creates text shapes for when the songs are sorted by year released
     * 
     * @param page
     *            an int representing the current page of songs the list is on
     *            in the array
     */
    public void displayYears(int page) {
        if (criteria1 != null) {
            createLegend();
        }
        currentArray = calculator.sortByYear();
        if (currentArray.length % 9 == 0) {
            pageMax = currentArray.length / 9;
        }
        else {
            pageMax = (currentArray.length / 9) + 1;
        }
        int counter = 0;
        if (page < pageMax) {
            for (int i = (page * 9) - 9; i < (page * 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String yearReleased = "released: " + ((Song)currentArray[i])
                        .getYearReleased();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape year = new TextShape(title.getX(), 30,
                        yearReleased, Color.black);
                    year.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(year);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String yearReleased = "released: " + ((Song)currentArray[i])
                        .getYearReleased();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape year = new TextShape(title.getX(), 190,
                        yearReleased, Color.black);
                    year.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(year);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String yearReleased = "released: " + ((Song)currentArray[i])
                        .getYearReleased();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape year = new TextShape(title.getX(), 330,
                        yearReleased, Color.black);
                    year.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(year);
                }
                counter++;
            }

        }
        else if (page == pageMax) {
            for (int i = (page * 9) - 9; i < (currentArray.length % 9) + ((page
                * 9) - 9); i++) {
                if (counter < 3) {
                    String name = ((Song)currentArray[i]).getName();
                    String yearReleased = "released: " + ((Song)currentArray[i])
                        .getYearReleased();
                    TextShape title = new TextShape(80 + (counter * 300), 10,
                        name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape year = new TextShape(title.getX(), 30,
                        yearReleased, Color.black);
                    year.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(year);
                }
                else if (counter >= 3 && counter < 6) {
                    String name = ((Song)currentArray[i]).getName();
                    String yearReleased = "released: " + ((Song)currentArray[i])
                        .getYearReleased();
                    TextShape title = new TextShape(80 + ((counter - 3) * 300),
                        170, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape year = new TextShape(title.getX(), 190,
                        yearReleased, Color.black);
                    year.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(year);
                }
                else if (counter >= 6 && counter < 9) {
                    String name = ((Song)currentArray[i]).getName();
                    String yearReleased = "released: " + ((Song)currentArray[i])
                        .getYearReleased();
                    TextShape title = new TextShape(80 + ((counter - 6) * 300),
                        310, name, Color.black);
                    title.setBackgroundColor(Color.WHITE);
                    TextShape year = new TextShape(title.getX(), 330,
                        yearReleased, Color.black);
                    year.setBackgroundColor(Color.WHITE);
                    window.addShape(title);
                    window.addShape(year);
                }
                counter++;
            }
        }

    }


    /**
     * removes the previous text shapes in the legend
     */
    public void removePreviousCriteria() {
        window.removeShape(legendTitle);
        window.removeShape(criteria1);
        window.removeShape(criteria2);
        window.removeShape(criteria3);
        window.removeShape(criteria4);
    }


    /**
     * Updates the bars based on region data
     * 
     * @param page
     *            int representing the current page the songs are on
     */
    public void updateBarsRegion(int page) {
        int counter = 0;
        int y = 0;
        int x = 0;
        for (int i = (page * 9) - 9; i < (page * 9); i++) {
            if (counter < 3) {
                y = 55;
                x = counter;
            }
            if (counter >= 3 && counter < 6) {
                y = 215;
                x = counter - 3;
            }
            if (counter >= 6 && counter < 9) {
                y = 355;
                x = counter - 6;
            }
            if (i < currentArray.length) {
                double yesNorthEastLikes = ((Song)currentArray[i])
                    .getRegionLikes(StateEnum.NORTHEAST);
                double noNorthEastLikes = ((Song)currentArray[i])
                    .getRegionNotLikes(StateEnum.NORTHEAST);
                int northEastLikes = (int)(yesNorthEastLikes
                    / (yesNorthEastLikes + noNorthEastLikes) * 100);

                double yesSouthEastLikes = ((Song)currentArray[i])
                    .getRegionLikes(StateEnum.SOUTHEAST);
                double noSouthEastLikes = ((Song)currentArray[i])
                    .getRegionNotLikes(StateEnum.SOUTHEAST);
                int southEastLikes = (int)(yesSouthEastLikes
                    / (yesSouthEastLikes + noSouthEastLikes) * 100);

                double yesUSLikes = ((Song)currentArray[i]).getRegionLikes(
                    StateEnum.OTHER_US);
                double noUSLikes = ((Song)currentArray[i]).getRegionNotLikes(
                    StateEnum.OTHER_US);
                int USLikes = (int)(yesUSLikes / (yesUSLikes + noUSLikes)
                    * 100);

                double yesOutsideLikes = ((Song)currentArray[i]).getRegionLikes(
                    StateEnum.OUTSIDE_US);
                double noOutsideLikes = ((Song)currentArray[i])
                    .getRegionNotLikes(StateEnum.OUTSIDE_US);
                int outsideLikes = (int)(yesOutsideLikes / (yesOutsideLikes
                    + noOutsideLikes) * 100);

                double yesNorthEastHeard = ((Song)currentArray[i])
                    .getRegionHeard(StateEnum.NORTHEAST);
                double noNorthEastHeard = ((Song)currentArray[i])
                    .getRegionNotHeard(StateEnum.NORTHEAST);
                int northEastHeard = (int)(yesNorthEastHeard
                    / (yesNorthEastHeard + noNorthEastHeard) * 100);

                double yesSouthEastHeard = ((Song)currentArray[i])
                    .getRegionHeard(StateEnum.SOUTHEAST);
                double noSouthEastHeard = ((Song)currentArray[i])
                    .getRegionNotHeard(StateEnum.SOUTHEAST);
                int southEastHeard = (int)(yesSouthEastHeard
                    / (yesSouthEastHeard + noSouthEastHeard) * 100);

                double yesUSHeard = ((Song)currentArray[i]).getRegionHeard(
                    StateEnum.OTHER_US);
                double noUSHeard = ((Song)currentArray[i]).getRegionNotHeard(
                    StateEnum.OTHER_US);
                int USHeard = (int)(yesUSHeard / (yesUSHeard + noUSHeard)
                    * 100);

                double yesOutsideHeard = ((Song)currentArray[i]).getRegionHeard(
                    StateEnum.OUTSIDE_US);
                double noOutsideHeard = ((Song)currentArray[i])
                    .getRegionNotHeard(StateEnum.OUTSIDE_US);
                int outsideHeard = (int)(yesOutsideHeard / (yesOutsideHeard
                    + noOutsideHeard) * 100);

                Shape barLeft1 = new Shape(130 + (x * 300) - northEastHeard, y,
                    northEastHeard, 7, Color.magenta);
                Shape barRight1 = new Shape(130 + (x * 300), y, northEastLikes,
                    7, Color.magenta);

                Shape barLeft2 = new Shape(130 + (x * 300) - southEastHeard, y
                    + 8, southEastHeard, 7, Color.blue);
                Shape barRight2 = new Shape(130 + (x * 300), y + 8,
                    southEastLikes, 7, Color.blue);
                
                Shape barLeft3 = new Shape(130 + (x * 300) - USHeard, y + 16,
                    USHeard, 7, Color.orange);
                Shape barRight3 = new Shape(130 + (x * 300), y + 16, USLikes, 7,
                    Color.orange);

                Shape barLeft4 = new Shape(130 + (x * 300) - outsideHeard, y
                    + 24, outsideHeard, 7, Color.green);
                Shape barRight4 = new Shape(130 + (x * 300), y + 24,
                    outsideLikes, 7, Color.green);

                Shape divider = new Shape(130 + (x * 300), y, 3, 32,
                    Color.black);
                
                window.addShape(divider);
                window.addShape(barLeft1);
                window.addShape(barRight1);
                window.addShape(barLeft2);
                window.addShape(barRight2);
                window.addShape(barLeft3);
                window.addShape(barRight3);
                window.addShape(barLeft4);
                window.addShape(barRight4);
            }
            counter++;
        }
    }


    /**
     * Updates the bars based on hobby data
     * 
     * @param page
     *            an int representing the page the songs are on
     */
    public void updateBarsHobby(int page) {
        int counter = 0;
        int y = 0;
        int x = 0;
        for (int i = (page * 9) - 9; i < (page * 9); i++) {
            if (counter < 3) {
                y = 55;
                x = counter;
            }
            if (counter >= 3 && counter < 6) {
                y = 215;
                x = counter - 3;
            }
            if (counter >= 6 && counter < 9) {
                y = 355;
                x = counter - 6;
            }
            if (i < currentArray.length) {
                double yesReadingLikes = ((Song)currentArray[i]).getHobbyLikes(
                    HobbyEnum.READING);
                double noReadingLikes = ((Song)currentArray[i])
                    .getHobbyNotLikes(HobbyEnum.READING);
                int readingLikes = (int)(yesReadingLikes / (yesReadingLikes
                    + noReadingLikes) * 100);

                double yesArtLikes = ((Song)currentArray[i]).getHobbyLikes(
                    HobbyEnum.ART);
                double noArtLikes = ((Song)currentArray[i]).getHobbyNotLikes(
                    HobbyEnum.ART);
                int artLikes = (int)(yesArtLikes / (yesArtLikes + noArtLikes)
                    * 100);

                double yesSportsLikes = ((Song)currentArray[i]).getHobbyLikes(
                    HobbyEnum.SPORTS);
                double noSportsLikes = ((Song)currentArray[i]).getHobbyNotLikes(
                    HobbyEnum.SPORTS);
                int sportsLikes = (int)(yesSportsLikes / (yesSportsLikes
                    + noSportsLikes) * 100);

                double yesMusicLikes = ((Song)currentArray[i]).getHobbyLikes(
                    HobbyEnum.MUSIC);
                double noMusicLikes = ((Song)currentArray[i]).getHobbyNotLikes(
                    HobbyEnum.MUSIC);
                int musicLikes = (int)(yesMusicLikes / (yesMusicLikes
                    + noMusicLikes) * 100);

                double yesReadingHeard = ((Song)currentArray[i]).getHobbyHeard(
                    HobbyEnum.READING);
                double noReadingHeard = ((Song)currentArray[i])
                    .getHobbyNotHeard(HobbyEnum.READING);
                int readingHeard = (int)(yesReadingHeard / (yesReadingHeard
                    + noReadingHeard) * 100);

                double yesArtHeard = ((Song)currentArray[i]).getHobbyHeard(
                    HobbyEnum.ART);
                double noArtHeard = ((Song)currentArray[i]).getHobbyNotHeard(
                    HobbyEnum.ART);
                int artHeard = (int)(yesArtHeard / (yesArtHeard + noArtHeard)
                    * 100);

                double yesSportsHeard = ((Song)currentArray[i]).getHobbyHeard(
                    HobbyEnum.SPORTS);
                double noSportsHeard = ((Song)currentArray[i]).getHobbyNotHeard(
                    HobbyEnum.SPORTS);
                int sportsHeard = (int)(yesSportsHeard / (yesSportsHeard
                    + noSportsHeard) * 100);

                double yesMusicHeard = ((Song)currentArray[i]).getHobbyHeard(
                    HobbyEnum.MUSIC);
                double noMusicHeard = ((Song)currentArray[i]).getHobbyNotHeard(
                    HobbyEnum.MUSIC);
                int musicHeard = (int)(yesMusicHeard / (yesMusicHeard
                    + noMusicHeard) * 100);

                Shape barLeft1 = new Shape(130 + (x * 300) - readingHeard, y,
                    readingHeard, 7, Color.magenta);
                Shape barRight1 = new Shape(130 + (x * 300), y, readingLikes, 7,
                    Color.magenta);

                Shape barLeft2 = new Shape(130 + (x * 300) - artHeard, y + 8,
                    artHeard, 7, Color.blue);
                Shape barRight2 = new Shape(130 + (x * 300), y + 8, artLikes, 7,
                    Color.blue);

                Shape barLeft3 = new Shape(130 + (x * 300) - sportsHeard, y
                    + 16, sportsHeard, 7, Color.orange);
                Shape barRight3 = new Shape(130 + (x * 300), y + 16,
                    sportsLikes, 7, Color.orange);

                Shape barLeft4 = new Shape(130 + (x * 300) - musicHeard, y + 24,
                    musicHeard, 7, Color.green);
                Shape barRight4 = new Shape(130 + (x * 300), y + 24, musicLikes,
                    7, Color.green);

                Shape divider = new Shape(130 + (x * 300), y, 3, 32,
                    Color.black);
                
                window.addShape(divider);
                window.addShape(barLeft1);
                window.addShape(barRight1);
                window.addShape(barLeft2);
                window.addShape(barRight2);
                window.addShape(barLeft3);
                window.addShape(barRight3);
                window.addShape(barLeft4);
                window.addShape(barRight4);
            }
            counter++;
        }
    }


    /**
     * Updates the bars based on major data
     * 
     * @param page
     *            an int representing what page the songs are currently on
     */
    public void updateBarsMajor(int page) {
        int counter = 0;
        int y = 0;
        int x = 0;
        for (int i = (page * 9) - 9; i < (page * 9); i++) {
            if (counter < 3) {
                y = 55;
                x = counter;
            }
            if (counter >= 3 && counter < 6) {
                y = 215;
                x = counter - 3;
            }
            if (counter >= 6 && counter < 9) {
                y = 355;
                x = counter - 6;
            }
            if (i < currentArray.length) {
                double yesCSLikes = ((Song)currentArray[i]).getMajorLikes(
                    MajorEnum.COMPUTER_SCIENCE);
                double noCSLikes = ((Song)currentArray[i])
                    .getMajorNotLikes(MajorEnum.COMPUTER_SCIENCE);
                int CSLikes = (int)(yesCSLikes / (yesCSLikes
                    + noCSLikes) * 100);

                double yesEngineeringLikes = ((Song)currentArray[i]).getMajorLikes(
                    MajorEnum.OTHER_ENGINEERING);
                double noEngineeringLikes = ((Song)currentArray[i]).getMajorNotLikes(
                    MajorEnum.OTHER_ENGINEERING);
                int engineeringLikes = (int)(yesEngineeringLikes / (yesEngineeringLikes + noEngineeringLikes)
                    * 100);

                double yesMathLikes = ((Song)currentArray[i]).getMajorLikes(
                    MajorEnum.MATH_CMDA);
                double noMathLikes = ((Song)currentArray[i]).getMajorNotLikes(
                    MajorEnum.MATH_CMDA);
                int mathLikes = (int)(yesMathLikes / (yesMathLikes
                    + noMathLikes) * 100);

                double yesOtherLikes = ((Song)currentArray[i]).getMajorLikes(
                    MajorEnum.OTHER);
                double noOtherLikes = ((Song)currentArray[i]).getMajorNotLikes(
                    MajorEnum.OTHER);
                int otherLikes = (int)(yesOtherLikes / (yesOtherLikes
                    + noOtherLikes) * 100);

                double yesCSHeard = ((Song)currentArray[i]).getMajorHeard(
                    MajorEnum.COMPUTER_SCIENCE);
                double noCSHeard = ((Song)currentArray[i])
                    .getMajorNotHeard(MajorEnum.COMPUTER_SCIENCE);
                int CSHeard = (int)(yesCSHeard / (yesCSHeard
                    + noCSHeard) * 100);

                double yesEngineeringHeard = ((Song)currentArray[i]).getMajorHeard(
                    MajorEnum.OTHER_ENGINEERING);
                double noEngineeringHeard = ((Song)currentArray[i]).getMajorNotHeard(
                    MajorEnum.OTHER_ENGINEERING);
                int engineeringHeard = (int)(yesEngineeringHeard / (yesEngineeringHeard + noEngineeringHeard)
                    * 100);

                double yesMathHeard = ((Song)currentArray[i]).getMajorHeard(
                    MajorEnum.MATH_CMDA);
                double noMathHeard = ((Song)currentArray[i]).getMajorNotHeard(
                    MajorEnum.MATH_CMDA);
                int mathHeard = (int)(yesMathHeard / (yesMathHeard
                    + noMathHeard) * 100);

                double yesOtherHeard = ((Song)currentArray[i]).getMajorHeard(
                    MajorEnum.OTHER);
                double noOtherHeard = ((Song)currentArray[i]).getMajorNotHeard(
                    MajorEnum.OTHER);
                int otherHeard = (int)(yesOtherHeard / (yesOtherHeard
                    + noOtherHeard) * 100);

                Shape barLeft1 = new Shape(130 + (x * 300) - CSHeard, y,
                    CSHeard, 7, Color.magenta);
                Shape barRight1 = new Shape(130 + (x * 300), y, CSLikes, 7,
                    Color.magenta);

                Shape barLeft2 = new Shape(130 + (x * 300) - engineeringHeard, y + 8,
                    engineeringHeard, 7, Color.blue);
                Shape barRight2 = new Shape(130 + (x * 300), y + 8, engineeringLikes, 7,
                    Color.blue);

                Shape barLeft3 = new Shape(130 + (x * 300) - mathHeard, y
                    + 16, mathHeard, 7, Color.orange);
                Shape barRight3 = new Shape(130 + (x * 300), y + 16,
                    mathLikes, 7, Color.orange);

                Shape barLeft4 = new Shape(130 + (x * 300) - otherHeard, y + 24,
                    otherHeard, 7, Color.green);
                Shape barRight4 = new Shape(130 + (x * 300), y + 24, otherLikes,
                    7, Color.green);
                
                Shape divider = new Shape(130 + (x * 300), y, 3, 32,
                    Color.black);
                
                window.addShape(divider);
                window.addShape(barLeft1);
                window.addShape(barRight1);
                window.addShape(barLeft2);
                window.addShape(barRight2);
                window.addShape(barLeft3);
                window.addShape(barRight3);
                window.addShape(barLeft4);
                window.addShape(barRight4);
            }
            counter++;
        }
    }
}
