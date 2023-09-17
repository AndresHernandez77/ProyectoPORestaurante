public class Chef extends Trabajador{
  private double presupuestoComida;
  private int numBenef;
  private boolean servido=false;
  private String desa;
  private String comi;
  private String cena;
  DateTime dt = new DateTime();
  int hora = dt.getHours();

  public boolean getServido(){
    return servido;
  }

  public void setNumBenef(int numBenef){
    this.numBenef=numBenef;
  }

  public setPresupuestoComida(double presupuestoComida){
    this.presupuestoComida=presupuestoComida;
  }

  private void hacerComida(){
    System.out.println("Hago comida...");
    System.out.println("La comida que voy a servir es: "+menu(hora));
  }

  public static boolean comprarIngredientes(){
    if(presupuestoComida<(numBenef*150)){
      System.out.println("No puedo comprar ingredientes");
      return false;
    }else{
      hacerComida();
      servir();
      servido=true;
      return true;
    }
  }

  private boolean servir(){
    return true;
  }


  public String menu(int hora){
		this.desa = "Huevos con salsa acompañados con frijoles, tortillas, galletas y café";
		this.comida= "Guisado de carne con sopa, arroz, chícharos, frijoles, tortillas y agua de sabor";
		this.cena="Ensalada de maíz fresco salteado y pollo con café";

    if(hora<8&&hora>7) return desa;
    if(hora<16&&hora>15) return comida;
    if(hora<21&&hora>20) return cena;
	}


  //public String
}
