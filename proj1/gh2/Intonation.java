package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class Intonation {
    public static final double CONCERT_BASIS = 440.0;
    public static final String KEY_BOARD = "qwertyuiop";



    public static void main(String[] args) {
        int range = KEY_BOARD.length();
        /*
         * HarpString instrument = 50
         * GuitarString instrument = 26
         * HarpString instument = 0
         */
        int instrument = -2;

        HarpString[] guitar = new HarpString[range];
        for (int i = 0; i < guitar.length; i++) {
            double frequency = CONCERT_BASIS * Math.pow(1.5, i + instrument);
            System.out.println(frequency);
            guitar[i] = new HarpString(frequency);
        }


        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                System.out.println("key " + key);
                int index = KEY_BOARD.indexOf(key);
                if (index > -1) {
                    guitar[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (HarpString scale: guitar) {
                sample += scale.sample();
                System.out.println("sample: " + sample);
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (HarpString scale: guitar) {
                scale.tic();
            }
        }
    }
}
