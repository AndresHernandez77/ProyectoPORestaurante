import java.util.*;
import java.io.*;

public class Beneficiario extends Persona{
  static Map<String,Beneficiario> beneficiarios= new HashMap<String,Beneficiario>();
  static ArrayList<Beneficiario> beneficiarios2=new ArrayList<>();
  private String identificacion;
  private boolean desayuno;
  private boolean comida;
  private boolean cena;
  String fechaDeRegistro, horaDeRegistro;

  public Beneficiario(String nombre, String fechaDeRegistro, String horaDeRegistro){
    super(nombre);
    this.fechaDeRegistro=fechaDeRegistro;
    this.horaDeRegistro=horaDeRegistro;
  }

  private void pedirComida(Chef chef){
    boolean comidita=chef.getServido();
    if(comidita==false){
      System.out.println("No puedo recibir comida");
    }else{
      System.out.println("He recibido comida");
    }
  }

  public String toString(){
    return nombre+", "+fechaDeRegistro+", "+horaDeRegistro;
  }

  public static String nombreArchivo;

  public static int readLines(Map<String,Beneficiario> beneficiarios){
        Scanner stdIn = new Scanner(System.in);
        Scanner fileIn;
        String line, identificacion="",nombre;
        int numeroB=0;
        try {
            System.out.print("Introduzca el nombre del archivo: ");
            nombre=stdIn.nextLine();
            fileIn = new Scanner(new FileReader(nombre));
            nombreArchivo=nombre;
            while (fileIn.hasNextLine()){
                line = fileIn.nextLine();
                //System.out.println(line);
                String[] partes = line.split(", ");
                identificacion=generarIdentificacion(partes);
                beneficiarios2.add(new Beneficiario(partes[0],partes[1],partes[2]));
                beneficiarios.put(identificacion,new Beneficiario(partes[0],partes[1],partes[2]));
                numeroB++;
            }

            fileIn.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }
        return numeroB;
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        System.out.println("");
        for (int i = 0; i < n; ++i)
            System.out.println(arr[i] + " ");
    }

    public static void beneficiarioInterfaz(Map<String,Beneficiario> beneficiarios) throws IOException{
      Scanner d = new Scanner(System.in);
      String[] datos = new String[4];
        for(int i=0;i<3;i++){
          if(i==0) System.out.println("Ingrese el nombre del beneficiario: ");
          if(i==1) System.out.println("Ingrese la fecha de resgistro del beneficiario: ");
          if(i==2) System.out.println("Ingrese la hora de resgistro del beneficiario: ");
          String line = d.nextLine();
          datos[i]=line;
          numeroB++;
      }

      String identificacion=generarIdentificacion(datos);
      beneficiarios2.add(new Beneficiario(partes[0],partes[1],partes[2]));
      beneficiarios.put(identificacion,new Beneficiario(partes[0],partes[1],partes[2]));
      System.out.println("La identificacion del nuevo usuario es: "+identificacion);

      File archivo = new File(nombreArchivo);
      if(archivo.exists()){
            FileWriter fw = new FileWriter(archivo, true);
            fw.write(datos[0]+", "+datos[1]+", "+datos[2]+"\n");
            fw.close();
        }
        else{
            System.out.println("No existe el archivo.");
        }
    }

    public static void eliminarBeneficiario(Map<String,Beneficiario> beneficiarios) throws IOException{
      Scanner d = new Scanner(System.in);
      System.out.println("Ingrese el número de identificación del beneficiario: ");
      String identificacion = d.nextLine();
      beneficiarios.remove(identificacion);

      File archivo = new File(nombreArchivo);
      if(archivo.exists()){
            FileWriter fw = new FileWriter(archivo, false);
            for(Map.Entry m:beneficiarios.entrySet()){
              fw.write(m.getValue()+"\n");
            }
            fw.close();
        }
        else{
            System.out.println("No existe el archivo.");
        }
    }

    public static String generarIdentificacion(String[] partes){
      String[] iniciales=partes[0].split(" ");
      String identificacion="";
      //System.out.println(partes[0]);

      char c1 = iniciales[0].charAt(0);
      char c2 = iniciales[1].charAt(0);
      identificacion = c1+partes[1]+partes[2];
      identificacion = c2+identificacion;
      identificacion = identificacion.replaceAll("[^A-Z0-9]","");

      return identificacion;
    }

}
