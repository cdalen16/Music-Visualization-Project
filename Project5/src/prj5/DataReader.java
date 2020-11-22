/**
 * DataReader Class
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those who
//do.
//-- campbell dalen (cdalen)

/**
 * reads in data and creates two doubly linked lists
 * 
 * @author Campbell Dalen (cdalen)
 * @version 11.17.19
 */
public class DataReader {

    private DLList<Song> songList;
    private DLList<Student> dataList;
    private DataCalculator calc;


    /**
     * Creates new DataReader
     * 
     * @param dataFile
     *            - info from surveys
     * @param songFile
     *            - song info
     * @throws FileNotFoundException
     */
    public DataReader(String dataFile, String songFile)
        throws FileNotFoundException {
        songList = this.readSongFromFile(songFile);
        dataList = this.readDataFromFile(dataFile);
        calc = new DataCalculator(songList, dataList);
        new GUIProjectWindow(calc);
    }


    /**
     * Parses dataFile to get info
     * 
     * @param fileName
     *            - file to be parsed
     * @return DLList<Student> - list of student info
     * @throws FileNotFoundException
     */
    private DLList<Student> readDataFromFile(String fileName)
        throws FileNotFoundException {
        DLList<Student> studentList = new DLList<Student>();

        Scanner file = new Scanner(new File(fileName));
        int count = 0;
        while (file.hasNextLine()) {
            String nextLine = file.nextLine();
            String[] line = nextLine.split(", *");

            if (count > 0) {
                boolean invalid = false;
                if (line.length < 5) {
                    invalid = true;
                }
                else {
                    for (int i = 0; i < 5; i++) {
                        if (line[i].equals("")) {
                            invalid = true;
                        }
                    }
                }

                if (!invalid) {
                    MajorEnum major = MajorEnum.get(line[2]);
                    StateEnum region = StateEnum.get(line[3]);
                    HobbyEnum hobby = HobbyEnum.get(line[4]);

                    studentList.add(new Student(major, region, hobby));

                    int songCount = 0;
                    for (int i = 5; i < line.length - 1; i = i + 2) {

                        Song song = songList.get(songCount);
                        Student student = studentList.get(studentList.size()
                            - 1);

                        if (line[i].equals("Yes")) {
                            student.heardSong(song);
                            song.addHeard(student);
                        }
                        else if (line[i].equals("No")) {
                            song.addNotHeard(student);
                        }

                        if (line[i + 1].equals("Yes")) {
                            student.likesSong(song);
                            song.addLikes(student);
                        }
                        else if (line[i + 1].equals("No")) {
                            song.addNotLikes(student);
                        }
                        songCount++;
                    }

                    if (line.length % 2 == 0) {

                        Song song = songList.get(songCount);
                        Student student = studentList.get(studentList.size()
                            - 1);

                        if (line[line.length - 1].equals("Yes")) {
                            student.heardSong(song);
                            song.addHeard(student);
                        }
                        else if (line[line.length - 1].equals("No")) {
                            song.addNotHeard(student);
                        }
                    }
                }

            }

            count++;
        }

        file.close();

        return studentList;
    }


    /**
     * Parses songFile to get song info
     * 
     * @param fileName
     *            - file to be parsed
     * @return DLList<Song> - song information
     * @throws FileNotFoundException
     */
    private DLList<Song> readSongFromFile(String fileName)
        throws FileNotFoundException {
        DLList<Song> songList = new DLList<Song>();

        Scanner file = new Scanner(new File(fileName));
        int count = 0;
        while (file.hasNextLine()) {
            String nextLine = file.nextLine();
            String[] line = nextLine.split(", *");

            if (count > 0) {
                String title = line[0];
                String artist = line[1];
                int year = Integer.valueOf(line[2]);
                String genre = line[3];

                songList.add(new Song(title, artist, year, genre));
            }
            count++;
        }
        file.close();

        return songList;
    }


    /**
     * Prints out survey info in console
     */
    public void printer(Object[] arrayIN) {
        for (int i = 0; i < arrayIN.length; i++) {
            Song song = (Song)arrayIN[i];

            System.out.print("Song Title: " + song.getName() + "\n");
            System.out.print("Song Artist: " + song.getArtist() + "\n");
            System.out.print("Song Genre: " + song.getGenre() + "\n");
            System.out.print("Song Year: " + song.getYearReleased() + "\n");

            System.out.print("Heard" + "\n");
            if (calc.totalHobby(HobbyEnum.READING) == 0) {
                System.out.print("reading:" + 0);
            }
            else {
                double yes = song.getHobbyHeard(HobbyEnum.READING);
                double no = song.getHobbyNotHeard(HobbyEnum.READING);

                System.out.print("reading:" + (int)(yes / (yes + no) * 100));
            }

            if (calc.totalHobby(HobbyEnum.ART) == 0) {
                System.out.print(" art:" + 0);
            }
            else {
                double yes = song.getHobbyHeard(HobbyEnum.ART);
                double no = song.getHobbyNotHeard(HobbyEnum.ART);

                System.out.print(" art:" + (int)(yes / (yes + no) * 100));
            }

            if (calc.totalHobby(HobbyEnum.SPORTS) == 0) {
                System.out.print(" sports:" + 0);
            }
            else {
                double yes = song.getHobbyHeard(HobbyEnum.SPORTS);
                double no = song.getHobbyNotHeard(HobbyEnum.SPORTS);

                System.out.print(" sports:" + (int)(yes / (yes + no) * 100));
            }

            if (calc.totalHobby(HobbyEnum.MUSIC) == 0) {
                System.out.print(" music:" + 0);
            }
            else {
                double yes = song.getHobbyHeard(HobbyEnum.MUSIC);
                double no = song.getHobbyNotHeard(HobbyEnum.MUSIC);

                System.out.print(" music:" + (int)(yes / (yes + no) * 100));
            }

            System.out.print("\n" + "Likes" + "\n");
            if (calc.totalHobby(HobbyEnum.READING) == 0) {
                System.out.print("reading:" + 0);
            }
            else {
                double yes = song.getHobbyLikes(HobbyEnum.READING);
                double no = song.getHobbyNotLikes(HobbyEnum.READING);

                System.out.print("reading:" + (int)(yes / (yes + no) * 100));
            }

            if (calc.totalHobby(HobbyEnum.ART) == 0) {
                System.out.print(" art:" + 0);
            }
            else {
                double yes = song.getHobbyLikes(HobbyEnum.ART);
                double no = song.getHobbyNotLikes(HobbyEnum.ART);

                System.out.print(" art:" + (int)(yes / (yes + no) * 100));
            }

            if (calc.totalHobby(HobbyEnum.SPORTS) == 0) {
                System.out.print(" sports:" + 0);
            }
            else {
                double yes = song.getHobbyLikes(HobbyEnum.SPORTS);
                double no = song.getHobbyNotLikes(HobbyEnum.SPORTS);

                System.out.print(" sports:" + (int)(yes / (yes + no) * 100));
            }

            if (calc.totalHobby(HobbyEnum.MUSIC) == 0) {
                System.out.print(" music:" + 0);
            }
            else {
                double yes = song.getHobbyLikes(HobbyEnum.MUSIC);
                double no = song.getHobbyNotLikes(HobbyEnum.MUSIC);

                System.out.print(" music:" + (int)(yes / (yes + no) * 100));
            }
            System.out.print("\n\n");
        }
    }
}
