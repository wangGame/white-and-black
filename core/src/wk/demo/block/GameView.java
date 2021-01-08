package wk.demo.block;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameView extends Group {
    public GameView(){
        Group black = new Group();
        black.setSize(103*3,103*3);
        for (int i = 0; i < 3; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                Image image = new Image(new Texture("white_10x10.png"));
                image.setPosition(i*107,i1*107);
                black.addActor(image);
            }
        }
        addActor(black);

    }
}
