package com.company.utils;

/**
 * Утилитный класс. Для жизни и работы которого не требуется экземпляр данного
 * класса, поскольку он не имеет состояния. Использует только статические
 * методы и переменные.
 */
public class ValidationUtil {

    private ValidationUtil() {
    }

    /**
     * Метод который преобразовывает строку в число. Выбрасывает
     * NumberFormatException при неудаче, который необходимо обработать.
     */
    static public int checkNumber(String number) { // проверяет введен ли int ?
        return new Integer(number);
    }
/*    static public int checkPhone(String PhoneNumber) { // провер правильность ввода тел номера
        return new Integer(PhoneNumber);
    }*/

}
