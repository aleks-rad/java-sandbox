package patterns.strategy.behavior;

public class XmlContentProvider implements ContentProvider {

    @Override
    public String getContent() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<root>\n" +
                "  <code>YRT001</code>\n" +
                "  <count>42</count>\n" +
                "  <data>00011010010</data>\n" +
                "</root>";
    }

}
