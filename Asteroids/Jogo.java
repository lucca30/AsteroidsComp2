import java.util.Set;

public class Jogo{
    Asteroide[] pedras = new Asteroide[6];
    Nave nave = new Nave();
    public Jogo(){
        for(int i=0;i<6;i++){
            pedras[i] = new Asteroide();
        }
    }
    public String getTitulo(){
        return "Asteroids";
    }
    public int getAltura(){
        return 600;
    }
    public int getLargura(){
        return 800;
    }
    public void tecla(String tecla){}
    public void tique(Set<String> teclas, double dt){
        for(Asteroide elemento:pedras){
            elemento.mover(dt, this);
        }       
        if(teclas.contains("up")){
            nave.on = true;
        }
        else {
            nave.on = false;
        }
    }
    public void desenhar(Tela tela){
        nave.desenhar(tela);
        for(Asteroide elemento:pedras){
            elemento.desenhar(tela);
        }

    }
    public static void main(String[] args) {
        new Motor(new Jogo());
    }

}