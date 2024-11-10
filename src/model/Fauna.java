package model;

public class Fauna extends Species {

    private Boolean migratory;
    private double maximumWeight;

    public Fauna(String commonName, String scientificName, Boolean migratory, double maximumWeight,
            SpeciesType speciesType) {
        super(commonName, scientificName, speciesType);
        this.migratory = migratory;
        this.maximumWeight = maximumWeight;
    }

    public Boolean getMigratory() {
        return migratory;
    }

    public void setMigratory(Boolean migratory) {
        this.migratory = migratory;
    }

    public double getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(double maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public String migratoryToString() {
        return migratory ? "yes" : "no";
    }

    @Override
    public String speciesTypeToString() {
        switch (getSpeciesType()) {
            case BIRD:
                return "Fauna: Bird";
            case MAMMAL:
                return "Fauna: Mammal";
            case AQUATIC_FAUNA:
                return "Fauna: Aquatic";
            default:
                return "Fauna: Unknown";
        }
    }

    @Override
    public String toString() {
        return "Common Name: " + getCommonName() + "\n" +
                "Scientific Name: " + getScientificName() + "\n" +
                "Type: " + speciesTypeToString() + "\n" +
                "Migratory: " + migratoryToString() + "\n" +
                "Max Weight: " + maximumWeight;
    }
}
