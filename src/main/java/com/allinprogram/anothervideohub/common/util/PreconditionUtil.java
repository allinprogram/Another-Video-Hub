package com.allinprogram.anothervideohub.common.util;

/**
 * PreconditonUtil
 *
 * @author AllinProgram
 * @since 2022-04-27 18:31 ζζδΈ
 */
public class PreconditionUtil {

    public static void checkArgument(boolean condition, String message) {
        if (!condition) {
            throw new RuntimeException(message);
        }
    }
}