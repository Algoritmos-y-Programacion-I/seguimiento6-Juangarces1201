package model;

public class Species {

	private String commonName;
	private String scientificName;
	private SpeciesType speciesType;

	public Species(String commonName, String scientificName, SpeciesType speciesType) {
		this.commonName = commonName;
		this.scientificName = scientificName;
		this.speciesType = speciesType;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public SpeciesType getSpeciesType() {
		return speciesType;
	}

	public void setSpeciesType(SpeciesType speciesType) {
		this.speciesType = speciesType;
	}

	@Override
	public String toString() {
		return "Common Name: " + commonName + "\n" +
				"Scientific Name: " + scientificName + "\n" +
				"Species Type: " + speciesType;
	}

	public String speciesTypeToString() {
		return speciesType.toString();
	}
}
