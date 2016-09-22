

public class Nave{
    static double Rs = 5;
    static double speed = 350;
    static double maxspeed = 450;
    static int larg = 50;
    static int alt = 60;
    static double center_tofront = 18;
    double x, y, Rotation;
    double vx, vy;
    boolean on;
    double x_f, y_f;    
    Hitbox_circle hit;
    
    public Nave(){
        this.x = 400;
        this.y = 300;
        this.on = false;
        this.Rotation = 0;
        this.vx = 0;
        this.vy = 0;
        this.x_f = this.x;
        this.y_f = this.y+this.center_tofront;
        this.hit = new Hitbox_circle(this.x+larg/2, this.y+alt/2, 5.0);
    }
    
    public void to_left(double dt){
        Rotation -= Rs*dt;
    }
    
    public void to_right(double dt){
        Rotation += Rs*dt;
    }
    public void acelerate(double dt){
        vx += dt*Math.sin(Rotation)*speed;
        vy -= dt*Math.cos(Rotation)*speed;
        if(vx>=maxspeed){vx = maxspeed;}
        else if(vx<=-maxspeed){vx = -maxspeed;}
        if(vy>=maxspeed){vy = maxspeed;}
        else if(vy<=-maxspeed){vy = -maxspeed;}
    }
    public void move(double dt, Jogo jogo){
        x+=vx*dt;
        y+=vy*dt;
        if(x-larg/2>= jogo.getLargura()){x = 0;}
        else if(x+larg/2<=0){x = jogo.getLargura();}
        if(y-alt/2>= jogo.getAltura()){y = 0;}
        else if(y+alt/2<=0){y = jogo.getAltura();}
        hit.x = x+larg/2;
        hit.y = y+alt/2;
        this.x_f = (x+larg/2) + (Math.sin(Rotation)*center_tofront);
        this.y_f = (y+alt/2) - (Math.cos(Rotation)*center_tofront); 
    }
    
    public void desenhar(Tela t){
        if(on){
            t.imagem("naves.png", 135, 0, larg, alt, Rotation, x, y);
        }
        else{
            t.imagem("naves.png", 70, 0, larg, alt, Rotation, x, y);
        }

    }
}
