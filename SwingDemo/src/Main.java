import javax.swing.*;
import java.awt.*;

public class Main {

    private static void vytvorGUI() {
        JFrame okno = new JFrame("Moje okno");

        JButton button1 = new JButton("Prve");
        JButton button2 = new JButton("Druhe");
        JCheckBox check1 = new JCheckBox();
        JTextArea area = new JTextArea();
        area.setPreferredSize(new Dimension(300, 300));
        JLabel label1 = new JLabel("Zobraz");
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 30));

        button1.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    null,
                    area.getText(),
                    "Surprise",
                    JOptionPane.ERROR_MESSAGE
            );
        });

        JPanel northPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        northPanel.setBackground(Color.MAGENTA);
        northPanel.add(button1);
        northPanel.add(button2);

        westPanel.setBackground(Color.YELLOW);
        westPanel.add(label1);
        westPanel.add(check1);

        southPanel.setBackground(Color.BLUE);
        southPanel.add(textField);

        centerPanel.setBackground(Color.GREEN);
        centerPanel.add(area);

        okno.getContentPane().setLayout(new BorderLayout());
        okno.getContentPane().add(northPanel, BorderLayout.NORTH);
        okno.getContentPane().add(southPanel, BorderLayout.SOUTH);
        okno.getContentPane().add(centerPanel, BorderLayout.CENTER);
        okno.getContentPane().add(westPanel, BorderLayout.WEST);

        okno.setPreferredSize(new Dimension(600, 400));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.pack();
        okno.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::vytvorGUI);
    }

}
