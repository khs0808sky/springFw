package app.labs.project.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {

	PlayerVO player = new PlayerVO();
	@Autowired
	IPlayerRepository playerRepository;
	
	@Override
	public void click() {
		playerRepository.click();
	}

	@Override
	public void levelUp() {
		playerRepository.levelUp();

	}

	@Override
	public boolean buyCar() {
		return playerRepository.buyCar();
	}

	@Override
	public boolean buyHouse() {
		return playerRepository.buyHouse();
	}

	@Override
	public boolean buyClothes() {
		return playerRepository.buyClothes();
	}

}
