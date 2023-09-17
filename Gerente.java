
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Queue;

public class Gerente extends Trabajador{
    protected ComedorComunitario institucion;
    //Solicitud[] sol = null;
    Queue<Solicitud> queueSol = new LinkedList<>();

    public void Gerente(double presupuesto){
        this.presupuesto=presupuesto;
        this.registro=0;
        this.registro2=0;
        this.registro3=0;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    /*public void aprobarGastos(String palabra, File archivo){
        try{
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea="";
           while((linea=leer.readLine())!=null){
               if(linea.indexOf(palabra)!=-1){
                   System.out.println("Se encontro el registro:"+linea);
                   if(palabra=="Estufa"){
                       System.out.println("El gasto fue aprobado"+(getPresupuesto()-5000));
                   }else if(palabra=="Carro"){
                       System.out.println("El gasto no fue aprobado");

                   }
               }
           }
        }catch(Exception e){
            System.out.println("Ocurrio un error");
        }
    }*/

    public double llevarRegistro(Chef chef){
      System.out.println("Llevo el resgitro...");
      double registro=institucion.presupuesto*0.80*institucion.getNumBenef();
      chef.setPresupuestoComida(registro);

      return registro;
    }

    public void trabajar(){

    }

    public void recibirSolicitud(Solicitud sol){
        queueSol.add(sol);
        //this.sol=new Solicitud[1];
    		//this.sol[0]=sol
   }

  public void revisarSolicitudes(){
  	System.out.println("Vamos a revisar las solicitudes que se llevan hasta el momento");
  	System.out.println("Desea continuar: \n1. Si    2. No");
  	Scanner sc = new Scanner(System.in);
  	int opc = sc.nextInt();
  	sc.nextLine()
  	if(opc==1){
  		for(int i=0;i<queueSol.size();i++){
  			this.queueSol.element().leer();
  			System.out.println("Desea aprobar esta solicitud? (escribir \"true\" o \"false\")");
  			opc=sc.nextBool();
        if(opc&&institucion.presupuesto<=0){
          System.out.println("No se ha podido aprbar esta solicitud, no hya suficiente presupuesto");
          break;
        }
  			queueSol.poll().setAprobado(opc);
        institucion.presupuesto=(institucion.presupuesto*0.20)-100;
  			System.out.println("Desea revisar la siguiente solicitud");
        opc=sc.nextBool();
  			if(opc){
  				System.out.println("Siguiente solicitud en camino...\n\n");
  			}
  			else break;
  		}
  		System.out.println("Ud ha terminado por el dia de hoy");
  	}else{
  		System.out.println("Ud ha terminado por el dia de hoy");
  	}
  }
}
