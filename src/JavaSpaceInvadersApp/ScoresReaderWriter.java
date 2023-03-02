package JavaSpaceInvadersApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoresReaderWriter {

    Path highScoresPath = Paths.get("C:/Users/Jack/IdeaProjects/JavaSpaceInvaders/src/data/highscores.txt");
    Charset charset = Charset.forName("US-ASCII");
    List<Integer> scores = new ArrayList<Integer>();
    List<String> names = new ArrayList<String>();
    int numScores;

    protected void writeNewLastScore (int lastScore) {

        scores.clear();
        names.clear();
        numScores = 0;

        try (BufferedReader reader = Files.newBufferedReader(highScoresPath, charset)) {

            String line;
            while ((line = reader.readLine()) != null && numScores<11) {
                String[] parts = line.split(";");
                scores.add(Integer.valueOf(parts[0]));
                names.add(parts[1]);
                numScores++;
            }
            scores.set(0, lastScore);
            names.set(0, "last");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(highScoresPath, charset)) {

            for (int i=0; i<numScores; i++) {
                writer.write(scores.get(i)+";"+names.get(i));
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeNewHighScore(int score, String initials) {

        scores.clear();
        names.clear();
        numScores = 0;

        try (BufferedReader reader = Files.newBufferedReader(highScoresPath, charset)) {

            String line;
            while (((line = reader.readLine()) != null) && (numScores<11)) {
                String[] parts = line.split(";");
                scores.add(Integer.valueOf(parts[0]));
                names.add(parts[1]);
                numScores++;
            }
            scores.add(score);
            names.add(initials);
            numScores++;

            for (int i=numScores-2; i>0; i--) {
                if (score>scores.get(i)) {
                    Collections.swap(scores, i, i+1);
                    Collections.swap(names, i, i+1);
                }
            }
            if (numScores>11) {
                scores.remove(11);
                names.remove(11);
                numScores--;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(highScoresPath, charset)) {

            for (int i=0; i<numScores; i++) {
                writer.write(scores.get(i)+";"+names.get(i));
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void readScores() {

        scores.clear();
        names.clear();
        numScores = 0;

        try (BufferedReader reader = Files.newBufferedReader(highScoresPath, charset)) {

            String line;
            while ((line = reader.readLine()) != null && numScores < 11) {
                String[] parts = line.split(";");
                scores.add(Integer.valueOf(parts[0]));
                names.add(parts[1]);
                numScores++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
