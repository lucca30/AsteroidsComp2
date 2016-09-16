public class Asteroide{
	double x, y;
	int size;
	Cor cor;
	int Vx, Vy;
	double Rs;
	
	public Asteroide(){
		this.x = (int) (Math.random() * 700);
		this.y = (int) (Math.random() * 500);
		this.Vx = (int) (Math.random() * 300);
		this.Vy = (int) (Math.random() * 300);
		this.size = (int) (Math.random() * 4)+1;
		this.cor = new Cor((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)) ;
		this.Rs = (Math.random() * 2*Math.PI);
	}
	
	public void mover(double dt, Jogo jogo){
		x += Vx * dt;
		y += Vy * dt;
		if(x>= jogo.getLargura()){x = 0;}
		else if(x<=0){x = jogo.getLargura();}
		if(y>= jogo.getAltura()){y = 0;}
		else if(y<=0){y = jogo.getAltura();}

	}
	public void desenhar(Tela t){
		t.imagem("asteroids.png", 4, 4, 8, 8, Rs, x, y);
	}
	
	
}