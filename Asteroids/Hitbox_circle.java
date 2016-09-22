public class Hitbox_circle {
	double x, y, raio;

	
	public Hitbox_circle(double x, double y, double raio){
		this.x = x;
		this.y = y;
		this.raio = raio;
	}
	
	public Hitbox_circle(double x, double y, int raio){
		this.x = x;
		this.y = y;
		this.raio = (double) raio;		
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
