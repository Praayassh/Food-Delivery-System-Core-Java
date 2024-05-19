package np.com.prayashsapkota.restaurantsManagement;

import np.com.prayashsapkota.base.Restaurant;
import np.com.prayashsapkota.base.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {

    private final List<Restaurant> restaurantList = new ArrayList<>();

    private void restaurantAndMenuList() {

        Restaurant restaurant1 = new Restaurant("Bajeko Sekuwa");
        restaurant1.addMenu(new MenuItem("Mutton Sekuwa", 400, 1));
        restaurant1.addMenu(new MenuItem("Chicken Sekuwa", 350, 1));
        restaurant1.addMenu(new MenuItem("Buff Sekuwa", 320, 1));
        restaurant1.addMenu(new MenuItem("Choila", 150, 1));
        restaurantList.add(restaurant1);

        Restaurant restaurant2 = new Restaurant("Kitchen Corner");
        restaurant2.addMenu(new MenuItem("Hot Dog", 400, 1));
        restaurant2.addMenu(new MenuItem("Corn Dog", 350, 1));
        restaurant2.addMenu(new MenuItem("Pizza", 320, 1));
        restaurant2.addMenu(new MenuItem("Chicken Momo", 150, 1));
        restaurantList.add(restaurant2);

        Restaurant restaurant3 = new Restaurant("Coffee King");
        restaurant3.addMenu(new MenuItem("Americano", 200, 1));
        restaurant3.addMenu(new MenuItem("Cappuccino", 250, 1));
        restaurant3.addMenu(new MenuItem("Latte", 220, 1));
        restaurant3.addMenu(new MenuItem("Macchiato", 270, 1));
        restaurantList.add(restaurant3);

        Restaurant restaurant4 = new Restaurant("The Burger House");
        restaurant4.addMenu(new MenuItem("Chicken Burger", 250, 1));
        restaurant4.addMenu(new MenuItem("Chicken Cheese Burger", 270, 1));
        restaurant4.addMenu(new MenuItem("Pizza", 200, 1));
        restaurant4.addMenu(new MenuItem("Chicken Momo", 150, 1));
        restaurantList.add(restaurant4);

    }

    public void initializeRestaurantsAndMenu() {
        restaurantAndMenuList();
    }

    public List<Restaurant> getRestaurantsList() {
        return restaurantList;
    }

}
