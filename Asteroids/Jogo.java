import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jogo{
    Asteroide[] pedras = new Asteroide[6];
    Nave nave = new Nave();
    List<Tiro> Lista_tiros = new ArrayList<Tiro>();
    Iterator<Tiro> it = Lista_tiros.iterator();
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
    
    
    public void tecla(String tecla){
    	if(tecla.equals(" ")){
    		Lista_tiros.add(new Tiro(nave));
    	}
    	
    }
    
    
    public void tique(Set<String> teclas, double dt){
        for(Asteroide elemento:pedras){
        	elemento.Rotation += elemento.Rs;
            elemento.mover(dt, this);
        }       
        if(teclas.contains("up")){
            nave.on = true;
            nave.acelerate(dt);
        }
        else {
            nave.on = false;
        }
        nave.move(dt, this);
        if(teclas.contains("right")){
        	nave.to_right(dt);
        }
        else if(teclas.contains("left")){
        	nave.to_left(dt);
        }
        for(Tiro elemento : Lista_tiros){
        	elemento.mover(dt);
//            if(elemento.x>= this.getLargura() || elemento.x<=0){
//            	Lista_tiros.remove(elemento);
//            }
//            if(elemento.y>=this.getAltura() || elemento.y<=0){
//            	Lista_tiros.remove(elemento);
//            }
        	for(Asteroide pedra:pedras){
        		if(elemento.hit.colision(pedra.hit)){
        			pedra.x = pedra.y = 1000000;
        		}
        	}
        }
        
    }
    
    
    public void desenhar(Tela tela){
        
        for(Asteroide elemento:pedras){
            elemento.desenhar(tela);
        }
        for(Tiro elemento : Lista_tiros){
        	elemento.desenhar(tela);
        }
        nave.desenhar(tela);
    }
    public static void main(String[] args) {
        new Motor(new Jogo());
    }

}