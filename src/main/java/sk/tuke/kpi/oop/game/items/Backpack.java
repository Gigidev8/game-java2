package sk.tuke.kpi.oop.game.items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.ActorContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Backpack implements ActorContainer<Collectible> {
    private final String name;
    private final int capacity;
    private List<Collectible> Backpack = new ArrayList<>();

    public Backpack(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public @NotNull List<Collectible> getContent() {
        return List.copyOf(Backpack);
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getSize() {
        return Backpack.size();
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public void add(@NotNull Collectible actor) {
        if (Backpack.size() < getCapacity()) {
            Backpack.add(actor);
        }
        else  {
            throw new IllegalStateException(getName()+" is full");
        }
    }

    @Override
    public void remove(@NotNull Collectible actor) {
        if (Backpack !=null)
            Backpack.remove(actor);
    }

    @NotNull
    @Override
    public Iterator<Collectible> iterator() {
        return Backpack.iterator();
    }

    @Nullable
    @Override
    public Collectible peek() {
        if (getSize()>0) {
            return Backpack.get(getSize()-1);
        }
        else {
            return null;
        }
    }

    @Override
    public void shift() {
        Collections.rotate(Backpack, 1);
    }
}
