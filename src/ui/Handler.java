package ui;

import javax.swing.JOptionPane;

import Exceptions.Excepciones;
import basico.jdbc.*;
import basico.jdbc.PrincipalFrame;

public class Handler {

	BO bo = new BO();

	private PrincipalFrame frame;

	public Handler() {
		frame = new PrincipalFrame(this);
	}

	public void init() {
		frame.setVisible(true);
	}

	public void mostrarAltaUsuario() {
		frame.cambiarPanel(new MiPanel("", this));
		frame.setVisible(true);
	}
	
	public void mostrarEditarUsuario() {
		frame.cambiarPanel(new MiPanelEditar("", this));
		frame.setVisible(true);
	}
	
	public void mostrarEliminarUsuario() {
		frame.cambiarPanel(new MiPanelEliminar("", this));
		frame.setVisible(true);
	}
	
	public void mostrarTodo() {
		frame.cambiarPanel(new MiPanelTodos(""));
		frame.setVisible(true);
	}
	
	public void crearUsuario(Usuario user) {
		try {
			bo.crearUsuario(user);
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void editarUsuario(Usuario user) {
		try {
			bo.modificarUsuario(user);
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuario(Usuario user) {
		try {
			bo.eliminarUsuario(user);
		} catch (Excepciones e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}


}
