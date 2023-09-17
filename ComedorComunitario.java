import java.util.*;
import java.io.*;

public class ComedorComunitario{
  private String nombre,dirección,benefactor;
  static Map<String,Beneficiario> beneficiarios= new HashMap<String,Beneficiario>();
  static ArrayList<Beneficiario> beneficiarios2=new ArrayList<>();
  private static int numBenef,numMax;
  private float presupuesto, cuota, fondos;

  public int getNumBenef(){
    return numBenef;
  }

  public static void main(String[] args) throws IOException{
    presupuesto=10000;
    Chef chefcito = new Chef();

    numBenef=Beneficiario.readLines(beneficiarios);
    System.out.println("Numero de beneficiarios: "+numBenef);
    /*for(Map.Entry m:beneficiarios.entrySet()){
      System.out.println(m.getKey()+" "+m.getValue());
    }*/
    for(int i=0;i<beneficiarios2.size();i++){
      beneficiarios2.get(i).pedirComida();
    }




    /*boolean exit1 = false;
    boolean exit2 = false;
    int op=0;

    do{
      System.out.println("\t\tINICIO");
      System.out.print("1.Beneficiarios\n2.Salir\n");
      Scanner n = new Scanner(System.in);
      op=n.nextInt();

      switch(op){
        case 1:
          System.out.println("Beneficiarios");
          do{
            System.out.println("\t\tINICIO");
            System.out.print("1. Añadir lista\n2.Añadir beneficiario\n3.Elimiar Beneficiario\n4.Salir");
            System.out.println("");
            n = new Scanner(System.in);
            op = n.nextInt();

            switch(op){
              case 1:
                numBenef=Beneficiario.readLines(beneficiarios);
                System.out.println(numBenef);
                //System.out.println(beneficiarios);
                for(Map.Entry m:beneficiarios.entrySet()){
                  System.out.println(m.getKey()+" "+m.getValue());
                }

                break;

              case 2:
                System.out.println("Añadir beneficiario");
                Beneficiario.beneficiarioInterfaz(beneficiarios);
                break;

              case 3:
                System.out.println("Eliminar Beneficiario");
                Beneficiario.eliminarBeneficiario(beneficiarios);
                System.out.println("El beneficiario ha sido eliminado");
                break;

              case 4:
                exit1=true;
                break;
            }
          }while(exit1!=true);
          break;

      case 2:
        exit2=true;
        break;

      }
    }while(exit2!=true);*/

  }
}
