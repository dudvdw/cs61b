package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final double CONCERT_FACTOR = 440.0;

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] guitar = new GuitarString[37];
        for (int i = 0; i < guitar.length; i++) {
            double frequency = CONCERT_FACTOR * Math.pow(2, ((double) i - 24) / 12);
            guitar[i] = new GuitarString(frequency);
        }


        while (true) {
            int index = 0;
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                index = keyboard.indexOf(key);
                if (index > -1) {
                    guitar[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = guitar[index].sample();

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            guitar[index].tic();
        }
    }
}
