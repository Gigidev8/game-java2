package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.Game;
import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.WindowSetup;
import sk.tuke.kpi.gamelib.World;
import sk.tuke.kpi.gamelib.backends.lwjgl.LwjglBackend;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.oop.game.scenarios.FirstSteps;

public class Main {
    public static void main(String[] args) {
        WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);

        Game game = new GameApplication(windowSetup, new LwjglBackend());

        Scene scene = new World("world");

        FirstSteps firstSteps = new FirstSteps();
        scene.addListener(firstSteps);

        game.addScene(scene);

        game.getInput().onKeyPressed(Input.Key.ESCAPE, game::stop);

        game.start();
    }
}
