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
    NG;

    // Método para mapear los valores del CSV al Enum
    public static Platform fromString(String platformText) {
        return switch (platformText) {
            case "3DS" -> _3DS;
            case "2600" -> _2600;
            default -> Platform.valueOf(platformText);
        }; // Si coincide exactamente, usar el valor del Enum
    }
};
