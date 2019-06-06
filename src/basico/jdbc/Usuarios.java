package basico.jdbc;

public class Usuarios
 {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private int dni;
    private String sexo;
    
    public Usuarios(String nombre, String apellido, String email, String password, int dni, String sexo) {
    	this.nombre = nombre;
    	this.apellido = apellido;
    	this.email = email;
    	this.password = password;
    	this.dni = dni;
    	this.sexo = sexo;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
    
    public String getSexo()
    {
        return sexo;
    }

    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public String toString()
    {
        return "Nombre: " + this.nombre + "Apellido: " + this.apellido + " Email: " + this.email + " Password: " + this.password + " Dni: "
        		+ this.dni + " Sexo: " + this.sexo;
    }

 }
