package wk.demo.block.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import wk.demo.block.constant.Constant;
import wk.demo.block.screen.view.GameView;

public class BlackActor extends Group {
    private Image black;
    private int imageColor;
    private GameView.BlackClickListener listener;
    public BlackActor(int imageColor, float width, float height, int posX, int posY){
        setSize(width,height);
        black = new Image(new Texture("white_10x10.png"));
        addActor(black);
        black.setSize(getWidth(),getHeight());
        setImageColor(imageColor);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                revort();
                listener.click(posX,posY);
            }
        });
    }

    public void setImageColor(int imageColor) {
        this.imageColor = imageColor;
        if (this.imageColor == Constant.BLACK){
            black.setColor(Color.BLACK);
        }else {
            black.setColor(Color.WHITE);
        }
    }

    public void revort(){
        int color = 1 - this.imageColor;
        setImageColor(color);
    }

    public int getImageColor(){
        return imageColor;
    }

    public void addClickListener(GameView.BlackClickListener listener) {
        this.listener = listener;
    }
}
