import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class EstadoFinalInitiator extends Behaviour {

    @Override
    public void action() {
        ACLMessage msg = (ACLMessage) this.getDataStore().get("mensaje accept");
        if (msg != null) {
            System.out.println("Ok, cocinaré eso entonces");
            ACLMessage respuesta = msg.createReply();
            respuesta.setPerformative(ACLMessage.CONFIRM);
            respuesta.setContent("Ok, cocinaré eso entonces");
            this.myAgent.send(respuesta);

        }
        else
            block();
    }

    @Override
    public boolean done() {
        return true;
    }
}
