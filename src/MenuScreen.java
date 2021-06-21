import javax.swing.*;
import java.awt.event.*;

public class MenuScreen {
    private JFrame frameMain;
    private JPanel panel1;
    private JButton buttonTheme;
    private JButton 편의시설Button;
    private JButton 사용자의견Button;
    private JButton buttonReturn;
    private LocationInputScreen locationInputScreen;
    private ThemeScreen themeScreen;


    public MenuScreen() {
    }

    public void show(){
        frameMain = new JFrame("MENU");
        frameMain.setContentPane(this.panel1);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);
        frameMain.setBounds(400,200,500,300);
    }

    public void initialize(LocationInputScreen locationInputScreen, ThemeScreen themeScreen) {
        this.locationInputScreen = locationInputScreen;
        this.themeScreen = themeScreen;

        addListeners();
    }

    private void addListeners() {
        buttonTheme.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeScreen.show();
            }
        });
        buttonReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                locationInputScreen.show();
            }
        });
    }
}
