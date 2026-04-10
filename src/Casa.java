import metodos.PlantaCasa;

public class Casa {
    public static void main(String[] args) {
        //criando instância da classe (PlantaCasa)
        PlantaCasa casa = new PlantaCasa();

        //inicializando os atributos (variáveis) (características) casa
        casa.numeroBanheiros = 2;
        casa.numeroQuartos = 3;
        casa.metragem = 70;
        casa.material = "Tijolo";
        casa.cor = "Azul";

        //chamada dos métodos
        casa.construir();
        casa.pintar();
        casa.mudarCorParede("Marrom");

        casa.alterarCaracteristicas(39,5,4, "Alvenaria");
       //criando uma segunda instância da classe (PlantaCasa)
        PlantaCasa casaVizinho = new PlantaCasa();
        casaVizinho.numeroBanheiros = 2;
        casaVizinho.numeroQuartos = 3;
        casaVizinho.metragem = 200;
        casaVizinho.material = "Tijolo";
        casaVizinho.cor = "Verde";

        casaVizinho.construir();
        casaVizinho.pintar();
        int resultado = casaVizinho.somarMetragem();
        System.out.println(resultado);
    }
}
