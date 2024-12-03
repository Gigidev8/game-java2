package sk.tuke.kpi.oop.game.scenarios;
import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.gamelib.graphics.Overlay;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.*;

public class FirstSteps implements SceneListener {
    private Ripley ripley;
    Hammer hammer = new Hammer();
    FireExtinguisher fireExtinguisher = new FireExtinguisher();
    Wrench wrench = new Wrench();

    @Override
    public void sceneInitialized(Scene scene) {
        ripley = new Ripley();
        scene.addActor(ripley, 0, 0);

        KeeperController keeperController = new KeeperController(ripley);
        scene.getInput().registerListener(keeperController);

        MovableController controller = new MovableController(ripley);
        scene.getInput().registerListener(controller);

        Energy energy = new Energy();
        scene.addActor(energy,-100,50);

        Ammo ammo = new Ammo();
        scene.addActor(ammo,-100,75);

        ripley.getBackpack().add(hammer);
        ripley.getBackpack().add(fireExtinguisher);
        ripley.getBackpack().add(wrench);

        scene.getGame().pushActorContainer(ripley.getBackpack());
        ripley.getBackpack().shift();
    }

    @Override
    public void sceneUpdating(  Scene scene) {
        Overlay overlay = scene.getGame().getOverlay();

        int windowHeight = scene.getGame().getWindowSetup().getHeight();
        int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;

        int xTextPos = 100;
        overlay.drawText("Energy: " + ripley.getEnergy(), xTextPos, yTextPos);
        scene.getGame().getOverlay().drawText("Ammo: " +ripley.getAmmo(), 320, yTextPos);
    }
}
