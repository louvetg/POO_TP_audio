
public class ModuleAdd extends ModuleAbstract {
	
	public ModuleAdd() {
		super("Module additionneur",2,1);
	}
	
	/**Fonction permettant l'ajout de 2 signaux */
	@Override
	public void exec(){ 
		double x = this.getInputPortValue(0)*this.getInputPortValue(1);
		this.setOutpuPortValue(0, x);
		if(this.getOutputCommunicationPortsnum(0).isConnected()){
			this.getOutputCommunicationPortsnum(0).getConnexion().communicate();		
		}
		
	}
			
		
}
