package car.file.utils;

public class NumberUtility {
    public static int sanitize(String text){
        return Integer.parseInt(text);
    }

    public static int sanitizePrice(String text){
        String newText = text;
        newText = text.replaceAll("\"", "");
        newText = newText.replaceAll(" ", "");
        newText = newText.replace("£", "");
        newText = newText.replaceAll(",", "");

        return Integer.valueOf(newText);
    }
}
