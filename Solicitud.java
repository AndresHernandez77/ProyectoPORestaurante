import java.io.*;
import java.util.Scanner;

public class Solicitud{
    Scanner sc = new Scanner(System.in);
    private File archivo;
    private boolean aprobado;

    public Solicitud() {
        this.archivo = null;
        this.aprobado = false;
    }

    public Solicitud(String direccion) {
        archivo = new File(direccion);
        try {
            archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.aprobado = false;
    }

    public void escribir(){
        if (this.archivo.exists()) {
            try {
                String cadena;// = new String();
                FileWriter f = new FileWriter(this.archivo);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter wr = new PrintWriter(b);
                System.out.println("Ingresa tu solicitud:\n(escribe \"STOP\" para acabar la solicitud)");
                    cadena=sc.nextLine();
                    wr.write(cadena+"\n");
                while(true){
                    cadena=sc.nextLine();
                    if(cadena.equalsIgnoreCase("STOP")){
                        break;
                    }
                    else{
                        wr.append(cadena+"\n");
                    }
                }
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay un archivo!!");
        }
    }

    public void leer() {
        if (archivo.exists()) {
            String cadena;
            FileReader f;
            try {
                f = new FileReader(archivo);
                try {
                    BufferedReader b = new BufferedReader(f);
                    while((cadena = b.readLine())!=null) {
                        System.out.println(cadena);
                    }
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay un archivo!!");
        }
    }
    public void setAprobado(boolean aprobado){
        this.aprobado = aprobado;
    }

    public boolean getAprobado(){
        return aprobado;
    }
/*
    public static void main(String[] args) {
        Solicitud o = new Solicitud("Solicitud.txt");
        o.escribir();
        o.leer();

        o.escribir();
        o.leer();
    }
*/
}
