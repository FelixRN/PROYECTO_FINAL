package com.pfrñfe.model.entities;

public enum ExpenseType {
    GASOLINA("gasolina"),
    REVISION("revision"),
    ITV("itv"),
    CAMBIO_ACEITE("cambio_aceite"),
    OTROS("otros");
    
    private final String value;
    
    ExpenseType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    // Método para convertir desde string de base de datos
    public static ExpenseType fromString(String text) {
        if (text != null) {
            for (ExpenseType type : ExpenseType.values()) {
                if (text.equalsIgnoreCase(type.value)) {
                    return type;
                }
            }
        }
        throw new IllegalArgumentException("No se encontró el tipo de gasto: " + text);
    }
    
    // Método adicional para obtener todos los valores como String
    public static String[] getValuesAsString() {
        ExpenseType[] types = ExpenseType.values();
        String[] result = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            result[i] = types[i].getValue();
        }
        return result;
    }
}