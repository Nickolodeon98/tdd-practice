package DB.domain;
public class Hospital {
    private String id;
    private String address;
    private String district;
    private String category;
    private String emergencyRoom;
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String category, String emergencyRoom, String name) {
        this.id = id;
        this.address = address;
        this.category = category;
        this.emergencyRoom = emergencyRoom;
        this.name = name;
        setDistrict();
        setSubdivision();
    }

    private void setDistrict() {
        String[] addressInfo = address.split("\\s+");
        this.district = addressInfo[0] + " " + addressInfo[1];
    }

    public void setSubdivision() {
        String[] divNames = {"한의원", "한방병원", "정형외과", "교정", "관절", "화상", "봉합", "비뇨기과", "안과", "산부인과", "피부과", "성형외과", "외과", "내과", "소아과", "가정의학과", "치과"};
        subdivision = null;
        for (String divName : divNames) {
            if (name.contains(divName)) subdivision = divName;
        }
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDistrict() {
        return district;
    }

    public String getCategory() {
        return category;
    }

    public String getEmergencyRoom() {
        return emergencyRoom;
    }

    public String getName() {
        return name;
    }

    public String getSubdivision() {
        return subdivision;
    }
}
