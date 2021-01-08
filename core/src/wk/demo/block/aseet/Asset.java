package wk.demo.block.aseet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import java.util.HashMap;

import wk.demo.block.bean.LevelBean;
import wk.demo.block.utils.PythonArray;
import wk.demo.block.utils.PythonDict;

public class Asset {
    private HashMap<Integer, LevelBean> levelBean = new HashMap<>();
    public void loading(){
        try {
//            BufferedReader reader = new BufferedReader(new FileReader("android/assets/level.json"));
            String fileData = Gdx.files.local("level.json").readString();
            Json json = new Json(JsonWriter.OutputType.json);
            PythonDict root = json.fromJson(PythonDict.class, fileData);
            PythonDict valueAt = (PythonDict) root.getValueAt(0);
            for (int i = 1; i <= valueAt.size; i++) {
                LevelBean bean = new LevelBean();
                PythonDict pythonDict = (PythonDict) valueAt.get(i+"");
                Float stageId = (Float) pythonDict.get("stageId");
                String levelname = (String) pythonDict.get("levelname");
                float isNewlevel = (Float)pythonDict.get("isNewlevel");
                float lvupleft = (float) pythonDict.get("lvupleft");
                float rows = (float)pythonDict.get("rows");
                float columns = (float)pythonDict.get("columns");
                float star2 = (float)pythonDict.get("star2");
                float star3 = (float)pythonDict.get("star3");
                String boardStatus = (String)pythonDict.get("boardStatus");
                String boardTips = (String) pythonDict.get("boardTips");
                bean.setStageId(stageId);
                bean.setLevelName(levelname);
                bean.setIsNewLevel(""+isNewlevel);
                bean.setLvupLeft(lvupleft+"");
                bean.setRows(rows);
                bean.setCilumns(columns);
                bean.setStar2(star2);
                bean.setStar3(star3);
                bean.setBoardStatus(boardStatus);
                bean.setBoardTips(boardTips);
                levelBean.put(i,bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, LevelBean> getLevelBean() {
        return levelBean;
    }
}
