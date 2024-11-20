package modelos;

public enum Genre{
    Action,
    Adventure,
    Fighting,
    Misc,
    Platform,
    Puzzle,
    Racing,
    Role_Playing,
    Shooter,
    Simulation,
    Sports,
    Strategy;

    //Método para mapear los valores del CSV al Enum
	public static Genre fromString(String genreText) {
        return switch (genreText) {
            case "Role-Playing" -> Role_Playing;
            default -> Genre.valueOf(genreText);
        }; // Si coincide exactamente, usar el valor del Enum
	}
};
