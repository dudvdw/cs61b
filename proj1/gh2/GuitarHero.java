package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final double CONCERT_BASIS = 440.0;
    public static final String KEY_BOARD = "`1q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";


    public static void main(String[] args) {
        int range = KEY_BOARD.length();
        GuitarString[] guitar = new GuitarString[range];
        for (int i = 0; i < guitar.length; i++) {
            double frequency = CONCERT_BASIS * Math.pow(2, ((double) i - 26) / 12);
            guitar[i] = new GuitarString(frequency);
        }


        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                System.out.println("key " + key);
                int index = KEY_BOARD.indexOf(key);
//                System.out.println("index " + index);
                if (index > -1) {
                    guitar[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (GuitarString scale: guitar) {
                sample += scale.sample();
            }
//            System.out.println("sample " + sample);

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString scale: guitar) {
                scale.tic();
            }
        }
    }
}
