package np.com.prayashsapkota.base;

import np.com.prayashsapkota.base.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final List<MenuItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenu(MenuItem item) {
        menu.add(item);
    }

    public void clearCart() {
        menu.clear();

    }
}
