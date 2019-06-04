package ui;

import basico.jdbc.*;
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
		frame.cambiarPanel(new MiPanel("Por qu� le pongo titulo? :P"));
		frame.setVisible(true);
	}
	
	public void mostrarEditarUsuario() {
		frame.cambiarPanel(new MiPanelEditar("Por qu� le pongo titulo? :P"));
		frame.setVisible(true);
	}

}
