package patterns.chainresp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {

    private String data;
    private int code;

}
