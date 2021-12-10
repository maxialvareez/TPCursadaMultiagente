import jade.core.behaviours.Behaviour;
import jade.core.behaviours.DataStore;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class EstadoInicialResponder extends Behaviour {
    private boolean recibido = false;
    @Override
    public void action() {
        // Recibo un mensaje
        ACLMessage msg = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.PROPOSE));

        if (msg != null) { // Si recibi el mensaje, lo proceso
            this.recibido = true;
            this.getDataStore().put("mensaje propose", msg);
        }
        else
            block();
    }


    @Override
    public boolean done() {
        return this.recibido; //loRecibi
    }

    @Override
    public void reset() {
        recibido = false;
    }
}