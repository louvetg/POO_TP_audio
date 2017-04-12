public class Test {

	public static void main(String [] args) {

		Gensine gen1 = new Gensine(100,10);
		Gensine gen2 = new Gensine(500,10);
		ModuleAdd add = new ModuleAdd();
		AudioDataReceiver output = new AudioDataReceiver() ;
		Connexion con1 = ModuleAbstract.connect(gen1,0,add,0);
		Connexion con2 = ModuleAbstract.connect(gen2,0,add,1);
		Connexion con3 = ModuleAbstract.connect(add,0,output,0);
		gen1.getOutputCommunicationPortsnum(0).setConnexion(con1);
		gen2.getOutputCommunicationPortsnum(0).setConnexion(con2);
		add.getOutputCommunicationPortsnum(0).setConnexion(con3);
		add.getInputCommunicationPortsnum(0).setConnexion(con1);
		add.getInputCommunicationPortsnum(1).setConnexion(con2);
		output.getInputCommunicationPortsnum(0).setConnexion(con3);
	    for(int i=0;i<44100*5;i++) {
	    	gen1.exec();
	    	gen2.exec();
	    	add.exec();
	    	output.exec();
	    }
	    
	    output.getAudiodata().display();
	    output.getAudiodata().play();
	}
}
 
