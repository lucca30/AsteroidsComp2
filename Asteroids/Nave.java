

public class Nave{
    double x, y, Rs, speed;
    boolean on;
    
    public Nave(){
        this.x = 400;
        this.y = 300;
        this.on = false;
    }
    
    public void desenhar(Tela t){
        if(on){
            t.imagem("naves.png", 135, 0, 50, 60, 0.0, x, y);
        }
        else{
            t.imagem("naves.png", 70, 0, 50, 60, 0.0, x, y);
        }

    }
}
