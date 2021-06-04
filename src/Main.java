public class Main {
    public static void main(String[] args) {
//        String path = "C:\\Users\\윤경윤\\Desktop\\대학생 윤경윤\\3-1\\소프트웨어공학론\\소공론 프로젝트\\11주차 사용자인터페이스\\데이터저장.csv";    // 파일 경로 지정
//        List<List<String>> list = CSV.readToList(path);
//        for(int i=0; i<list.size(); i++) {
//            List<String> line = list.get(i);
//            for(int j=0; j<line.size(); j++) {
//                System.out.print(line.get(j)+" ");
//            }
//            System.out.println();
//        }

        LocationInputScreen locationInputScreen = new LocationInputScreen();
        LocationMapScreen locationMapScreen = new LocationMapScreen();
        MenuScreen menuScreen = new MenuScreen();
        ThemeMapScreen themeMapScreen = new ThemeMapScreen();
        ThemeScreen themeScreen = new ThemeScreen();

        LocationControl locationControl = new LocationControl();
        MapInformation mapInformation = new MapInformation();
        ThemeControl themeControl = new ThemeControl();
        PlaceResource placeResource = new PlaceResource();

        UserLocation userLocation = new UserLocation();

        locationInputScreen.initialize(locationControl, menuScreen);
        locationMapScreen.initialize(menuScreen);
        menuScreen.initialize(locationInputScreen, themeScreen);
        themeMapScreen.initialize(themeScreen);
        themeScreen.initialize(menuScreen, themeControl);

        locationControl.initialize(locationMapScreen, mapInformation, userLocation);
        mapInformation.initialize();
        themeControl.initialize(themeMapScreen, userLocation, placeResource);
        placeResource.initialize();

        userLocation.initialize();

        locationInputScreen.show();
    }
}
