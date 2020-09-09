package platformer.game.Levels;
import platformer.game.PlatformerExampleMain;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JFrame implements ActionListener, MouseListener{
    private final JLabel title;
    private JButton startB, exitB;
    static JFrame frame1 = new JFrame();
    public MainMenu() {
        frame1.setSize(575,664);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame1.setLocation((int) (screenSize.getWidth() / 2 - frame1.getSize().getWidth() / 2),
                (int) (screenSize.getHeight() / 2 -frame1.getSize().getHeight() / 2));
        frame1.setBackground(Color.BLACK);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container mainP;
        try {
            frame1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/Image_Resources/menubg.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainP=frame1.getContentPane();
        mainP.setLayout(null);
        title = new JLabel("KING OF DALIAS ");
        title.getVerticalTextPosition();
        title.setForeground(Color.BLACK);
        startB = new JButton("Start");
        startB.addMouseListener(this);
        exitB = new JButton("Exit");
        exitB.addMouseListener(this);
        mainP.add(title);
        title.setFont(new Font("Chiller",Font.ITALIC,50));
        title.setBounds(100, 30, 500, 50);
        mainP.add(startB);
        startB.setBounds(132, 200, 300, 100);
        startB.setFont(new Font("Arial", Font.ITALIC, 70));
        startB.setForeground(Color.lightGray);
        startB.setOpaque(false);
        startB.setContentAreaFilled(false);
        startB.setBorderPainted(false);
        mainP.add(exitB);
        exitB.setBounds(132, 350, 300, 100);
        exitB.setFont(new Font("Arial", Font.ITALIC, 70));
        exitB.setForeground(Color.lightGray);
        exitB.setOpaque(false);
        exitB.setContentAreaFilled(false);
        exitB.setBorderPainted(false);
        startB.addActionListener(this);
        exitB.addActionListener(this);
        frame1.setVisible(true);
        frame1.setResizable(false);

    }
    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        if(key.equals("Start")) {
            frame1.dispose();
            new PlatformerExampleMain();
            PlatformerExampleMain.main(new String[0]);
        }
        else {
            System.exit(0);
        }
    }
    public static void main(String[]args) {
        new MainMenu();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        JButton button = (JButton)mouseEvent.getSource();
        button.setForeground(Color.darkGray);
    }





    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        startB.setForeground(Color.lightGray);
        exitB.setForeground(Color.lightGray);


    }
}