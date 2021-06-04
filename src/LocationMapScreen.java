import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LocationMapScreen {
    private JFrame frameMain;
    private JPanel panelMain;
    private JButton buttonReturn;
    private JButton buttonOk;
    private JPanel panelMap;
    private ImagePanel map;
    private MenuScreen menuScreen;

    public LocationMapScreen() {}

    public void show(UserLocation userLocation) {
        if (map != null) {
            panelMap.remove(map);
        }
        map = MapInformation.addMapImage(panelMap);
        MapInformation.addMarkerImage(map, userLocation.getUserLocation());
        frameMain.pack();
        frameMain.setVisible(true);
    }

    private void addListeners() {
        buttonReturn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        buttonOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frameMain.setVisible(false);
                menuScreen.show();
            }
        });
    }

    public void initialize(MenuScreen menuScreen) {
        this.frameMain = new JFrame("사용자 위치 확인");
        this.menuScreen = menuScreen;

        frameMain.setContentPane(this.panelMain);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.pack();

        addListeners();
    }
}
