package app.labs.project.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayerVO {
	private int playerMoney = 0;
    private int playerLevel = 1;
    private int playerClickPower = 1;
}
