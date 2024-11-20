package modelos;

public enum Platform{
    Wii, 
    NES, 
    GB, 
    DS, 
    X360, 
    PS3, 
    PS2, 
    SNES, 
    GBA, 
    PS4, 
    PS, 
    _3DS, 
    _2600, 
    GC, 
    WiiU, 
    XB, 
    PC, 
    GEN, 
    N64, 
    XOne, 
    PSP,
    PSV,
    DC,
    SAT,
    PCFX,
    NG,
    SCD,
    WS,
    TG16,
    GG,
    _3DO;
	
	// Método para mapear los valores del CSV al Enum
    public static Platform fromString(String platformText) {
        switch (platformText) {
            case "3DS":
                return _3DS; 
            case "2600":
            	return _2600;
            case "3DO":
            	return _3DO;
            default:
                return Platform.valueOf(platformText); // Si coincide exactamente, usar el valor del Enum
        }
    }
	
	
};
