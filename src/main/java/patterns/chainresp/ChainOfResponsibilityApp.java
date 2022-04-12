package patterns.chainresp;

import patterns.chainresp.processor.RequestProcessor;
import patterns.chainresp.processor.impl.EnrichRequestProcessor;
import patterns.chainresp.processor.impl.LogRequestProcessor;
import patterns.chainresp.processor.impl.RegistrarRequestProcessor;

/**
 * Паттерн "Цепочка обязанностей"
 * Используется, когда вы хотите предоставить нескольким объектам возможность обработать запрос.
 */
public class ChainOfResponsibilityApp {

    public static void main(String[] args) {
        RequestProcessor processor = new LogRequestProcessor();
        processor
                .setNextProcessor(new RegistrarRequestProcessor())
                .setNextProcessor(new EnrichRequestProcessor());

        processor.handle(Request.builder()
                .data("Request1")
                .code(100)
                .build());
    }

}
