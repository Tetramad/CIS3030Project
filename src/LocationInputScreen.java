import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocationInputScreen {
    private JFrame frameMain;
    private JPanel panelMain;
    private JTextField textFieldLatitude;
    private JTextField textFieldLongitude;
    private JButton buttonSkip;
    private JButton buttonOk;
    private LocationControl locationControl;
    private MenuScreen menuScreen;

    public LocationInputScreen() { }

    public void show() {
        frameMain.setVisible(true);
    }

    private void addListeners() {
        buttonSkip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frameMain.setVisible(false);
                menuScreen.show();
            }
        });
        buttonOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (locationControl.checkLocationInput(textFieldLatitude.getText(), textFieldLongitude.getText())) {
                    frameMain.setVisible(false);
                    return;
                }
                JOptionPane.showMessageDialog(frameMain, "위치 입력 값이 잘못되어있습니다.");
            }
        });
    }

    public void initialize(LocationControl locationControl, MenuScreen menuScreen) {
        this.frameMain = new JFrame("사용자 위치 입력");
        this.locationControl = locationControl;
        this.menuScreen = menuScreen;

        frameMain.setContentPane(this.panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();

        addListeners();
    }
}
