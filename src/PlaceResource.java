import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlaceResource {
    public List<Place> places;

    public Collection<Place> queryTheme(ThemeTag theme) {
        Collection<Place> results = new ArrayList<>();
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getThemeTags().contains(theme)) {
                results.add(places.get(i));
            }
        }
        return results;
    }

    public Collection<Place> queryConvenientFacilities(ConvenientFacilitiesTag convenientFacilitiesTag) {
        throw new UnsupportedOperationException();
    }

    public void initialize() {
        places = new ArrayList<Place>();
        List<List<String>> list = CSV.readToList("data/데이터저장.csv");
        for(int i = 1; i < list.size(); i++) {
            List<String> line = list.get(i);
            String name = line.get(0);
            double latitude = Double.parseDouble(line.get(1));
            double longitude = Double.parseDouble(line.get(2));
            List<ThemeTag> themeTags = new ArrayList<>();
            if (Integer.parseInt(line.get(3)) == 1) {
                themeTags.add(ThemeTag.Exercise);
            }
            if (Integer.parseInt(line.get(4)) == 1) {
                themeTags.add(ThemeTag.Walk);
            }
            if (Integer.parseInt(line.get(5)) == 1) {
                themeTags.add(ThemeTag.Study);
            }
            if (Integer.parseInt(line.get(6)) == 1) {
                themeTags.add(ThemeTag.Meal);
            }
            Place place = new Place(name, new Location(latitude, longitude), themeTags, new ConvenientFacilitiesTag(line.get(7)));
            places.add(place);
        }
    }
}
