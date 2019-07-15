package ui;

import java.util.List;

import javax.swing.JOptionPane;

import Exceptions.BancoException;
import basico.jdbc.*;
import basico.jdbc.PrincipalFrame;
import basico.jdbc.Dao.UsuarioJDBCDao;

public class Handler {

	private UsuarioBO bo;
	private PrincipalFrame frame;

	public Handler() {
		frame = new PrincipalFrame(this);
		bo = new UsuarioBO();
		bo.setUserJDBC(new UsuarioJDBCDao());
	}

	public void init() {
		frame.setVisible(true);
		mostrarLoginUsuario();
	}

	public void mostrarAltaUsuario() {
		frame.cambiarPanel(new MiPanel("", this));
	}
	
	public void mostrarEditarUsuario() {
		frame.cambiarPanel(new MiPanelEditar("", this));
	}
	
	public void mostrarEliminarUsuario() {
		frame.cambiarPanel(new MiPanelEliminar("", this));
	}
	
	public void mostrarLoginUsuario(){
		try {
			List<Usuario> usuarios = bo.traerTodos();
			frame.cambiarPanel(new MiPanelLogin("", this, usuarios));
	
	public void crearUsuario(Usuario user) {
		try {
			bo.crearUsuario(user);
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void editarUsuario(Usuario user) {
		try {
			bo.modificarUsuario(user);
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuario(Usuario user) {
		try {
			bo.eliminarUsuario(user);
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	
	
	public void login(Usuario user) {
		try {
			bo.login(user);
			frame.loginSuccess();
		} catch (BancoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
}
