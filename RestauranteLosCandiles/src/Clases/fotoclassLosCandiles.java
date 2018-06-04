package Clases;

import Conexion.ConexionLosCandiles;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class fotoclassLosCandiles {

    ConexionLosCandiles con;
    private Image data;

    public fotoclassLosCandiles() {
        con = new ConexionLosCandiles();
    }

    //metodo que dada una cadena de bytes la convierte en una imagen con extension jpeg
    private Image ConvertirImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        return reader.read(0, param);
    }

    //METODO PARA RECUPERAR LA IMAGEN DE LA BASE DE DATOS
    public Image recuperarfotos(String dni_doc) {

        try {
            PreparedStatement pstm = con.conectar().prepareStatement("SELECT EMPLEADOS.FOTO_EMPLEADO FROM EMPLEADOS where EMPLEADOS.ID_EMPLEADO= ? ");
            pstm.setString(1, dni_doc);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                // se lee la cadena de bytes de la base de datos
                byte[] b = res.getBytes("FOTO_EMPLEADO");
                //esta cadena de bytes sera convertida en una imagen
                data = ConvertirImagen(b);
                i++;
            }
            res.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Clases.fotoclassLosCandiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

    }
    
     public Image recuperarfotosProducto(String dni_doc) {

        try {
            PreparedStatement pstm = con.conectar().prepareStatement("SELECT PRODUCTOS.FOTO_PRODUCTO FROM PRODUCTOS where PRODUCTOS.ID_PRODUCTO= ? ");
            pstm.setString(1, dni_doc);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while (res.next()) {
                // se lee la cadena de bytes de la base de datos
                byte[] b = res.getBytes("FOTO_PRODUCTO");
                //esta cadena de bytes sera convertida en una imagen
                data = ConvertirImagen(b);
                i++;
            }
            res.close();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Clases.fotoclassLosCandiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;

    }
}
