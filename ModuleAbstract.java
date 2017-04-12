abstract class ModuleAbstract {
	
	/**Attributs*/
	
	final int SAMPLE_FREQ = 44100;
	private String nom;
	private CommunicationPorts[] inputPorts;
	private CommunicationPorts[] outputPorts;
	
	/**Constructeur*/
	
	public ModuleAbstract(String nom,int nbInput,int nbOutput) {
		this.nom=nom;
		if (nbInput == 0 ) {
			inputPorts = null ; 
		}
		else {
			inputPorts = new CommunicationPorts[nbInput];
			for(int i =0;i<nbInput;i++) {
				inputPorts[i] = new CommunicationPorts(this,i);
			}
		}

		outputPorts = new CommunicationPorts[nbOutput];
		for(int j =0;j<nbOutput;j++) {
			outputPorts[j] = new CommunicationPorts(this,j);
		}
		
	}
	
	/**Accesseur*/

	/**
	 * Permet d'acceder au nom du Module
	 * @param Nonde
	 * @return inputPorts
	 * 	retourne le nom du module
	 * @author Esa Alexandre
	 */
	public String getName(){
		return this.nom;
	}
	
	/**
	 * Permet d'acceder au port num idInputPort
	 * @param idInputPorts
	 * 	idInputPorts est le numéro du port 
	 * @return inputPorts
	 * 	retourne la valeur du port de communication 
	 * @author Esa Alexandre
	 */
	public double getInputPortValue(int idInputPort) {
		return this.inputPorts[idInputPort].getvalue();
	}
	
	public CommunicationPorts getInputCommunicationPortsnum(int x) { 
		return this.inputPorts[x];
	}
	
	public CommunicationPorts getOutputCommunicationPortsnum(int x) { 
		return this.outputPorts[x];
	}

	
	/**
	 * Permet d'acceder au port output num idOutputtPort
	 * @param idOututPorts
	 * 	idOutputPorts est le numéro du port de sortie 
	 * @return outputPorts
	 * 	retourne la valeur du port  de communication 
	 * @author Esa Alexandre
	 */
	public double getOutputPortValue(int idOutputPort) {
		return this.outputPorts[idOutputPort].getvalue();
	}
	
	
	/**Mutateur*/
	
	/**Instance le port idInputport à la valeur x*/
	public void setInputPortValue(int idInpoutPort,double x){
		this.inputPorts[idInpoutPort].setValue(x);
	}
	
	/**Instance le port idInputport à la valeur x*/
	public void setOutpuPortValue(int idOutpoutPort,double x){
		this.outputPorts[idOutpoutPort].setValue(x);
	}
	
	/**Instance le port numéro numOut d'un module output avec le port numéro numInput du module d'entree*/
	public void setAndSendOutputPortValue(int numInput,int numOutput,ModuleAbstract output){
		output.setInputPortValue(numOutput,this.getInputPortValue(numInput));
	}
	
	static Connexion connect(ModuleAbstract down,int idDownPort,ModuleAbstract up,int idUpPort ){
		Connexion connecte = new Connexion(down.outputPorts[idDownPort],up.inputPorts[idUpPort]);
		return connecte;
	}
	
	/**Mutateur*/
	
	abstract void exec();
	
	
	
}