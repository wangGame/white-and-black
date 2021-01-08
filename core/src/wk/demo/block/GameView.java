package wk.demo.block;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;

import wk.demo.block.bean.LevelBean;

public class GameView extends Group {
    public GameView(GameData data){
        setSize(Constant.width,Constant.hight);
        Group black = new Group();
        addActor(black);
        LevelBean level = data.getLevel(1);
        int rows = (int) level.getRows();
        int cilumns = (int) level.getCilumns();
        String levelName = level.getLevelName();
        String boardStatus = level.getBoardStatus();

        int max = 0;
        if (max < rows){
            max = rows;
        }
        if (max < cilumns){
            max = cilumns;
        }

        float everyWidth = (Constant.width - 20)/max;
        black.setSize(everyWidth*rows,everyWidth*cilumns);
        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < cilumns; i1++) {
                Image image = new Image(new Texture("white_10x10.png"));
                image.setSize(everyWidth-5,everyWidth-5);
                image.setPosition((i)*(black.getWidth()/3+2.5F),(i1)*(black.getHeight()/3+2.5F));
                black.addActor(image);
            }
        }
        black.setPosition(getWidth()/2,getHeight()/2, Align.center);
        black.setDebug(true);

        String[] split = boardStatus.split(",");
        for (String s : split) {
            int i = Integer.parseInt(s);
            if (i==0){

            }
        }
    }
}
