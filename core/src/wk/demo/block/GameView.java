package wk.demo.block;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

import wk.demo.block.bean.LevelBean;

public class GameView extends Group {
    private BlackActor[][] blackActors;
    private int rows;
    private int columns;
    public GameView(GameData data){
        setSize(Constant.width,Constant.hight);
        Group black = new Group();
        addActor(black);
        LevelBean level = data.getLevel(1);
        rows = (int) level.getRows();
        columns = (int) level.getCilumns();
        String levelName = level.getLevelName();
        String boardStatus = level.getBoardStatus();

        int max = 0;
        if (max < rows){
            max = rows;
        }
        if (max < columns){
            max = columns;
        }

        float everyWidth = (Constant.width - 20)/max;
        black.setSize(everyWidth*rows,everyWidth*columns);
        String[] split = boardStatus.split(",");
        int arr[][] = new int[rows][columns];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = Integer.parseInt(split[count]);
                count++;
            }
        }

        blackActors = new BlackActor[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                BlackActor actor = new BlackActor(arr[i][j],everyWidth-5,everyWidth-5,i,j);
                actor.setPosition((i)*(black.getWidth()/3+2.5F),j*(black.getHeight()/3+2.5F));
                black.addActor(actor);
                actor.addClickListener(listener);
                blackActors[i][j] = actor;
            }
        }
        black.setPosition(getWidth()/2,getHeight()/2, Align.center);
        black.setDebug(true);

        for (String s : split) {
            int i = Integer.parseInt(s);
            if (i==0){

            }
        }
    }

    private BlackClickListener listener = new BlackClickListener() {
        private Array<BlackActor> actors = new Array<>();
        @Override
        public void click(int x, int y) {
            actors.clear();
            //上
            if (y-1>=0){
                actors.add(blackActors[y-1][x]);
            }
            //下
            if (y+1<rows){
                actors.add(blackActors[y+1][x]);
            }
            //左
            if (x-1>=0){
                actors.add(blackActors[y][x-1]);
            }
            //右
            if (x+1<columns){
                actors.add(blackActors[y][x+1]);
            }
            for (BlackActor actor : actors) {
                actor.revort();
            }
        }
    };

    interface BlackClickListener {
        public void click(int x,int y);
    }
}
