package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class InstrumentsHero {
    public static final double CONCERT_BASIS = 440.0;
    public static final String KEY_BOARD = "`1q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";



    public static void main(String[] args) {
        int range = KEY_BOARD.length();
        /*
        * HarpString instrument = 50
        * GuitarString instrument = 26
        * HarpString instument = 0
        */
        int instrument = 0;

        HarpString[] guitar = new HarpString[range];
        for (int i = 0; i < guitar.length; i++) {
            double frequency = CONCERT_BASIS * Math.pow(2, ((double) i - instrument) / 12);
            guitar[i] = new HarpString(frequency);
        }


        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                System.out.println("key " + key);
                // holddown the string
                if (key == 'a') {
                    guitar[0].heldDown();
                }
                // revert vibration decay
                if (key == 's') {
                    guitar[0].revert();
                }
                int index = KEY_BOARD.indexOf(key);
                if (index > -1) {
                    guitar[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (HarpString scale: guitar) {
                sample += scale.sample();
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
