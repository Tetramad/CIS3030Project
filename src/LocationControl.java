public class LocationControl {
    private LocationMapScreen locationMapScreen;
    private MapInformation mapInformation;
    private UserLocation userLocation;

    public LocationControl() {}

    public void initialize(LocationMapScreen locationMapScreen, MapInformation mapInformation, UserLocation userLocation) {
        this.locationMapScreen = locationMapScreen;
        this.mapInformation = mapInformation;
        this.userLocation = userLocation;
    }

    public boolean checkLocationInput(String latitude, String longitude) {
        if (!validate(latitude) || !validate(longitude)) {
            return false;
        }

        double convertedLatitude = Double.parseDouble(latitude);
        double convertedLongitude = Double.parseDouble(longitude);

        if (!mapInformation.checkBoundary(new Location(convertedLatitude, convertedLongitude))) {
            return false;
        }

        userLocation.store(convertedLatitude, convertedLongitude);
        locationMapScreen.show(userLocation);
        return true;
    }

    private boolean validate(String value) {
        value.trim();
        if (value.matches(".*[^0-9.]+.*")) {
            return false;
        }
        if (value.codePoints().filter(ch -> ch == '.').count() >= 2) {
            return false;
        }
        if (!value.matches("[0-9]+(.[0-9]*)?")) {
            return false;
        }
        return true;
    }
}
