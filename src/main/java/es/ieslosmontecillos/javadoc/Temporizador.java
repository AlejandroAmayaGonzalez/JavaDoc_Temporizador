package es.ieslosmontecillos.javadoc;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.IOException;


/**
 * Class Temporizador
 * Una clase que permite establecer una cuenta atrás.
 * @version 1.0
 * @author  Alejandro Amaya González.
 */
public class Temporizador extends HBox {
    @FXML
    private Label lb_countdown;
    SimpleIntegerProperty counter = new SimpleIntegerProperty(20);

    /**
     * Constructor vacío que carga el archivo fxml del componente y después
     * enlaza el contenido del label con el valor del contador.
     */
    public Temporizador() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "temporizador.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        lb_countdown.textProperty().bind(counter.asString());
    }

    /**
     * Metodo para obtener el valor actual de la variable contador.
     * @return  Devuelve el valor actual del contador.
     */
    public int getCounter() {
        return counter.get();
    }

    /**
     * Metodo que devuelve la property utilizada.
     * @return  Devuelve la property utilizada para asignar valores al contador.
     */
    public SimpleIntegerProperty counterProperty() {
        return counter;
    }

    /**
     * Metodo para asignar el valor desde donde se va a hacer la cuenta atrás.
     * @param counter el número (en segundos) del que se va a empezar.
     */
    public void setCounter(int counter) {
        this.counter.set(counter);
    }

    /**
     * Metodo que inicia la cuenta atrás utilizando un timeline.
     */
    public void doCountdown() {
        final Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(counter.get()),
                new KeyValue (counter, 0)));
        timeline.play();
    }
}
