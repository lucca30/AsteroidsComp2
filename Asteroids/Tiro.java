public class Tiro {
	static double Speed = 700;
	static int Raio = 1;
	double x, y, vx, vy;
	Cor cor;
	boolean live;
	Hitbox_circle hit;
	
	
	public Tiro(Nave nave){
    	this.vx = Math.sin(nave.Rotation)*Speed+nave.vx;
    	this.vy = -Math.cos(nave.Rotation)*Speed+nave.vy;
    	this.x = nave.x_f;
		this.y = nave.y_f;
		this.cor = new Cor(255, 255, 255);
		this.hit = new Hitbox_circle(this.x, this.y, Raio);
		this.live = true;
	}
	
	
	public void desenhar(Tela t){
		t.circulo(x, y, Raio, cor);		
	}
	
	public void mover(double dt){
		x += vx*dt;
		y += vy*dt;
		hit.x = x;
		hit.y = y;
	}
}
