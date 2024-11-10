package ui;

import java.util.Scanner;

import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("4. Consult a Species");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:
					deleteSpecies();
					break;
				case 4:
					showSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;

			}

		}

	}

	public void registerSpecies() {
		int typeOfFlora = 0;
		int flowers = 0;
		int fruits = 0;
		int height = 0;
		int typeOfFauna = 0;
		int migrate = 0;
		int weight = 0;
		System.out.println("Enter the type of species" + "\n" +
				"1. Flora" + "\n" +
				"2. Fauna");
		int typeOfSpecies = reader.nextInt();
		reader.nextLine();
		System.out.println("Type the new Species' name: ");
		String name = reader.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		if (typeOfSpecies == 1) {
			System.out.println("What is the type of flora species?" + "\n" +
					"1.land" + "\n" +
					"2.aquatic");
			typeOfFlora = reader.nextInt();
			reader.nextLine();
			System.out.println("Does this species have flowers?" + "\n" +
					"1.yes" + "\n" +
					"2.no");
			flowers = reader.nextInt();
			System.out.println("Does this species have fruits?" + "\n" +
					"1.yes" + "\n" +
					"2.no");
			fruits = reader.nextInt();
			System.out.println("What is its maximum possible height?");
			height = reader.nextInt();
			reader.nextLine();
		} else if (typeOfSpecies == 2) {
			System.out.println("What is the type of animal?" + "\n" +
					"1.bird" + "\n" +
					"2.mammal" + "\n" +
					"3.aquatic");
			typeOfFauna = reader.nextInt();
			reader.nextLine();
			System.out.println("does this species migrate?" + "\n" +
					"1.yes" + "\n" +
					"2.no");
			migrate = reader.nextInt();
			System.out.println("What is its maximum possible weight?");
			weight = reader.nextInt();
			reader.nextLine();
		}

		if (typeOfSpecies == 1
				&& speciesController.registerSpecies(name, scientificName, typeOfFlora, flowers, fruits, height)) {

			System.out.println("Species registered successfullyyy");

		} else if (typeOfSpecies == 2
				&& speciesController.registerSpecies(name, scientificName, typeOfFauna, migrate, weight)) {

			System.out.println("Species registered successfully");

		}

		else {
			System.out.println("Error, Species couldn't be registered");
		}

	}

	public void editSpecies() {
		String newName = "";
		String newScientificName = "";
		int newTypeOfFlora = 0;
		int newHeight = 0;
		int newTypeOfFauna = 0;
		int newWeight = 0;

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showSpeciesListToEdit();

		if (!query.equals("")) {
			System.out.println(query);
			System.out.println("Which one do you want to edit?");
			int specieToEdit = reader.nextInt();
			System.out.println("What is the type of species to be modified?");
			System.out.println("1.flora" + "\n" + "2.fauna");
			int typeOfSpecies = reader.nextInt();
			reader.nextLine();
			System.out.println("Choose :" + "\n" +
					"1.Name" + "\n" +
					"2.Scientific Name" + "\n" +
					"3.Type");
			if (typeOfSpecies == 1) {
				System.out.println("4.Flowers" + "\n" +
						"5.Fruits" + "\n" +
						"6.Maximum Height");
			} else if (typeOfSpecies == 2) {
				System.out.println("4.Migratory" + "\n" +
						"5.Maximum Weight");

			}
			int option = reader.nextInt();
			reader.nextLine();
			switch (option) {
				case 1:
					System.out.println("Type the new Name");
					newName = reader.nextLine();
					if (speciesController.modifySpecies(specieToEdit, option, newName, newScientificName,
							newTypeOfFlora, newHeight, newTypeOfFauna, newWeight)) {
						System.out.println("Species modified");
					} else {
						System.out.println("Error, Species couldn't be modified");
					}

					break;
				case 2:
					System.out.println("Type the new Scientific Name");
					newScientificName = reader.nextLine();
					if (speciesController.modifySpecies(specieToEdit, option, newName, newScientificName,
							newTypeOfFlora, newHeight, newTypeOfFauna, newWeight)) {
						System.out.println("Species modified");
					} else {
						System.out.println("Error, Species couldn't be modified");
					}
					break;
				case 3:
					if (typeOfSpecies == 2) {
						System.out.println("Enter the new type of fauna" + "1.bird" + "\n" +
								"2.mammal" + "\n" +
								"3.aquatic");
						newTypeOfFauna = reader.nextInt();
						reader.nextLine();
						if (speciesController.modifySpecies(specieToEdit, option, newName, newScientificName,
								newTypeOfFlora, newHeight, newTypeOfFauna, newWeight)) {
							System.out.println("Species modified");
						} else {
							System.out.println("Error, Species couldn't be modified");
						}

					}

					break;
				case 4:
					if (speciesController.modifySpecies(specieToEdit, option, newName, newScientificName,
							newTypeOfFlora, newHeight, newTypeOfFauna, newWeight)) {
						System.out.println("Species modified");
					} else {
						System.out.println("Error, Species couldn't be modified");
					}
					break;
				case 5:
					if (speciesController.modifySpecies(specieToEdit, option, newName, newScientificName,
							newTypeOfFlora, newHeight, newTypeOfFauna, newWeight)) {
						System.out.println("Species modified");
					} else {
						System.out.println("Error, Species couldn't be modified");
					}
					break;
				case 6:
					System.out.println("Type the new Maximum Height");
					newHeight = reader.nextInt();
					reader.nextLine();
					if (speciesController.modifySpecies(specieToEdit, option, newName, newScientificName,
							newTypeOfFlora, newHeight, newTypeOfFauna, newWeight)) {
						System.out.println("Species modified");
					} else {
						System.out.println("Error, Species couldn't be modified");
					}
					break;

				default:
					break;
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void deleteSpecies() {
		int SpecieToDelete = 0;
		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			SpecieToDelete = reader.nextInt();
			reader.nextLine();
			if (speciesController.removeSpecies(SpecieToDelete)) {
				System.out.println("Species deleted successfully");
			} else {
				System.out.println("Error, Species couldn't be deleted");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void showSpecies() {

		System.out.println("Which Species do you want to review?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);
			reader.nextLine();
			int specieToShow = reader.nextInt();
			reader.nextLine();
			System.out.println(speciesController.showSpecies(specieToShow));

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}
