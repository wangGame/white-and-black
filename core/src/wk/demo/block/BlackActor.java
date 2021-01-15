package wk.demo.block;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BlackActor extends Group {
    private Image black;
    private int color;
    private GameView.BlackClickListener listener;
    public BlackActor(int color, float width, float height,int posX,int posY){
        setSize(width,height);
        black = new Image(new Texture("white_10x10.png"));
        addActor(black);
        black.setSize(getWidth(),getHeight());
        setColor(color);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                listener.click(posX,posY);
            }
        });
    }

    public void setColor(int color) {
        this.color = color;
        if (this.color == Constant.BLACK){
            black.setColor(Color.BLACK);
        }else {
            black.setColor(Color.WHITE);
        }
    }

    public void revort(){
        int color = 1 - this.color;
        setColor(color);
    }

    public void addClickListener(GameView.BlackClickListener listener) {
        this.listener = listener;
    }
}
