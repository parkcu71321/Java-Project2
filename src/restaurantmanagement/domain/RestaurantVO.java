package restaurantmanagement.domain;

import java.util.Date;

public class RestaurantVO {
    private int restaurantId; // DB: GENERATED ALWAYS AS IDENTITY
    private String restaurantName;
    private String location;
    private String phone;
    private String categoryCode; // CH, CA, ST, CO
    private String intro;
    private Date registerDate;

    public int getRestaurantId() { return restaurantId; }
    public void setRestaurantId(int restaurantId) { this.restaurantId = restaurantId; }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCategoryCode() { return categoryCode; }
    public void setCategoryCode(String categoryCode) { this.categoryCode = categoryCode; }

    public String getIntro() { return intro; }
    public void setIntro(String intro) { this.intro = intro; }

    public Date getRegisterDate() { return registerDate; }
    public void setRegisterDate(Date registerDate) { this.registerDate = registerDate; }
}
