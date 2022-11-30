class Util {
    public static String capitalize(String str) {
        System.out.printf("Before: %s\n", str);
        if (str == null || str.isBlank()) {
            System.out.printf("After: %s", str.toUpperCase());
            return str;
        }

        if (str.length() == 1) {
            System.out.printf("After: %s", str.toUpperCase());
            return str.toUpperCase();
        }
        System.out.printf("After: %s", Character.toUpperCase(str.charAt(0)) + str.substring(1));
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}