import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Jogo{
    Pilha pilha = new Pilha(5000);
    Nave nave = new Nave();
    List<Tiro> Lista_tiros = new ArrayList<Tiro>();
    public Jogo(){
        for(int i=0;i<6;i++){
            pilha.push(new Asteroide());
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
        for(int i=0;i<pilha.topo;i++){
            pilha.array[i].mover(dt, this);
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
            if(!elemento.live){continue;}
            elemento.mover(dt);
//            if(elemento.x>= this.getLargura() || elemento.x<=0){
//              Lista_tiros.remove(elemento);
//            }
//            if(elemento.y>=this.getAltura() || elemento.y<=0){
//              Lista_tiros.remove(elemento);
//            }
            for(int i=0;i<pilha.topo;i++){
                if(pilha.array[i].hit.colision(elemento.hit)){
                    if(!pilha.array[i].live){continue;}
                    pilha.array[i].live = false;
                    elemento.live = false;
                    if(pilha.array[i].size==3){
                        pilha.push(new Asteroide(1, -pilha.array[i].Vx, pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                        pilha.push(new Asteroide(1, pilha.array[i].Vx, -pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                    }
                    else if(pilha.array[i].size==4){
                        pilha.push(new Asteroide(2, -pilha.array[i].Vx, pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                        pilha.push(new Asteroide(1, pilha.array[i].Vx, -pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                    }
                    pilha.array[i].x = 10000;
                    pilha.array[i].y = 10000;
                    break;
                }
            }
            
        }
        
    }
    
    
    public void desenhar(Tela tela){
        
        for(int i=0;i<pilha.topo;i++){
            pilha.array[i].desenhar(tela);
        }
        for(Tiro elemento : Lista_tiros){
            if(!elemento.live){continue;}
            elemento.desenhar(tela);
        }
        nave.desenhar(tela);
    }
    public static void main(String[] args) {
        new Motor(new Jogo());
    }

}