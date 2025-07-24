package app.labs.project;

import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {

	Player player = new Player();
	
	@Override
	public void click() {
		player.click();
	}

	@Override
	public void levelUp() {
		player.levelUp();

	}

	@Override
	public boolean buyCar() {
		return player.buyCar();
	}

	@Override
	public boolean buyHouse() {
		return player.buyHouse();
	}

	@Override
	public boolean buyClothes() {
		return player.buyClothes();
	}

}
