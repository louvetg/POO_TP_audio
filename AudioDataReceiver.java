import phelmaaudio .* ; 
public class AudioDataReceiver extends ModuleAbstract {

	private AudioData audioData;
	
	public AudioDataReceiver() {
		super("AudioDataReceiver",1,1);
		this.audioData = new AudioData();
	}
	
	@Override
	public void exec(){
		double e = this.getInputPortValue(0); 
		audioData.addSample(e); /**  Ajout  de  l'echantillon  present  dans    unique  port  d'entree  a  conteneur  d'echantillons AudioData*/
		this.setOutpuPortValue(0,e);/** Copie de cet echantillon dans le port de sortie (unique).*/
		if(this.getOutputCommunicationPortsnum(0).isConnected()){/**Si port sortie conecte*/
			CommunicationPorts PortModuleAval=this.getOutputCommunicationPortsnum(0).getConnexion().getdownModulePort();
			PortModuleAval.setValue(e); /**Envoie valeur vers le port du module aval, a l'autre bout de la Connexion*/
		}
		
	}
	
	/**Accesseur*/
	
	public AudioData getAudiodata(){
		return this.audioData;
	}
	
}
