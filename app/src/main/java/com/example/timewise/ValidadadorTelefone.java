package com.example.timewise;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ValidadadorTelefone {
    public static final Pattern PHONE = Pattern.compile(
            "(\\+[0-9]+[\\- \\.]*)?"
                    + "(\\([0-9]+\\)[\\- \\.]*)?"
                    + "([0-9][0-9\\- \\.]+[0-9])");

    public static boolean isTelValid(String telefone) {
        Matcher matcher = PHONE.matcher(telefone);
        return matcher.matches();

}}
