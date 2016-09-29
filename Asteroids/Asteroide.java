public class Asteroide{
    static int X_size1 = 4;
    static int X_size2 = 17;
    static int X_size3 = 32;
    static int X_size4 = 65;
    
    static int DIM_size1 = 8;
    static int DIM_size2 = 15;
    static int DIM_size3 = 32;
    static int DIM_size4 = 47;
    
    static double Spawn_dist = 300.0;
    
    double x, y;
    int size;
    int cor;
    double Vx, Vy;
    double Rs, Rotation;
    boolean live;
    Hitbox_circle hit;
    int xi, yi, alt, larg;
    
    
    
    public Asteroide(Nave nave){
        this.size = (int) Math.round(Math.random() * 3)+1;
        while(true){
            this.x = Math.round(Math.random() * 700);
            this.y =  Math.round(Math.random() * 500);
            this.hit = new Hitbox_circle(this.x, this.y, this.size);
            /*Check the distance between spacecraft and new asteroid*/
            if(Math.sqrt((this.x-nave.x)*(this.x-nave.x) + (this.y-nave.y)*(this.y-nave.y)) >= Spawn_dist){
                break;
            }
        }
        this.Vx =  Math.round(Math.random() * 300);
        this.Vy =  Math.round(Math.random() * 300);
        this.cor = (int) Math.round(Math.random() * 10);
        this.Rs = (Math.random() * 2*Math.PI);
        this.Rotation =  0;
        this.live = true;
    }

    public Asteroide(int size, Nave nave){
        this.size = size;
        while(true){
            this.x = Math.round(Math.random() * 700);
            this.y =  Math.round(Math.random() * 500);
            this.hit = new Hitbox_circle(this.x, this.y, this.size);
            
            /*Check the distance between spacecraft and new asteroid*/
            if(Math.sqrt((this.x-nave.x)*(this.x-nave.x) + (this.y-nave.y)*(this.y-nave.y)) >= Spawn_dist){
                break;
            }
        }
        this.Vx =  Math.round(Math.random() * 300);
        this.Vy =  Math.round(Math.random() * 300);
        this.cor = (int) Math.round(Math.random() * 10);
        this.Rs = (Math.random() * 2*Math.PI);
        this.Rotation =  0;
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
        this.hit = new Hitbox_circle(this.x, this.y, this.size);
        this.live = true;
    }
    
    
        
    public void mover(double dt, Jogo jogo){
        if(!live){return;}
        x += Vx * dt;
        y += Vy * dt;
        hit.x = x;
        hit.y = y;
        /*Screen limits*/
        if(x>= jogo.getLargura()){x = 0;}
        else if(x<=0){x = jogo.getLargura();}
        if(y>= jogo.getAltura()){y = 0;}
        else if(y<=0){y = jogo.getAltura();}
        Rotation += Rs*dt;

    }
    
    public void desenhar(Tela t){
        if(!live){return;}
        if(size==1){yi=4 + (48 * cor);}
        else{yi=0 + (48 * cor);}
        switch(size){
           case 1:
            xi = X_size1;
            larg = alt = DIM_size1;
            break;
           case 2:
            xi = X_size2;
            larg = alt = DIM_size2;
            break;
           case 3:
            xi = X_size3;
            larg = alt = DIM_size3;
            break;
           case 4:
            xi = X_size4;
            larg = alt = DIM_size4;
            break;
           
        }
        t.imagem("asteroids.png", xi, yi, larg, alt, Rotation, x, y);
    }
}