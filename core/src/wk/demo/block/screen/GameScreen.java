package wk.demo.block.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import wk.demo.block.aseet.Asset;
import wk.demo.block.screen.data.GameData;
import wk.demo.block.screen.view.GameView;
import wk.demo.block.WhiteBlack;

public class GameScreen implements Screen {
    private Stage stage;
    private Color color1 = new Color();
    @Override
    public void show() {
        stage = new Stage(WhiteBlack.viewport,WhiteBlack.batch);
        Gdx.input.setInputProcessor(stage);
        GameData data = new GameData();
        GameView view = new GameView(data);
        stage.addActor(view);
        color1.set(0,0,0,1);
        Image black = new Image(new Texture("white_10x10.png")){
            @Override
            public void act(float delta) {
                super.act(delta);
                setColor(color1);
            }
        };
        stage.addActor(black);
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
