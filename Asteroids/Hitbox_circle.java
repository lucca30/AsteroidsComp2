/*
 * This was the solution developed as we did not know interfaces
 */
public class Hitbox_circle {
    double x, y, raio;

    
    public Hitbox_circle(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }
    
    public Hitbox_circle(double x, double y, int size){
        this.x = x;
        this.y = y;
        switch(size){
            case 1:
                this.raio = 4.0;
                break;
            case 2:
                this.raio = 7.5;
                break;
            case 3:
                this.raio = 16.0;
                break;
            case 4:
                this.raio = 23.5;
                break;
        }
              
    }
    
    
    public boolean colision(Hitbox_circle Circ){
        boolean hit = false;
        double dist = Math.sqrt((this.x-Circ.x)*(this.x-Circ.x)+(this.y-Circ.y)*(this.y-Circ.y));
        if(dist<=this.raio+Circ.raio){
            hit = true;
        }
        
        return hit;
    }
}
