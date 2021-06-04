public class UserLocation {
    private Location location;

    public UserLocation() {
        this.location = null;
    }

    public Location getUserLocation() {
        return location;
    }

    public void store(double latitude, double longitude) {
        this.location = new Location(latitude, longitude);
    }

    public void initialize() {
    }
}
