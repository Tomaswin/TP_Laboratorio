package banco.entidades;

import java.util.ArrayList;

public class Usuario
 {
    private String nombre;
    private String apellido;
    private String password;
    private int dni;
    private ArrayList<Cuenta> cuentas;
    
    public Usuario(String nombre, String apellido, String password, int dni, ArrayList<Cuenta> Cuentas) {
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.password = password;
    	this.dni = dni;
    	this.cuentas = Cuentas;
    }
    
    public Usuario(int dni) {
    	this.dni=dni;
    }
    
    public Usuario(int dni,String password) {
    	this.dni = dni;
    	this.password = password;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getApellido()
    {
        return nombre;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }


    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int getDni()
    {
        return dni;
    }

    public void setDni(int dni)
    {
        this.dni = dni;
    }
    
    public ArrayList<Cuenta> getCuenta()
    {
        return cuentas;
    }

    public void setCuenta(ArrayList<Cuenta> Cuenta)
    {
        this.cuentas = Cuenta;
    }
    

    public String toString()
    {
        return "Nombre: " + this.nombre + "Apellido: " + this.apellido + " Email: " + " Password: " + this.password + " Dni: "
        		+ this.dni;
    }

 }
