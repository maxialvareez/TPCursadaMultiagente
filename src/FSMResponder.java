
import jade.core.behaviours.DataStore;
import jade.core.behaviours.FSMBehaviour;

public class FSMResponder extends FSMBehaviour {
    public FSMResponder() {
        DataStore ds = new DataStore();

        EstadoInicialResponder estadoInicial = new EstadoInicialResponder();
        estadoInicial.setDataStore(ds);

        EstadoIntermedioResponder eintermedio = new EstadoIntermedioResponder();
        eintermedio.setDataStore(ds);

        EstadoFinalResponder estadoFinal = new EstadoFinalResponder();
        estadoFinal.setDataStore(ds);


        this.registerFirstState(estadoInicial, "estadoInicial");
        this.registerState(eintermedio, "eintermedio");
        this.registerLastState(estadoFinal,"estadoFinal");

        //Transiciones
        String[] resetInicial ={"estadoInicial"};
        String[] resetIntermedio = {"eintermedio"};

        this.registerDefaultTransition("estadoInicial", "eintermedio", resetIntermedio);
        this.registerTransition("eintermedio", "estadoInicial", 0, resetInicial);
        this.registerTransition("eintermedio", "estadoFinal", 1, resetInicial);
    }
}
