import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {

    public static int wpm;
    public static float size;
    public static Font font;
    public static Color color;
    public static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    public static JFrame frame = new JFrame("Reading Test");

    public static JPanel panel = new JPanel();
    public static GridBagConstraints c = new GridBagConstraints();

    public static void main(String[] args){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,500);

        panel.setLayout(new GridBagLayout());

        createSettings(panel, frame);
        frame.setVisible(true);
    }

    public static void wait(int time) {
        try {
            Thread.sleep(time);
        } catch ( Exception e ) {
            System.out.println(e);
        }
    }

    public static void readingTest(String[] words, int wpm, float size, Color color, Font font) {
        frame.remove(panel);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JLabel label1 = new JLabel("test");
        panel.add(label1);
        frame.add(panel);
        for (String s : words) {
            JLabel label = new JLabel(s);
            System.out.println(43);
//            label.setForeground(color);

//            label.setFont(font);
//            label.setFont(label.getFont().deriveFont(size));
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridy = 5;
            c.gridx = 1;
            panel.add(label, c);
            frame.add(panel);
            frame.setVisible(true);
            wait(1000);
            panel.remove(label);
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

        sizeSubmit.addActionListener(e -> size = Float.parseFloat(sizeText.getText()));

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
        String[] fonts = {"open sans", "times new roman", "jet brains mono", "roboto"};
        final JComboBox<String> fontChoice = new JComboBox<>(fonts);
        JLabel fontLabel = new JLabel("Font:");

        fontSubmit.addActionListener(e -> {
            switch (fontChoice.getSelectedItem().toString()) {
                case "jet brains mono" -> {
                    try {
                        font = Font.createFont(Font.TRUETYPE_FONT, new File("~/Coding/daniel/JetBrains_Mono/static/JetBrainsMono-Regular.ttf"));
                    } catch (FontFormatException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case "roboto" -> {
                    try {
                        font = Font.createFont(Font.TRUETYPE_FONT, new File("~/Coding/daniel/Roboto-Black.ttf"));
                    } catch (FontFormatException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case "open sans" -> {
                    try {
                        font = Font.createFont(Font.TRUETYPE_FONT, new File("Open_Sans/static/OpenSans/OpenSans-Regular.ttf"));
                    } catch (FontFormatException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                case "comic sans" -> {
                    try {
                        font = Font.createFont(Font.TRUETYPE_FONT, new File("~/Coding/daniel/Comic_Neue/ComicNeue-Regular.ttf"));
                    } catch (FontFormatException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
            ge.registerFont(font);
        });

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
        submit.addActionListener(e -> {
            String[] words = {"test", "clear", "read", "find", "lose", "daniel", "carey"};



            for (String s : words) {
                JLabel label = new JLabel(s);

//            label.setForeground(color);

//            label.setFont(font);
//            label.setFont(label.getFont().deriveFont(size));


                panel.add(label);
                panel.validate();
                panel.repaint();

                frame.add(panel);
                frame.validate();
                frame.repaint();

                frame.setVisible(true);
                wait(100);
//                panel.remove(label);
            }
            frame.add(panel);
        }); // call start game function

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 4;
        c.gridx = 1;

        panel.add(submit, c);

        frame.add(panel);
        frame.setVisible(true);
    }
}