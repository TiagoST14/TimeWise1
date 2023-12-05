package com.example.timewise;

public class ValidadorRg {
    public static boolean isValidRG(String rg) {
        // Remove caracteres não numéricos
        rg = rg.replaceAll("[^\\d]", "");

        // Verifica se o RG possui 9 dígitos
        if (rg.length() != 9) {
            return false;
        }

        // Calcula o dígito verificador
        int d = calculateRGDigit(rg.substring(0, 8));

        // Verifica se o dígito calculado é igual ao informado
        return rg.equals(rg.substring(0, 8) + String.valueOf(d));
    }

    private static int calculateRGDigit(String str) {
        int sum = 0;
        int weight = str.length() + 1;

        for (char digit : str.toCharArray()) {
            sum += Character.getNumericValue(digit) * weight--;
        }

        int remainder = sum % 11;
        int digit = 11 - remainder;

        // Tratamento especial para o dígito 10
        if (digit == 10) {
            return 0;
        }

        // Tratamento especial para o dígito 11
        if (digit == 11) {
            return 1;
        }

        return digit;
    }

}
