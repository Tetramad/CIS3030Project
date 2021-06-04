import java.util.ArrayList;
import java.util.Collection;

public class ThemeControl {
    private ThemeMapScreen themeMapScreen;
    private UserLocation userLocation;
    private PlaceResource placeResource;

    public void initialize(ThemeMapScreen themeMapScreen, UserLocation userLocation, PlaceResource placeResource) {
        this.themeMapScreen = themeMapScreen;
        this.userLocation = userLocation;
        this.placeResource = placeResource;
    }

    public void selectTheme(ThemeTag themeTag) {
        themeMapScreen.show(userLocation, themeTag, placeResource.queryTheme(themeTag));
    }
}
