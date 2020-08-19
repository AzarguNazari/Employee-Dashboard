package com.dashboard.common;

import java.util.regex.Pattern;

public class Util {

    public static boolean isIBANvalid(String IBAN){
        return Pattern.compile("[DE]{2}[0-9]{20}").matcher(IBAN).find();
    }

}
