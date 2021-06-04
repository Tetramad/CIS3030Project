import javax.swing.*;
import java.awt.*;

public class MapInformation {
    private static Location topLeftCorner = new Location(35.182890, 126.895623);
    private static Location bottomRightCorner = new Location(35.172066,126.914912);

    public MapInformation() {
    }

    public static ImagePanel addMapImage(JPanel panelMap) {
        ImagePanel map = new ImagePanel("img/Map.png");
        map.setLayout(null);
        panelMap.add(map, BorderLayout.CENTER);
        return map;
    }

    public static void addMarkerImage(ImagePanel map, Location location) {
        ImagePanel marker = new ImagePanel("img/Marker.png");
        map.add(marker);
        Insets insets = map.getInsets();
        int left = (int)Math.round((location.getLongitude() - topLeftCorner.getLongitude()) / (bottomRightCorner.getLongitude() - topLeftCorner.getLongitude()) * map.getWidth());
        int top = (int)Math.round((location.getLatitude() - bottomRightCorner.getLatitude()) / (topLeftCorner.getLatitude() - bottomRightCorner.getLatitude()) * map.getHeight());
        marker.setBounds(left + insets.left, map.getHeight() - top, marker.getWidth(), marker.getHeight());
    }

    public boolean checkBoundary(Location location) {
        return !(location.getLatitude() > topLeftCorner.getLatitude()
        || location.getLongitude() < topLeftCorner.getLongitude()
        || location.getLatitude() < bottomRightCorner.getLatitude()
        || location.getLongitude() > bottomRightCorner.getLongitude());
    }

    public void initialize() {
    }
}
