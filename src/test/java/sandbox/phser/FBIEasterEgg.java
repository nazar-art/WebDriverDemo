package sandbox.phser;

import java.util.concurrent.Phaser;

public class FBIEasterEgg {

    static int lines = 10;
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    static StringBuffer randomAlphabet = new StringBuffer();

    public static void main(String[] args) {
        final Phaser phaser = new Phaser() {
            @Override
            protected boolean onAdvance(int phase, int parties) {
                System.out.println(randomAlphabet);
                randomAlphabet = new StringBuffer();
                return phase >= lines;
            }
        };

        phaser.register();

        for (int i = 0; i < alphabet.length(); i++) {
            final char next = alphabet.charAt(i);
            phaser.register();

            new Thread() {
                @Override
                public void run() {
                    do {
                        randomAlphabet.append(next);
                        phaser.arriveAndAwaitAdvance();
                    } while (!phaser.isTerminated());
                }
            }.start();
        }
        System.out.println("Write this by hand and carry in the pocket:");
        phaser.arriveAndDeregister();
    }
}
