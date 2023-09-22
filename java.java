import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введите выражение (например, 2 + 2 или II + III):");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Некорректное выражение");
            }

            String operand1 = parts[0];
            String operator = parts[1];
            String operand2 = parts[2];

            boolean isRoman = isRomanNumber(operand1) && isRomanNumber(operand2);

            int num1 = isRoman ? romanToArabic(operand1) : Integer.parseInt(operand1);
            int num2 = isRoman ? romanToArabic(operand2) : Integer.parseInt(operand2);

            int result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль недопустимо");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Недопустимая операция: " + operator);
            }

            if (isRoman) {
                if (result <= 0) {
                    throw new IllegalArgumentException("Результат меньше или равен нулю в римских числах");
                }
                String romanResult = arabicToRoman(result);
                System.out.println("Результат: " + romanResult);
            } else {
                System.out.println("Результат: " + result);
            }

        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Неправильный формат чисел.");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static boolean isRomanNumber(String s) {
        return s.matches("^[IVXLCDM]+$");
    }

    private static int romanToArabic(String s) {
        // Реализация преобразования римских чисел в арабские числа
        // ...
    }

    private static String arabicToRoman(int num) {
        // Реализация преобразования арабских чисел в римские числа
        // ...
    }
}
