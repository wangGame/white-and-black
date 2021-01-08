package wk.demo.block;

import java.util.HashMap;

import wk.demo.block.bean.LevelBean;

public class GameData {
    private HashMap<Integer, LevelBean> levelBean ;
    public GameData(){
        levelBean = Constant.asset.getLevelBean();
    }

    public HashMap getHashMap() {
        return levelBean;
    }

    public LevelBean getLevel(int levelId){
        return levelBean.get(levelId);
    }

}