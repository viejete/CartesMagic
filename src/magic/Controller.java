package magic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Controller {
    public AnchorPane apMainPane;
    public ListView<String> lvLlistaCartes;

    public void initialize(){
        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian");
        lvLlistaCartes.setItems(names);

        // Handle ListView selection changes.
        lvLlistaCartes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                System.out.println("ListView Selection Changed (selected: " + newValue.toString() + ")");
            }
        );
    }

}
