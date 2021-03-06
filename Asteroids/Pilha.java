/*
 * Own Stack Implementation
 */
public class Pilha{
    static double new_pedra_time = 5;
    int topo;
    Asteroide[] array;
    double ciclo;
    
    
    public Pilha(int limite){
        this.topo = 0;
        this.array = new Asteroide[limite];
        this.ciclo = 0;
    }
    
    public void push(Asteroide pedra){
        array[topo++] = pedra;
    }
    
    public void gera(double dt, Nave nave){
        ciclo += dt;
        if(ciclo>=new_pedra_time){
            ciclo = 0;
            this.push(new Asteroide((int) Math.round(Math.random())+3, nave));
        }
    }
}
