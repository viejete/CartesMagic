package magic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public AnchorPane apMainPane;
    public ListView<Person> lvLlistaCartes;

    public void initialize(){

        // Personalitzem la CellFactory
        lvLlistaCartes.setCellFactory((list) -> {
            return new ListCell<Person>() {
                @Override
                public void updateItem(Person item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(new ImageView(item.getImg()));
                        setText(item.getName());
                    }
                }
            };
        });

        // Afegir llista observable d'items
        ObservableList<Person> persons = FXCollections.observableArrayList(
                new Person("Julia", "icon.png"), new Person("Greta", "icon.png"));
        lvLlistaCartes.setItems(persons);

        // Afegir un item
        lvLlistaCartes.getItems().add(new Person("Pepi", "icon.png"));

        // Handle ListView selection changes with a listener
        lvLlistaCartes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                System.out.println("ListView Selection Changed (selected: " + newValue.getName() + ")");
            }
        );
    }


    class Person {
        String name;
        String img;

        public Person(String name, String img) {
            this.name = name;
            this.img = img;
        }

        public String getImg() {
            return img;
        }

        public String getName() {
            return name;
        }
    }

}
