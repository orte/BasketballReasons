package all;

public class PlayerNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No existen jugadores con este nombre, inténtalo de nuevo";
	}

}
