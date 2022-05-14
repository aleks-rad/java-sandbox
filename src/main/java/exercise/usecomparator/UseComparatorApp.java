package exercise.usecomparator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;

import static utils.Utils.println;

/**
 * Просто использую компаратор в функциональном стиле
 */
public class UseComparatorApp {

    public static void main(String[] args) {
        Document[] documents = {
                new Document(1, "A document", 1998),
                new Document(2, "Aaa document", 2004),
                new Document(3, "N document", 1998),
                new Document(4, "B document", 2003),
                new Document(5, "E document", 1994),
                new Document(6, "Aa document", 2003)
        };

        Arrays.sort(documents, Comparator.comparing(Document::getYear, Comparator.reverseOrder())
                .thenComparing(Document::getName));

        println("documents\n" + Arrays.toString(documents));
    }

    @Getter
    @AllArgsConstructor
    static class Document {
        private final int id;
        private final String name;
        private final int year;

        @Override
        public String toString(){
            return String.format("%d) \"%s\" (%d)\n", id, name, year);
        }
    }

}
