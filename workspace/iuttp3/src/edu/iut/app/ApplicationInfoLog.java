package edu.iut.app;

public class ApplicationInfoLog extends AbstractApplicationLog {

	/**
	 * Constructeur par d�faut d'un ApplicationInfoLog. 
	 */
	public ApplicationInfoLog() {
		super();
	}
	
	/**
	 * Remplace le message de ApplicationInfoLog par la cha�ne pass�e en param�tre. La m�thode fireMessage est ensuite appel�e. 
	 * 
	 * @param	message	la cha�ne de caract�re qui remplacera le contenu de l'attribut message
	 * @see edu.iut.app.AbstractApplicationLog#setMessage(java.lang.String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
		ApplicationSession.instance().getGUILogger().info(this.message);
        super.fireMessage("[INFO]", this.message);
	}

}
