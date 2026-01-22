public class Product {
    private String id;
    private String name;
    private String desc;
    private double cost;

    // Constructor
    public Product(String id, String name, String desc, double cost) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    // Getters and Setters

    public String getId() {
        return id; }
    public String getName() {
        return name; }
    public String getDesc() {
        return desc; }
    public double getCost() {
        return cost; }

    public void setName(String name) {
        this.name = name; }
    public void setDesc(String desc) {
        this.desc = desc; }
    public void setCost(double cost) {
        this.cost = cost; }

    // Methods
    @Override
    public String toString() {
        return String.format("%s - %s: %s ($%.2f)", id, name, desc, cost);
    }

    public String toCSV() {
        return String.format("%s,%s,%s,%.2f", id, name, desc, cost);
    }
    public String toJSON() {
        return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"desc\":\"%s\",\"cost\":%.2f}", id, name, desc, cost);
    }
    public String toXML() {
        return String.format("<product><id>%s</id><name>%s</name><desc>%s</desc><cost>%.2f</cost></product>", id, name, desc, cost);
    }
}
