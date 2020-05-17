package inicio_logica_games;

import java.util.ArrayList;

// todo game possui um game loop
//para execussão é necessário threads, para que possa ser executado mais de um código ao mesmo tempo
//implementa runnable
public class Game implements Runnable{
	
	private boolean isRunning;
	private Thread thread;
	//array de entidades
	private ArrayList<Entidade> entidades;
	
	//construtor
	public Game() {
		entidades.add(new Entidade());
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
	
	private synchronized void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	}

	public void tick() {
		//atualiza o jogo
		System.out.println("tick");
	}
	public void render() {
		//renderiza o jogo
		System.out.println("render");
	}
	@Override
	public void run() {
		//metodo que roda o jogo
		
		//game loop
		while(isRunning) {
			tick();
			render();
			
			
			//setta FPS 1000ms/60 = 1x por segundo
//			try {
//				Thread.sleep(1000/60);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
}
