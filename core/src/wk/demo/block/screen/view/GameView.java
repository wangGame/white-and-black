package wk.demo.block.screen.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

import wk.demo.block.actor.BlackActor;
import wk.demo.block.bean.LevelBean;
import wk.demo.block.constant.Constant;
import wk.demo.block.group.SuccessGroup;
import wk.demo.block.screen.data.GameData;

public class GameView extends Group {
    private BlackActor[][] blackActors;
    private int rows;
    private int columns;
    public GameView(GameData data){
        setSize(Constant.width,Constant.hight);
        Group black = new Group();
        addActor(black);
        LevelBean level = data.getLevel(Constant.level);
        rows = (int) level.getRows();
        columns = (int) level.getCilumns();
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
                BlackActor actor = new BlackActor(arr[i][j],
                        everyWidth-5,everyWidth-5,j,i);
                actor.setPosition((i)*(black.getWidth()/max+2.5F),j*(black.getHeight()/max+2.5F));
                black.addActor(actor);
                actor.addClickListener(listener);
                blackActors[i][j] = actor;
            }
        }
        black.setPosition(getWidth()/2,getHeight()/2, Align.center);
        black.setDebug(true);
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

            //检查是不是过关
//            for (BlackActor actor : actors) {
//                if (actor.getImageColor() == Constant.WHITE){
////                    Constant.level++;
////                    SuccessGroup successGroup = new SuccessGroup();
////                    getStage().addActor(successGroup);
////                    successGroup.setPosition(Constant.width/2,Constant.hight/2,Align.center);
////                    successGroup.setOrigin(Align.center);
////                    successGroup.setScale(0);
////                    successGroup.addAction(Actions.scaleTo(1,1,0.3f));
//                    return;
//                }
//            }
            for (BlackActor[] blackActor : blackActors) {
                for (BlackActor actor : blackActor) {
                    if (actor.getImageColor() == Constant.WHITE) {
                        return;
                    }
                }
            }
            showPassPanel();
        }

        private void showPassPanel() {
            Constant.level++;
            SuccessGroup successGroup = new SuccessGroup();
            getStage().addActor(successGroup);

            successGroup.setPosition(Constant.width/2,Constant.hight/2,Align.center);
            successGroup.setOrigin(Align.center);
            successGroup.setScale(0);
            successGroup.addAction(Actions.scaleTo(1,1,0.3f));
        }
    };

    public interface BlackClickListener {
        void click(int x,int y);
    }
}
