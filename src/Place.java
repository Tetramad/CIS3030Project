import java.util.Collection;
import java.util.List;

public class Place {
    private final String name;
    private final Location location;
    private final Collection<ThemeTag> themeTags;
    private final ConvenientFacilitiesTag convenientFacilitiesTag;

    public Place(String name, Location location, Collection<ThemeTag> themeTags, ConvenientFacilitiesTag convenientFacilitiesTag) {
        this.name = name;
        this.location = location;
        this.themeTags = themeTags;
        this.convenientFacilitiesTag = convenientFacilitiesTag;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Collection<ThemeTag> getThemeTags() {
        return themeTags;
    }

    public ConvenientFacilitiesTag getConvenientFacilitiesTag() {
        return convenientFacilitiesTag;
    }
}
