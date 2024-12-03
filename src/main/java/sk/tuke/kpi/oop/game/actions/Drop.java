package sk.tuke.kpi.oop.game.actions;

import sk.tuke.kpi.gamelib.framework.actions.AbstractAction;
import sk.tuke.kpi.oop.game.Keeper;
import sk.tuke.kpi.oop.game.items.Collectible;

public class Drop <A extends Keeper> extends AbstractAction<A> {

    @Override
    public void execute(float deltaTime) {

        if (getActor()==null) {
            setDone(true);
            return;
        }

        if (getActor().getBackpack().peek()==null || getActor().getScene()==null) {
            setDone(true);
            return;
        }

        if (!isDone()) {
            Collectible finaltools = getActor().getBackpack().peek();
            assert finaltools != null;
            getActor().getScene().addActor(finaltools, (getActor().getPosX() + (getActor().getWidth()- finaltools.getWidth()/2)), (getActor().getPosY() + (getActor().getHeight()- finaltools.getHeight()/2)));
            getActor().getBackpack().remove(finaltools);
        }
        setDone(true);
    }
}
