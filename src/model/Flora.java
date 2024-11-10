package model;

public class Flora extends Species {

    private Boolean flowers;
    private Boolean fruits;
    private double maxHeight;

    public Flora(String commonName, String scientificName, Boolean flowers, Boolean fruits, double maxHeight,
            SpeciesType speciesType) {
        super(commonName, scientificName, speciesType);
        this.flowers = flowers;
        this.fruits = fruits;
        this.maxHeight = maxHeight;
    }

    public Boolean getFlowers() {
        return flowers;
    }

    public void setFlowers(Boolean flowers) {
        this.flowers = flowers;
    }

    public Boolean getFruits() {
        return fruits;
    }

    public void setFruits(Boolean fruits) {
        this.fruits = fruits;
    }

    public double getHeight() {
        return maxHeight;
    }

    public void setHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String flowersToString() {
        return flowers ? "yes" : "no";
    }

    public String fruitsToString() {
        return fruits ? "yes" : "no";
    }

    @Override
    public String speciesTypeToString() {
        return getSpeciesType() == SpeciesType.LAND_FLORA ? "Flora: Land" : "Flora: Aquatic";
    }

    @Override
    public String toString() {
        return "Common Name: " + getCommonName() + "\n" +
                "Scientific Name: " + getScientificName() + "\n" +
                "Type: " + speciesTypeToString() + "\n" +
                "Flowers: " + flowersToString() + "\n" +
                "Fruits: " + fruitsToString() + "\n" +
                "Max Height: " + maxHeight;
    }
}
