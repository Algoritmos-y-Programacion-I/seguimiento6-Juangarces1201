package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	// flora
	public boolean registerSpecies(String name, String scientificName, int typeOfFlora, int opFlowers, int opFruits,
			double maxHeight) {
		SpeciesType type = SpeciesType.LAND_FLORA;
		boolean flowers = false;
		boolean fruits = false;
		if (typeOfFlora == 1) {
			type = SpeciesType.LAND_FLORA;

		} else if (typeOfFlora == 2) {
			type = SpeciesType.AQUATIC_FLORA;

		}
		switch (opFlowers) {
			case 1:
				flowers = true;
				break;
			case 2:
				flowers = false;
				break;

			default:
				flowers = false;
				break;
		}
		switch (opFruits) {
			case 1:
				fruits = true;
				break;
			case 2:
				fruits = false;
				break;

			default:
				fruits = false;
				break;
		}

		Species flora = new Flora(name, scientificName, flowers, fruits, maxHeight, type);
		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = flora;
				return true;
			}

		}

		return false;

	}

	// fauna
	public boolean registerSpecies(String name, String scientificName, int typeOfFauna, int opMigratory,
			double maximumWeight) {
		boolean migratory = false;
		SpeciesType type = SpeciesType.MAMMAL;
		if (opMigratory == 1) {
			migratory = true;
		} else if (opMigratory == 2) {
			migratory = false;

		}

		switch (typeOfFauna) {
			case 1:
				type = SpeciesType.BIRD;
				break;
			case 2:
				type = SpeciesType.MAMMAL;
				break;
			case 3:
				type = SpeciesType.AQUATIC_FAUNA;
				break;
			default:
				type = SpeciesType.MAMMAL;
				break;
		}

		Species fauna = new Fauna(name, scientificName, migratory, maximumWeight, type);

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = fauna;
				return true;
			}

		}

		return false;

	}

	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getCommonName();
			}
		}

		return msg;

	}

	public String showSpeciesListToEdit() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getCommonName() + " , Type - "
						+ species[i].speciesTypeToString();
			}
		}

		return msg;

	}

	public boolean removeSpecies(int SpecieToDelete) {
		boolean result = false;
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[SpecieToDelete - 1] != null) {
				species[SpecieToDelete - 1] = null;
				result = true;
				break;

			}
		}
		return result;
	}

	public String showSpecies(int SpecieToShow) {
		String msj = "";
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[SpecieToShow - 1] != null) {

				msj = species[SpecieToShow - 1].toString();

				break;

			}
		}

		return msj;
	}

	public boolean modifySpecies(int specieToEdit, int option, String newName, String newScientificName,
			int newTypeOfFlora, int newHeight, int newTypeOfFauna, int newWeight) {
		boolean result = false;
		switch (option) {
			case 1:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieToEdit - 1] != null) {
						species[specieToEdit - 1].setCommonName(newName);
						result = true;
					}
				}
				break;

			case 2:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieToEdit - 1] != null) {
						species[specieToEdit - 1].setScientificName(newScientificName);
						result = true;

					}
				}
				break;
			case 3:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieToEdit - 1] != null) {
						if (species[specieToEdit - 1] instanceof Flora) {

							if (species[specieToEdit - 1].getSpeciesType() == SpeciesType.LAND_FLORA) {
								species[specieToEdit - 1].setSpeciesType(SpeciesType.AQUATIC_FLORA);
							} else if (species[specieToEdit - 1].getSpeciesType() == SpeciesType.AQUATIC_FLORA) {
								species[specieToEdit - 1].setSpeciesType(SpeciesType.LAND_FLORA);
							}
						} else if (species[specieToEdit - 1] instanceof Fauna) {
							Fauna fauna = (Fauna) species[specieToEdit - 1];
							switch (newTypeOfFauna) {
								case 1:
									fauna.setSpeciesType(SpeciesType.BIRD);
									break;
								case 2:
									fauna.setSpeciesType(SpeciesType.MAMMAL);
									break;
								case 3:
									fauna.setSpeciesType(SpeciesType.AQUATIC_FAUNA);
									break;

								default:
									break;
							}

						}
						result = true;

					}
				}
				break;
			case 4:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieToEdit - 1] != null) {
						if (species[specieToEdit - 1] instanceof Flora) {
							Flora flora = (Flora) species[specieToEdit - 1];
							if (flora.getFlowers()) {
								flora.setFlowers(false);
							} else {
								flora.setFlowers(true);
							}
						} else if (species[specieToEdit - 1] instanceof Fauna) {
							Fauna fauna = (Fauna) species[specieToEdit - 1];
							if (fauna.getMigratory()) {
								fauna.setMigratory(false);
							} else {
								fauna.setMigratory(true);
							}

						}
						result = true;

					}
				}
				break;
			case 5:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieToEdit - 1] != null) {
						if (species[specieToEdit - 1] instanceof Flora) {
							Flora flora = (Flora) species[specieToEdit - 1];
							if (flora.getFruits()) {
								flora.setFruits(false);
							} else {
								flora.setFruits(true);
							}
						} else if (species[specieToEdit - 1] instanceof Fauna) {
							Fauna fauna = (Fauna) species[specieToEdit - 1];
							fauna.setMaximumWeight(newWeight);
						}
						result = true;

					}
				}
				break;

			case 6:
				for (int i = 0; i < species.length; i++) {
					if (species[i] != null && species[specieToEdit - 1] != null) {
						if (species[specieToEdit - 1] instanceof Flora) {
							Flora flora = (Flora) species[specieToEdit - 1];
							flora.setHeight(newHeight);
							result = true;
							break;

						}
					}

				}

				break;

		}
		return result;
	}
}
