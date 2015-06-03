package lt.inventi.playground;

import tps.bpel.pingpong.*;

/**
 * Created by GreenFigure on 2015-06-03.
 */
public class RequestManager {
    public EchoInputResponse fromRequestToResponse(EchoInput ei){
        EchoInputResponse eir = new EchoInputResponse();
        eir.setEchoInputReturn(ei.getInput());
        return eir;
    }
}
