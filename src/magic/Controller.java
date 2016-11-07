package magic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {
    public AnchorPane apMainPane;
    public ListView<String> lvLlistaCartes;

    public void initialize(){

        // Personalitzem la CellFactory
        lvLlistaCartes.setCellFactory((list) -> {
            return new ListCell<String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(new ImageView("icon.png"));
                        setText(item);
                    }
                }
            };
        });

        // Afegir llista observable d'items
        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian");
        lvLlistaCartes.setItems(names);

        // Afegir un item
        lvLlistaCartes.getItems().add("Pepi");

        // Handle ListView selection changes with a listener
        lvLlistaCartes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                System.out.println("ListView Selection Changed (selected: " + newValue.toString() + ")");
            }
        );
    }

}
