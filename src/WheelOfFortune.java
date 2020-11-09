import com.codebuster.enums.Category;
import com.codebuster.game.Game;

public class WheelOfFortune {
    public static void main(String[] args) {
        Game game = new Game(Category.AROUND_THE_HOUSE, "Lightbulb and Lampshade");
        game.start();
    }
}
