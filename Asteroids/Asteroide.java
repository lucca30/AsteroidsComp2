public class Asteroide{
    double x, y;
    int size;
    int cor;
    double Vx, Vy;
    double Rs, Rotation;
    boolean live;
    Hitbox_circle hit;
    
    
    public Asteroide(){
        this.x = Math.round(Math.random() * 700);
        this.y =  Math.round(Math.random() * 500);
        this.Vx =  Math.round(Math.random() * 300);
        this.Vy =  Math.round(Math.random() * 300);
        this.size = (int) Math.round(Math.random() * 3)+1;
        this.cor = (int) Math.round(Math.random() * 10);
        this.Rs = (Math.random() * 2*Math.PI);
        this.Rotation =  0;
        this.hit = new Hitbox_circle(this.x, this.y, 32);
        this.live = true;
    }
    
    public Asteroide(int size, double vx, double vy, double x, double y){
        this.x = x;
        this.y = y;
        this.Vx = vx;
        this.Vy = vy;
        this.size = size;
        this.cor = (int) Math.round(Math.random() * 10);
        this.Rs = (Math.random() * 2*Math.PI);
        this.Rotation =  0;
        this.hit = new Hitbox_circle(this.x, this.y, 32);
        this.live = true;
    }
    
    
    public void mover(double dt, Jogo jogo){
        if(!live){return;}
        x += Vx * dt;
        y += Vy * dt;
        hit.x = x;
        hit.y = y;
        if(x>= jogo.getLargura()){x = 0;}
        else if(x<=0){x = jogo.getLargura();}
        if(y>= jogo.getAltura()){y = 0;}
        else if(y<=0){y = jogo.getAltura();}
        Rotation += Rs*dt;

    }
    int xi, yi, alt, larg;
    public void desenhar(Tela t){
        if(!live){return;}
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