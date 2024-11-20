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
	    switch (genreText) {
	        case "Role-Playing":
	            return Role_Playing;
	        default:
	            return Genre.valueOf(genreText); // Si coincide exactamente, usar el valor del Enum
	    }
	}
};


