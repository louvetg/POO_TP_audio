
public class TestAudio {
	public static void main (String arg[]){
		Gensine sinus = new Gensine(10,100);
		Gensine sinus2 = new Gensine(10,101);
		AudioDataReceiver watch = new AudioDataReceiver();
		ModuleAbstract.connect(sinus,0,watch,0);
		
		for(int i = 0 ; i < 44100; i++){
			sinus.exec();
			watch.exec();
			
		}
	}
}
