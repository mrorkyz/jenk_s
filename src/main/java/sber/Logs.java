package sber;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logs {

    public static void main(final String[] args) {

        /*
         * for (int i = 0; i < args.length; i++) { System.out.println(args[i]); }
         */
        // Забираем аргумент, и превращаем в int
        //логичнее было бы запихать в бесконечный цикл for (; ;) {} . И отправить приложение в фон
        for (int a = 0; a < 10; a++) {
            try (FileWriter writer = new FileWriter("logs.txt", true)) {
                // Thread.sleep(interval);
                // Время
                final Date date = new Date();

                // запись всей строки message
                final String text = date.toString() + "\t" + args[1];
                writer.write(text);
                // запись по символам
                writer.append('\n');
                writer.flush();

                try {
                    final String s = args[0];
                    try {
                        // именно здесь String преобразуется в int
                        final int i = Integer.parseInt(s.trim());
                        // выведем на экран значение после конвертации
                        // System.out.println("Period = " + i);
                        final int interval = i;
                        // System.out.println("Period2 = " + interval);

                        Thread.sleep(interval);
                        // System.out.println("delay = " + interval);

                    } catch (final NumberFormatException nfe) {
                        System.out.println("NumberFormatException: " + nfe.getMessage());
                    }

                } catch (final InterruptedException ex) {
                }

            } catch (final IOException ex) {

                System.out.println(ex.getMessage());
            }
        }

    }

}
