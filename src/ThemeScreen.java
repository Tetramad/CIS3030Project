import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThemeScreen {
    private JPanel panel1;
    private JButton buttonReturnButton;
    private JButton buttonWalkButton;
    private JButton buttonExerciseButton;
    private JButton buttonMealButton;
    private JButton buttonStudyButton;
    private JFrame frameMain;
    private MenuScreen menuScreen;
    private ThemeControl themeControl;

    public ThemeScreen() {
    }

    public void show(){
        frameMain = new JFrame("THEME");
        frameMain.setContentPane(this.panel1);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();
        frameMain.setLocationRelativeTo(null);
        frameMain.setVisible(true);
    }

    public void initialize(MenuScreen menuScreen, ThemeControl themeControl) {
        this.menuScreen = menuScreen;
        this.themeControl = themeControl;

        addListeners();
    }

    private void addListeners() {
        buttonReturnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                menuScreen.show();
            }
        });
        buttonExerciseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Exercise);
            }
        });
        buttonMealButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Meal);
            }
        });
        buttonStudyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Study);
            }
        });
        buttonWalkButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameMain.setVisible(false);
                themeControl.selectTheme(ThemeTag.Walk);
            }
        });
    }
}