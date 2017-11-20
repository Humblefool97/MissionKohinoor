package com.fbp.example.Strings;

/**
 * Validate if a given string is numeric.
 * <p>
 * Examples:
 * <p>
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * <p>
 * Clarify the question using “See Expected Output”
 * <p>
 * Is 1u ( which may be a representation for unsigned integers valid?
 * For this problem, no.
 * Is 0.1e10 valid?
 * Yes
 * -01.1e-10?
 * Yes
 * Hexadecimal numbers like 0xFF?
 * Not for the purpose of this problem
 * 3. (. not followed by a digit)?
 * No
 * Can exponent have decimal numbers? 3e0.1?
 * Not for this problem.
 * Is 1f ( floating point number with f as prefix ) valid?
 * Not for this problem.
 * How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
 * Not for this problem.
 * How about integers preceded by 00 or 0? like 008?
 * Yes for this problem
 * Created by rajeevranganathan on 01/11/17 for TheLastChance.
 */
public class ValidNumberPending {
    public int isNumber(final String a) {

        try {
            double s = Double.parseDouble(a);
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '.') {
                    if ((i + 1) != a.length()) {
                        if (!Character.isDigit(a.charAt(i + 1)))
                            return 0;
                        else
                            break;
                    } else
                        return 0;
                }
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }
}
