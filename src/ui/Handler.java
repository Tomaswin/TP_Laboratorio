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
		frame.cambiarPanel(new MiPanel(""));
		frame.setVisible(true);
	}
	
	public void mostrarEditarUsuario() {
		frame.cambiarPanel(new MiPanelEditar(""));
		frame.setVisible(true);
	}
	
	public void mostrarEliminarUsuario() {
		frame.cambiarPanel(new MiPanelEliminar(""));
		frame.setVisible(true);
	}
	
	public void mostrarTodo() {
		frame.cambiarPanel(new MiPanelTodos(""));
		frame.setVisible(true);
	}


}
