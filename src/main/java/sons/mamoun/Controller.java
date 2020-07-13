package sons.mamoun;

import com.google.gson.Gson;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class Controller {

    public TextArea text = null;
    public TextField txt1 = null;
    public TextField txt2 = null;
    public TextField txt3 = null;
    public GridPane grid = null;
    private ObservableList<Node> Squares_b = null ;


 /*   public ImageView black =new ImageView( new Image(getClass().getResourceAsStream("black.png")));
    public ImageView red  =new ImageView( new Image(getClass().getResourceAsStream("red.png")) );*/



    public Image black = new Image(getClass().getResourceAsStream("black2.png"));
    public Image red = new Image(getClass().getResourceAsStream("red.png"));

    private List<Square> Board = new ArrayList<>();
    private List<Profile> profileList = new ArrayList<>();
    private Player player;
    private String register_url = "https://springing-dog.herokuapp.com/player/register/name/country";
    private String register_url_local = "http://localhost:5000/player/register/name/country" ;
    private int click = -1;


    @FXML
    public void register(Event e) {

        if (player != null) {
            text.setText("you cant register two times");
            return;
        }
        try {
            register_url = register_url_local;
            register_url = register_url.replace("name", txt1.getText()).replace("country", txt2.getText());
            player = new Gson().fromJson(new InputStreamReader(new URL(register_url).openStream(), Charset.forName("UTF-8")), Player.class);
            text.setText(player.toString());
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), a ->refresh()));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();

        } catch (IOException ioException) {
//            ioException.printStackTrace();
            text.setText(ioException.getMessage());
        }

    }


    public void refresh() {

        try {

            if(player.getColor().equals(Square.EMPTY)) player = player.server().update_profile();
            if (player.getColor().equals(Square.EMPTY)) return;
            Board = player.server().load_game();
            if (Squares_b == null) create_grid();
            else fill_grid();
        } catch (IOException e) {
            text.setText(e.getMessage());
        }

    }

    @FXML
    void update(Event e) {
        if (player == null) {
            text.setText("you have to register at first");
            return;
        }

        try {
            player = player.server().update_profile();
            text.setText("Updated ... \n" + player);
        } catch (IOException ioException) {
            text.setText(ioException.getMessage());
        }
    }

    @FXML
    void find_players(Event e) {
        if (player == null) {
            text.setText("you have to register at first");
            return;
        }

        try {
            profileList = player.server().find_players();
            text.setText(profileList.toString());
        } catch (IOException ioException) {
            text.setText(ioException.getMessage());
        }
    }

    @FXML
    void start_game(Event e) {

        if (player == null) {
            text.setText("you have to register at first");
            return;
        }
        if (profileList.isEmpty()) {
            text.setText("try searching for Players at first");
            return;
        }


        try {
            Profile other = profileList.stream()
                    .filter(profile -> profile.getName().equals(txt3.getText()))
                    .findAny().orElseThrow(() -> new IOException("cannot find " + txt3.getText()));
            Board = other.server().challenge();
            create_grid();
            text.setText(Board.toString());
            update(null);
        } catch (IOException ioException) {
            text.setText(ioException.getMessage());
        }
    }


    private void onClick(int index) {
        Square s = Board.get(index);
        if (s.getColor().equals(Square.EMPTY)) {
            if (click == -1) return;
            if (Board.get(click).getMoves().isEmpty()) return;
            try {
                Move move = Board.get(click).getMoves().stream().
                        filter(m -> m.getTo() == index).findAny().
                        orElseThrow(() -> new IOException("move not valid"));
                player = player.server().play_game(click, index);
                click = index;
                Board = player.server().load_game();
                if (Squares_b == null) create_grid();
                else fill_grid();
            } catch (IOException e) {
                text.setText(e.getMessage());
            }

        } else if (s.getColor().equals(player.getColor())) {
            click = index;
            return;
        } else {
            click = -1;
        }

    }

/*
    public void load_game(ActionEvent actionEvent) {
        update(null);
        if (player == null) {
            text.setText("you have to register at first");
            return;
        }
        try {
            Board = player.server().load_game();
            fill_grid();
        } catch (IOException e) {
            text.setText(e.getMessage());
            text.appendText("you may have to search for player at first");
        }
    }
*/


    private void create_grid() {
        grid.setAlignment(Pos.CENTER);

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                int index = x + (5 * y);
                ImageView img = new ImageView();
                Button b = new Button() ;
                b.setGraphic(img);
                b.setOnAction(e -> onClick(index));
                img.setFitHeight(40);
                img.setFitWidth(40);
                grid.add(b, x, 4 - y);
            }
        }
        Squares_b = grid.getChildren();

        fill_grid();

    /*    for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                int index = x + (5 * y);
                Square s = Board.get(index);
                Button b = new Button();
                b.setOnAction(e -> onClick(index));
                ImageView img = new ImageView();
                img.setFitHeight(40);
                img.setFitWidth(40);
                b.setMaxSize(20, 20);
                if (s.getColor().equals(Square.BLACK)) img.setImage(black);
               else if (s.getColor().equals(Square.WHITE)) img.setImage(red);
               else  img.setImage(null);
                b.setGraphic(img);
                grid.add(b, x, 4 - y);

            }

        }*/
    }

    private void fill_grid() {

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                int index = x + (5 * y);
                Square s = Board.get(index);
                Button b = (Button) Squares_b.get(index);
                ImageView img = (ImageView) b.getGraphic();

                if (s.getColor().equals(Square.BLACK)) img.setImage(black);
                else if (s.getColor().equals(Square.WHITE)) img.setImage(red);
                else   img.setImage(null);

            }

        }
    }

}
