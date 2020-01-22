package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class SQLalumnos extends conexion {
    
    //REGISTRO DE ESTUDIANTES 
    public boolean registrarEstudiante(alumnos usr) {
        PreparedStatement ps = null;
        Connection con = getconexion();

        String sql = "INSERT INTO alumnos (nombres, apellidos, edad, curso) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombres());
            ps.setString(2, usr.getApellidos());
            ps.setString(3, usr.getEdad());
            ps.setString(4, usr.getCurso());
            ps.execute();
            return true;

        } catch (SQLException ex) {
          Logger.getLogger(SQLalumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    } 
    
    public void mostrarDatos(String valor){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOMBRE");
        model.addColumn("APELLIDOS");
        model.addColumn("EDAD");
        model.addColumn("CURSO");
        model.addColumn("TIEMPO");
        model.addColumn("PLANEACION");
        model.addColumn("COORDINACION");
        model.addColumn("FUERZA");
        model.addColumn("SENSIBILIDAD");
    }
}
