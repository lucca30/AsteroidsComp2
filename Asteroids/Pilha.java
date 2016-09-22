public class Pilha{
    int topo;
    Asteroide[] array;
    
    public Pilha(int limite){
        this.topo = 0;
        this.array = new Asteroide[limite];
    }
    
    public void push(Asteroide pedra){
        array[topo++] = pedra;
    }
}
