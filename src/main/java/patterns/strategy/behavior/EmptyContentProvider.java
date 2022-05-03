package patterns.strategy.behavior;

public class EmptyContentProvider implements ContentProvider {

    @Override
    public String getContent() {
        return "";
    }

}
