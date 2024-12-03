package sk.tuke.kpi.oop.game.items;
import sk.tuke.kpi.gamelib.graphics.Animation;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.gamelib.framework.AbstractActor;

public class Ammo extends AbstractActor implements Usable<Ripley> {
    private Ripley ripely;

    public Ammo() {
        setAnimation(new Animation("sprites/ammo.png", 16, 16));
    }

    @Override
    public void useWith(Ripley ripley) {
        if (ripley == null) return;

        int maxBullets = 500;
        int ammoIncrease = 50;
        int currentBullets = ripley.getAmmo();

        if (currentBullets < maxBullets) {
            ripley.setAmmo(Math.min(currentBullets + ammoIncrease, maxBullets));
            getScene().removeActor(this);
        }
    }

    @Override
    public Class<Ripley> getUsingActorClass() {
        return Ripley.class;
    }
}

