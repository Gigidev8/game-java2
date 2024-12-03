package sk.tuke.kpi.oop.game.characters;
import sk.tuke.kpi.oop.game.Direction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.Movable;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.oop.game.items.Backpack;


public class Ripley extends AbstractActor implements Movable, Keeper {
    private int speed;
    private int energy;
    private int Ammo;
    private Backpack backpack;


    public Ripley() {
        super("Ellen");
        this.speed = 2;
        this.energy = 100;
        this.Ammo = 0;
        backpack = new Backpack("Ripley's backpack",10);
        Animation animation = new Animation("sprites/player.png", 32, 32, 0.1f, Animation.PlayMode.LOOP_PINGPONG);
        setAnimation(animation);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            this.energy = 0;
        } else if (energy > 100) {
            this.energy = 100;
        } else {
            this.energy = energy;
        }
    }

    public int getAmmo() {
        return Ammo;
    }

    public void setAmmo(int bullets) {
        this.Ammo = bullets;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    @Override
    public void startedMoving(Direction direction) {
        getAnimation().setRotation(direction.getAngle());
        getAnimation().play();
    }

    @Override
    public void stoppedMoving() {
        getAnimation().pause();
    }
}

