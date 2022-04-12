package patterns.chainresp.processor;

import patterns.chainresp.Request;

import java.util.Optional;

public abstract class RequestProcessor {

    private RequestProcessor nextProcessor;

    public RequestProcessor setNextProcessor(RequestProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
        return this.nextProcessor;
    }

    protected Optional<RequestProcessor> getNextProcessor(){
        return Optional.ofNullable(nextProcessor);
    }

    public abstract void handle(Request request);

}
