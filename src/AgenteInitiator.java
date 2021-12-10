import jade.core.Agent;

import java.util.ArrayList;
import java.util.List;

public class AgenteInitiator extends Agent{


    protected void setup() {
            this.addBehaviour(new FSMInitiator());
        }


}
