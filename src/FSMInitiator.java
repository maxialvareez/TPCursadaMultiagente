import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;

public class FSMInitiator extends FSMBehaviour {

    public FSMInitiator() {
        DataStore ds = new DataStore();

        EstadoInicialInitiator estadoInicial = new EstadoInicialInitiator();
        estadoInicial.setDataStore(ds);

        EstadoFinalInitiator estadoFinal = new EstadoFinalInitiator();
        estadoFinal.setDataStore(ds);

        EstadoIntermedio1Initiator eint1 = new EstadoIntermedio1Initiator();
        eint1.setDataStore(ds);

        //Estados
        this.registerFirstState(estadoInicial, "estadoInicial");
        this.registerState(eint1, "eint1");
        this.registerLastState(estadoFinal,"estadoFinal");

        //Transiciones
        String[] toResetInicio= {"estadoInicial"};
        String [] toResetIntermedio = {"eint1"};

        this.registerDefaultTransition("estadoInicial", "eint1", toResetIntermedio);
        this.registerTransition("eint1", "estadoInicial", 0, toResetInicio);
        this.registerTransition("eint1", "estadoFinal", 1);
    }


}
