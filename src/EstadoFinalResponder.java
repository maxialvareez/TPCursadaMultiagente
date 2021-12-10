import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class EstadoFinalResponder extends Behaviour {

    @Override
    public void action() {
        System.out.println("Gracias");
    }

    @Override
    public boolean done() {
        return true;
    }
}

