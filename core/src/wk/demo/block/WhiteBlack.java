package wk.demo.block;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.CpuSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;

import wk.demo.block.aseet.Asset;
import wk.demo.block.bean.LevelBean;

public class WhiteBlack extends Game {
    private Texture texture;
    private Sprite sprite;
    public static SpriteBatch batch;
    public static boolean runGame;
    public static Viewport viewport ;

    @Override
    public void create() {
        viewport = new ExtendViewport(300,300);
        resize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        texture = new Texture(Gdx.files.internal("title.png"));
        sprite = new Sprite(texture);
        batch = new CpuSpriteBatch();
        runGame = true;
        Asset asset = new Asset();
        asset.loading();
        HashMap<Integer, LevelBean> levelBean = asset.getLevelBean();
        System.out.println(levelBean.size());
        setScreen(new GameScreen());
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    public void pause () {
        runGame = false;
    }

    @Override
    public void resume () {
        runGame = true;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        viewport.update(width,height);
        viewport.apply();
        Constant.width = viewport.getWorldWidth();
        Constant.hight = viewport.getScreenHeight();
    }
}
