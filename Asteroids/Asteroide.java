public class Asteroide{
    double x, y;
    int size;
    int cor;
    int Vx, Vy;
    double Rs, Rotation;
    Hitbox_circle hit;
    
    
    public Asteroide(){
        this.x = (int) Math.round(Math.random() * 700);
        this.y = (int) Math.round(Math.random() * 500);
        this.Vx = (int) Math.round(Math.random() * 300);
        this.Vy = (int) Math.round(Math.random() * 300);
        this.size = (int) Math.round(Math.random() * 4);
        this.cor = (int) Math.round(Math.random() * 10);
        this.Rs = (Math.random() * 0.01*Math.PI);
        this.Rotation =  0;
        this.hit = new Hitbox_circle(this.x, this.y, 32);
    }
    
    public void mover(double dt, Jogo jogo){
        x += Vx * dt;
        y += Vy * dt;
        hit.x = x;
        hit.y = y;
        if(x>= jogo.getLargura()){x = 0;}
        else if(x<=0){x = jogo.getLargura();}
        if(y>= jogo.getAltura()){y = 0;}
        else if(y<=0){y = jogo.getAltura();}

    }
    int xi, yi, alt, larg;
    public void desenhar(Tela t){
        if(size==1){yi=4 + (48 * cor);}
        else{yi=0 + (48 * cor);}
        switch(size){
           case 1:
            xi=4;
            larg = alt = 8;
            break;
           case 2:
            xi=17;
            larg = alt = 15;
            break;
           case 3:
            xi=32;
            larg = alt = 32;
            break;
           case 4:
            xi=65;
            larg = 47;
            alt = 47;
            break;
           
        }
        t.imagem("asteroids.png", xi, yi, larg, alt, Rotation, x, y);
    }
    
    
}