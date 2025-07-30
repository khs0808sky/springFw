package app.labs.project.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;	

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	IPlayerRepository playerRepository;
	
	@Override
	public void click() { playerRepository.click(); }

	@Override
	public void levelUp() {	playerRepository.levelUp(); }

	@Override
	public boolean buyCar(Car car) { return playerRepository.buyCar(); }

	@Override
	public boolean buyHouse(House house) { return playerRepository.buyHouse(); }

	@Override
	public boolean buyClothes(Clothes clothes) { return playerRepository.buyClothes(); }

}
