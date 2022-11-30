package wk.demo.block.group;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import wk.demo.block.WhiteBlack;
import wk.demo.block.screen.GameScreen;

public class SuccessGroup extends Group {
    public SuccessGroup(){
        Image image = new Image(new Texture("white_10x10.png"));
        image.setSize(300,300);
        addActor(image);
        setSize(300,300);

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                WhiteBlack.game.setScreen(new GameScreen());
            }
        });
    }
}
