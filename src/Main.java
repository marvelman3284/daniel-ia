import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static int wpm, size;
    public static String font;
    public static Color color;

    public static GridBagConstraints c = new GridBagConstraints();

    public static String[] words = {"test", "clear", "read", "find", "lose", "daniel", "carey"};
    public static boolean test = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Reading Test");

        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 500);
        frame.setVisible(true);

        panel.setLayout(new GridBagLayout());

        gameLoop(panel, frame);
    }

    public static void gameLoop(JPanel panel, JFrame frame) {
        createSettings(panel, frame);

        while (!test) {
            wait(1);
        }

        clean(panel);
        readingTest(panel, frame, words, 100, size, color, font);

        test = false;
        gameLoop(panel, frame);
    }

    public static void clean(JPanel panel) {
        panel.removeAll();
        panel.validate();
        panel.repaint();
    }

    public static void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readingTest(JPanel panel, JFrame frame, String[] words, int wpm, int size, Color color, String font) {
        System.out.println(font);
        for (String s : words) {
            JLabel label = new JLabel(s);
            label.setForeground(color);

            label.setFont(new Font(font, Font.PLAIN, size));

            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridy = 5;
            c.gridx = 1;

            panel.add(label, c);
            frame.add(panel);
            frame.setVisible(true);

            wait(wpm / 60 * 1000); // multiply by 60 to go from sec to min then by 1000 to go to ms

            clean(panel);
        }
    }

    public static void createSettings(JPanel panel, JFrame frame) {
        JTextField wpmText = new JTextField(16);
        JButton wpmSubmit = new JButton("Submit");
        JLabel wpmLabel = new JLabel("WPM:");

        wpmSubmit.addActionListener(e -> wpm = Integer.parseInt(wpmText.getText()));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        panel.add(wpmLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;

        panel.add(wpmText, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;

        panel.add(wpmSubmit, c);

        JTextField sizeText = new JTextField(16);
        JButton sizeSubmit = new JButton("Submit");
        JLabel sizeLabel = new JLabel("Size(px):");

        sizeSubmit.addActionListener(e -> size = Integer.parseInt(sizeText.getText()));

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;

        panel.add(sizeLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;

        panel.add(sizeText, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;

        panel.add(sizeSubmit, c);

        String[] colors = {"blue", "green", "red", "black", "orange", "pink"};
        final JComboBox<String> colorChoice = new JComboBox<>(colors);
        JButton colorSubmit = new JButton("Submit");
        JLabel colorLabel = new JLabel("Color:");

        colorSubmit.addActionListener(e -> {
            switch (colorChoice.getSelectedItem().toString()) {
                case "blue" -> color = Color.blue;
                case "black" -> color = Color.black;
                case "pink" -> color = Color.pink;
                case "green" -> color = Color.green;
                case "red" -> color = Color.red;
                case "orange" -> color = Color.orange;
            }
        });

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;

        panel.add(colorLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;

        panel.add(colorChoice, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;

        panel.add(colorSubmit, c);

        JButton fontSubmit = new JButton("Submit");
        String[] fonts = {"Iosevka", "Hack", "Jetbrains Mono", "Fira Code"};
        final JComboBox<String> fontChoice = new JComboBox<>(fonts);
        JLabel fontLabel = new JLabel("Font:");

        fontSubmit.addActionListener(e -> font = fontChoice.getSelectedItem().toString());

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;

        panel.add(fontLabel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;

        panel.add(fontChoice, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;

        panel.add(fontSubmit, c);

        JButton submit = new JButton("Save settings & start");
        submit.addActionListener(e -> test = true); // call start game function

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 4;
        c.gridx = 1;

        panel.add(submit, c);

        frame.add(panel);
        frame.setVisible(true);
    }
}