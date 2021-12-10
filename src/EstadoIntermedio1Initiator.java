import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.Iterator;

public class EstadoIntermedio1Initiator  extends Behaviour {
    private boolean termino = false;
    private int event = -1;
    @Override
    public void action() {
        ACLMessage req = (ACLMessage) this.getDataStore().get("mensaje propose");
        AID responder = (AID) this.getDataStore().get("responder");

        // Chequeo que sea un template REJECT o ACCEPT, que venga del agente al que se le envió el primer REQUEST, y que el conversation ID sea el mismo del primer mensaje (primera propuesta de comida)
        //ACLMessage msg = myAgent.receive(MessageTemplate.and(MessageTemplate.and(MessageTemplate.or(MessageTemplate.MatchPerformative(ACLMessage.REJECT_PROPOSAL), MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL)), MessageTemplate.MatchSender(responder)), MessageTemplate.MatchConversationId(req.getConversationId())));
        //ACLMessage msg = myAgent.receive(MessageTemplate.or(MessageTemplate.MatchPerformative(ACLMessage.REJECT_PROPOSAL),MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL)));

       ACLMessage msg = myAgent.receive();
        //System.out.println(msg.getSender());
        if (msg != null) {
            if (msg.getPerformative() == ACLMessage.REJECT_PROPOSAL){
                event = 0;
            }
            else {
                if (msg.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
                    this.getDataStore().put("mensaje accept", msg);
                    event = 1;
                }
            }
            termino = true;
        }
        else{
            block();
        }
    }

    @Override
    public boolean done() {
        return termino;
    }

    @Override
    public int onEnd() {
        return this.event;
    }
    @Override
    public void reset() {
        termino = false;
        event = -1;
    }

}
