public class Gensine extends ModuleAbstract {

	private double f;
	private int indiceTemps ; 
	private double amp;
	
	public Gensine(double f,double amp) {
		super("Generateur sinusoidal",0,1);
		this.indiceTemps=0;
		this.f=f;
		this.amp=amp;
	}
	
	@Override 
	public void exec() {
		double e = (this.amp)*Math.sin((2*3.14*(this.f)*(this.indiceTemps))/(this.SAMPLE_FREQ));
		this.setOutpuPortValue(0, e);
		if(this.getOutputCommunicationPortsnum(0).isConnected()) { /**Si port de sortie est connecte*/
			this.getOutputCommunicationPortsnum(0).getConnexion().communicate(); /**Envoie valeur vers le port du module aval, a l'autre bout de la Connexion*/
		}
		this.indiceTemps+=1;
	}
	
	/**Accesseur*/
	
	public double getFreq(){
		return this.f;
	}
	
	public double getTime(){
		return this.indiceTemps;
	}
	
	public double getAmp(){
		return this.amp;
	}
}
