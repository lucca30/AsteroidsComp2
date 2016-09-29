/*
 * Author: Lucca Martins Felix
 * 
 *  This project was developed in GitHub.
 *  See on github.com/lucca30
 *
 */
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Jogo{
    static double INF = 0x3f3f3f3f;
    Pilha pilha = new Pilha(5000);
    Nave nave = new Nave();
    List<Tiro> Lista_tiros = new ArrayList<Tiro>();
    int score =0, lives = 3;
    
    
    public Jogo(){
        for(int i=0;i<6;i++){
            pilha.push(new Asteroide(nave));
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
        if(lives==0){return;}
        if(tecla.equals(" ")){
            Lista_tiros.add(new Tiro(nave));
            Motor.tocar("shoot.wav");
        }        
    }
    
    public void tique(Set<String> teclas, double dt){
        move(dt);
        if(lives==0){return;}
        K_events(teclas, dt);
        Colision_events(dt);
        pilha.gera(dt, nave);
    }
        
    public void desenhar(Tela tela){
        if(lives==0){
            tela.texto(String.format("GAME OVER"), 170, 300, 70, Cor.BRANCO);
        }
        else{
            tela.texto(String.format("%04d", score), 10, 36, 36, Cor.BRANCO);
            tela.texto(String.format("%d", lives), 770  , 36, 36, Cor.BRANCO);
            for(Tiro elemento : Lista_tiros){
                if(!elemento.live){continue;}
                elemento.desenhar(tela);
            }
            nave.desenhar(tela);
        }
        for(int i=0;i<pilha.topo;i++){
            if(!pilha.array[i].live){continue;}
            pilha.array[i].desenhar(tela);
        }        
    }
   
    public static void main(String[] args) {
        new Motor(new Jogo());
    }

    
    
    /*Non-Default methods*/
    public void move(double dt){
        /*Asteroids movement (Even after the end game)*/
        for(int i=0;i<pilha.topo;i++){
            pilha.array[i].mover(dt, this);
        }    
        if(lives==0){return;}
        nave.move(dt, this);    
    }
    
    public void K_events(Set<String> teclas, double dt){
        if(teclas.contains("up")){
            nave.on = true;
            nave.acelerate(dt);
        }
        else {
            nave.on = false;
        }
        if(teclas.contains("right")){
            nave.to_right(dt);
        }
        else if(teclas.contains("left")){
            nave.to_left(dt);
        }
    }
    
    public void Colision_events(double dt){
        for(Tiro elemento : Lista_tiros){
            if(!elemento.live){continue;}
            elemento.mover(dt);
            /*Check colision with shots and asteroids*/
            for(int i=0;i<pilha.topo;i++){
                if(pilha.array[i].hit.colision(elemento.hit)){
                    if(!pilha.array[i].live){continue;}
                    pilha.array[i].live = false;
                    elemento.live = false;
                    score+=100;
                    if(pilha.array[i].size==3){
                        pilha.push(new Asteroide(1, -pilha.array[i].Vx, pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                        pilha.push(new Asteroide(1, pilha.array[i].Vx, -pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                    }
                    else if(pilha.array[i].size==4){
                        pilha.push(new Asteroide(2, -pilha.array[i].Vx, pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                        pilha.push(new Asteroide(1, pilha.array[i].Vx, -pilha.array[i].Vy, pilha.array[i].x, pilha.array[i].y));
                    }
                    pilha.array[i].x = INF;
                    pilha.array[i].y = INF;
                    break;
                }
            }    
        }
        /*Check colision with spacecraft and asteroids*/
        for(int i=0;i<pilha.topo;i++){
            if(pilha.array[i].hit.colision(nave.hit)){
                if(!pilha.array[i].live){continue;}
                Motor.tocar("explosion.wav");
                lives--;
                nave = new Nave();
                pilha.array[i].live = false;
                pilha.array[i].x = INF;
                pilha.array[i].y  = INF;
            }
        }
    
    }
    
}