package patterns.chainresp.processor.impl;

import patterns.chainresp.Request;
import patterns.chainresp.processor.RequestProcessor;

public class RegistrarRequestProcessor extends RequestProcessor {

    @Override
    public void handle(Request request) {
        System.out.println("RegistrarRequestProcessor:\n" + request);

        getNextProcessor()
                .ifPresent(processor -> processor.handle(request));
    }

}
