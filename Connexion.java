
public class Connexion {
	
	private CommunicationPorts upModulePort;
	private CommunicationPorts downModulePort;
	
	public Connexion(CommunicationPorts downModulePort, CommunicationPorts upModulePort ) {
		this.upModulePort = upModulePort;
		this.downModulePort = downModulePort;
		this.upModulePort.setConnexion(this);
		this.downModulePort.setConnexion(this);
	}
	
	public CommunicationPorts getupModulePort(){
		return this.upModulePort;
	}
	
	public CommunicationPorts getdownModulePort() {
		return this.downModulePort;
	}

	public void setupModulePort (CommunicationPorts a) {
		this.upModulePort=a;
	}

	public void setdownModulePort (CommunicationPorts a) {
		this.downModulePort=a;
	}
	
	public void communicate(){
		this.upModulePort.setValue(this.downModulePort.getvalue());
	}

	
}

