package patterns.strategy.behavior;

public class JsonContentProvider implements ContentProvider {

    @Override
    public String getContent() {
        return "{\n" +
                "\t\"code\": \"YRT001\",\n" +
                "\t\"count\": 42,\n" +
                "\t\"data\": \"00011010010\"\n" +
                "}";
    }

}
