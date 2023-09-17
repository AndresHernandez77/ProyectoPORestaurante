import java.io.*;

public abstract class Trabajador{
	private String trabajo;
	private double salario;
	private Solicitud solicitud;

	public String getTrabajo(){
		return this.trabajo;
	}

	public void setTrabajo(String trabajo){
		this.trabajo = trabajo;
	}

	public double getSalario(){
		return this.salario;
	}

	public void setSalario(double salario){
		this.salario = salario;
	}

	public Solicitud getSolicitud(){
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud){
		this.solicitud = solicitud;
	}

	public void mandarSolicitud(Gerente gerente){
		if(this.solicitud != null){ 
			gerente.aprobarGastos(this.solicitud);
			this.solicitud = null;
			System.out.println("La solicitud se ha mandado, esperar una respuesta del superior");
		}	
		else System.out.println("Ud no tiene ninguna solicitud por el momento, redactar una y entonces vuelva a intentar mandarla");
	}

	public abstract void trabajar();

}