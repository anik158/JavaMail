package com.ahsan.view;

public enum ColorTheme {
    LIGHT,
    DARK,
    DEFAULT;

    public static String getCssPath(ColorTheme theme) {
        return switch (theme) {
            case LIGHT -> "css/themeLight.css";
            case DARK -> "css/themeDark.css";
            case DEFAULT -> "css/themeDefault.css";
            default -> null;
        };
    }
}
