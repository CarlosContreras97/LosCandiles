package Clases;
import java.lang.Exception;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Validacion{
    //ID_Empleado
	public static boolean ID_Empleado(String a){
		boolean ret;
		try{
			String nombrePattern="^[EMP0-9]+{6}";
			Pattern pattern = Pattern.compile(nombrePattern);
			Matcher matcher = pattern.matcher(a);
			if(matcher.matches() && a.length()==6){
				ret=true;
			}
			else{
				ret=false;
				JOptionPane.showMessageDialog(null,"Error, el ID_Empleado consta de 3 letras emp seguido de 3 numeros en un rango de 0-9.");
			}

		}catch(Exception ex){
			ret=false;
			JOptionPane.showMessageDialog(null,"Error, el ID_Empleado consta de 3 letras emp seguido de 3 numeros en un rango de 0-9.");
		}
		return ret;
	}

	//Domicilio_Empleado
	public static boolean Domicilio_Empleado(String a){
		boolean ret;
		try{
			String nombrePattern="[\\w\\s]+{2,30}";
			Pattern pattern = Pattern.compile(nombrePattern);
			Matcher matcher = pattern.matcher(a);
			if(matcher.matches() && a.length()<=30){
				ret=true;
			}
			else{
				ret=false;
				JOptionPane.showMessageDialog(null,"Error, el Domicilio del Empleado consta de hasta 30 caracteres de la A-Z, a-z y digitos");
			}

		}catch(Exception ex){
			ret=false;
			JOptionPane.showMessageDialog(null,"Error, el Domicilio del Empleado consta de hasta 30 caracteres de la A-Z, a-z y digitos");
		}
		return ret;
	}

	//Telefono_Empleado
	public static boolean Telefono_Empleado(String a){
		boolean ret;
		try{
			String nombrePattern="[\\d]+{10}";
			Pattern pattern = Pattern.compile(nombrePattern);
			Matcher matcher = pattern.matcher(a);
			if(matcher.matches() && a.length()==10){
				ret=true;
			}
			else{
				ret=false;
				JOptionPane.showMessageDialog(null,"Error, el Telefono de Empleado debe constar de 10 digitos");
			}

		}catch(Exception ex){
			ret=false;
			JOptionPane.showMessageDialog(null,"Error, el Telefono de Empleado debe constar de 10 digitos");
		}
		return ret;
	}

	//Nombre_Empleado
	public static boolean Nombre_Empleado(String a){
		boolean ret;
		try{
			String nombrePattern="[\\w\\.\\sáéíóú\\u00c1\\u00c9\\u00cd\\u00d3\\u00da\\u00f1\\u00d1\\s]+{7,30}";
			Pattern pattern = Pattern.compile(nombrePattern);
			Matcher matcher = pattern.matcher(a);
			if(matcher.matches() && a.length()<=30){
				ret=true;
			}
			else{
				ret=false;
				JOptionPane.showMessageDialog(null,"Error, el Nombre de Empleado debe constar de maximo 30 caracteres de la a-z, A-Z, acentos y puntos");
			}

		}catch(Exception ex){
			ret=false;
			JOptionPane.showMessageDialog(null,"Error, el Nombre de Empleado debe constar de maximo 30 caracteres de la a-z, A-Z, acentos y puntos");
		}
		return ret;
	}

	//Tipo_Empleado
	public static boolean Tipo_Empleado(String a){
		boolean ret;
		try{
			String nombrePattern="CAJERO|MESERO+{2,10}";
			Pattern pattern = Pattern.compile(nombrePattern);
			Matcher matcher = pattern.matcher(a);
			if(matcher.matches() && a.length()<=10){
				ret=true;
			}
			else{
				ret=false;
				JOptionPane.showMessageDialog(null,"Error, el Tipo de Empleado debe de ser cajero o mesero.");
			}

		}catch(Exception ex){
			ret=false;
			JOptionPane.showMessageDialog(null,"Error, el Tipo de Empleado debe de ser cajero o mesero.");
		}
		return ret;
	}

}
