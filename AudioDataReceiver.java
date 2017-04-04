import phelmaaudio .* ; 
public class AudioDataReceiver extends ModuleAbstract {

	AudioData AudioData;
	
	public AudioDataReceiver() {
		super("AudioDataReceiver",1,1);
	}
	
	@Override
	public void exec(){
		double e = this.getInputPortValue(0);
		AudioData.addSample(e); /**  Ajout  de  l'echantillon  present  dans  son  unique  port  d'entree  a  son  conteneur  d'
		echantillons AudioData*/
		this.setOutpuPortValue(1,e);/** Copie de cet echantillon dans le port de sortie (unique).*/
		if(this.outputPorts[0].isConnected()){
			CommunicationPorts PortModuleAval=this.outputPorts[0].getConnexion().getupModulePort();
			PortModuleAval.setValue(e); /**Envoie valeur vers le port du module aval, a l'autre bout de la Connexion*/
		}
		
	}
	
}
