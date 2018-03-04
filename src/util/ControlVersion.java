package util;

public class ControlVersion {
	private String version = "0.0.2-A";
	
	private String detallesVersion = "**• 0.0.2-A**: - Añadido control de eventos del servidor.\n"
			+ "**• 0.0.1-A**: - Creación del BOT. Añadidos comandos básicos." ;
	
	public String getVersion () {
		return version;
	}
	
	public String getDetalles () {
		return detallesVersion;
	}
	
}
