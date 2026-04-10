package metodos;

public class PlantaCasa {
    //public pode ser usado por todas as classes
    //private só pode ser usado na própria classe onde foi declarada
    //protected é apenas para as subclasses dentro do mesmo package (pasta)

    //para nomear classes, usar sempre verbos e camelCase (não utilizar artigos = pintar'A'Cozinha)
    //PascalCase (Classes) -> Exemplos: PlantaCasa, Usuario, ContaBancaria, PedidoController
    //camelCase (Métodos e Variáveis) -> Ex: imprimirRelatorio(), casaVizinho
    //SNAKE_CASE (Constantes) -> Ex: VALOR_MAXIMO, PI

    //retornos de métodos podem ser int, double, boolean (utilizando o return)... ou void (caso não haja retorno)

    //Atributos
    public int metragem;
    public int numeroQuartos;
    public int numeroBanheiros;
    public String cor;
    public String material;

    public void construir(){
        System.out.println("Metragem: " + metragem);
        System.out.println("Número de quartos: " + numeroQuartos);
        System.out.println("Número de banheiros: " + numeroBanheiros);
        System.out.println("Material: " + material);
    }

    public void pintar(){
        System.out.println("Cor: " + cor);
    }

    public void mudarCorParede(String novaCor){ //<- parâmetro do método
        cor = novaCor;
        pintar();
    }

    //retorna um cálculo, visto isso há um retorno int
    public int somarMetragem(){
        return metragem * numeroBanheiros + numeroQuartos;
    }

    public void alterarCaracteristicas(int metros, int quartos, int banheiros, String mate){ //<- parâmetros do método
        metragem=metros;
        numeroQuartos=quartos;
        numeroBanheiros=banheiros;
        material = mate;
        construir();
    }


}
