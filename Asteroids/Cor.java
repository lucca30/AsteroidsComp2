
/**
 * Cores em RGB
 */
public class Cor
{
    public int r;
    public int g;
    public int b;
    
    /*
     * Cria uma cor dados os componentes entre 0 e 255
     */
    public Cor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    /*
     * Cria uma cor dados os componentes entre 0 e 1
     */
    public Cor(double r, double g, double b) {
    	this.r = (int)(r*255);
    	this.g = (int)(g*255);
    	this.b = (int)(b*255);
    }
    
    public static Cor BRANCO = new Cor(1.0, 1.0, 1.0);
    public static Cor AZUL = new Cor(0.0, 0.0, 1.0);
    public static Cor VERMELHO = new Cor(1.0, 0.0, 0.0);
    public static Cor VERDE = new Cor(0.0, 1.0, 0.0);
}
