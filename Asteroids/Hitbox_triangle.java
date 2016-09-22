public class Hitbox_triangle{
    double x_f, y_f, x_l, y_l, x_r, y_r;
    public Hitbox_triangle(Nave nave){
        this.x_f = nave.x;
        this.y_f = nave.y+nave.center_tofront;
    }
}
