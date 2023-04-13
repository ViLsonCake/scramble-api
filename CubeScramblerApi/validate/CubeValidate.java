package com.project.CubeScramblerApi.CubeScramblerApi.validate;

public class CubeValidate {

    public static boolean isCubeValid(String cube) {
        return switch (cube) {
            case "2x2", "3x3", "4x4", "5x5", "6x6", "7x7" -> true;
            default -> false;
        };
    }
}
