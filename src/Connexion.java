public class Connexion {
	private CommunicationPort upModulePort;
	private CommunicationPort downModulePort;
	
	public Connexion(){
		this.upModulePort = new CommunicationPort();
		this.downModulePort = new CommunicationPort();
	}
	
	public void communicate(){
		this.upModulePort.setValue(this.downModulePort.getvalue()); 	
	}
}
