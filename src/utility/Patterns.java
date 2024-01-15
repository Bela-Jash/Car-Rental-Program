package utility;

import java.util.regex.Pattern;

public abstract class Patterns {
    // ====================== Patterns for the Fields ======================
    public static final Pattern noPattern = Pattern.compile("[!-~ ]{1,100}");
    public static final Pattern namePattern = Pattern.compile("[A-z]{1,25} [A-z]{1,25}");
    public static final Pattern phoneNumberPattern = Pattern.compile("0[79][0-9]{8}");
    public static final Pattern emailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    public static final Pattern passwordPattern = Pattern.compile("[!-~ ]{8,25}");

    public static final Pattern carBrandPattern = Pattern.compile("[0-9A-z- ]{1,100}");
    public static final Pattern carModelPattern = Pattern.compile("[0-9A-z- ]{1,100}");
    public static final Pattern carTypePattern = Pattern.compile("[A-z ]{1,100}");
    public static final Pattern carColorPattern = Pattern.compile("[A-z ]{1,100}");
}
