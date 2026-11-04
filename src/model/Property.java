package model;

public class Property {

    private int propertyId;
    private String title;
    private String description;
    private String propertyType;
    private int bhk;
    private int areaSqft;
    private double price;
    private String city;
    private String locality;
    private String address;
    private String status;
    private String ownerName;
    private String ownerPhone;
    private String imagePath;

    // Constructor
    public Property(int propertyId, String title, String description,
                    String propertyType, int bhk, int areaSqft,
                    double price, String city, String locality,
                    String address, String status, String ownerName,
                    String ownerPhone, String imagePath) {

        this.propertyId = propertyId;
        this.title = title;
        this.description = description;
        this.propertyType = propertyType;
        this.bhk = bhk;
        this.areaSqft = areaSqft;
        this.price = price;
        this.city = city;
        this.locality = locality;
        this.address = address;
        this.status = status;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.imagePath = imagePath;
    }

    // Getters and Setters

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getBhk() {
        return bhk;
    }

    public void setBhk(int bhk) {
        this.bhk = bhk;
    }

    public int getAreaSqft() {
        return areaSqft;
    }

    public void setAreaSqft(int areaSqft) {
        this.areaSqft = areaSqft;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return title + " - " + locality + " - ₹" + price;
    }
}