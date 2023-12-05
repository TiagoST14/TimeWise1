package com.example.timewise;

public class ValidadorCPF {
    public static boolean isValidCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (isAllDigitsEqual(cpf)) {
            return false;
        }

        // Calcula os dígitos verificadores
        int d1 = calculateDigit(cpf.substring(0, 9));
        int d2 = calculateDigit(cpf.substring(0, 9) + d1);

        // Verifica se os dígitos calculados são iguais aos informados
        return cpf.equals(cpf.substring(0, 9) + String.valueOf(d1) + String.valueOf(d2));
    }

    // verificar se numeros são iguais
    private static boolean isAllDigitsEqual(String str) {
        char firstDigit = str.charAt(0);
        for (char digit : str.toCharArray()) {
            if (digit != firstDigit) {
                return false;
            }
        }
        return true;
    }

    private static int calculateDigit(String str) {
        int sum = 0;
        int weight = str.length() + 1;

        for (char digit : str.toCharArray()) {
            sum += Character.getNumericValue(digit) * weight--;
        }

        int remainder = sum % 11;

        return remainder < 2 ? 0 : 11 - remainder;
    }
}
