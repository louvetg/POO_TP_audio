
public class CommunicationPorts {
	
	private ModuleAbstract possesseur;
	private int portNumber;
	private Connexion connexion;
	private double value;
	
	public CommunicationPorts(ModuleAbstract a,int x) {
		
		this.possesseur = a ;
		this.portNumber = x ; 
		this.connexion = null ;
		this.value = 0;
		
	}
	
	public CommunicationPorts(CommunicationPorts a){
		this.possesseur = a.getModule();
		this.portNumber = a.getPortNumber();
		this.connexion = null;
		this.value = 0;
	}
	
	public void setValue(double v){
		this.value = v;
	}
	
	public double getvalue(){
		return this.value;
	}
	
	public boolean isConnected(){
		if(this.connexion != null){return true;}
		else{return false;}
	}
	
	public void setConnexion(Connexion c){
		this.connexion = c;
	}
	
	public Connexion getConnexion(){
		return this.connexion;
	}

	public void  setModule(ModuleAbstract A){
		this.possesseur=A;
	}
	
	public ModuleAbstract  getModule(){
		return this.possesseur;
	}
	
	public void  setPortNumber(int portNumber){
		this.portNumber=portNumber;
	}
	
	public int  getPortNumber(){
		return this.portNumber;
	}
}
