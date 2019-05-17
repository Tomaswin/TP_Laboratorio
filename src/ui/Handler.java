package ui;

import basico.jdbc.MiPanel;
import basico.jdbc.PrincipalFrame;

public class Handler {

	private PrincipalFrame frame;

	public Handler() {
		frame = new PrincipalFrame(this);
	}

	public void init() {
		frame.setVisible(true);
	}

	public void mostrarAltaUsuario() {
		frame.cambiarPanel(new MiPanel("Por qué le pongo titulo? :P"));
	}

}
