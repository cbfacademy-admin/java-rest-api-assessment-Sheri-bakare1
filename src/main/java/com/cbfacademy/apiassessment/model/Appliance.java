import com.fasterxml.jackson.annotation.JsonProperty;

public class Appliance {
    private String name;
    @JsonProperty("desc")
    private String description;
    private String type;
    private int price;

    // Constructor
    public Appliance(String name, String description, String type, int price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}


