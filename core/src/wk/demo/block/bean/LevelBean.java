package wk.demo.block.bean;

public class LevelBean {
    private Float StageId;
    private String levelName;
    private String isNewLevel;
    private String lvupLeft;
    private float rows;
    private float cilumns;
    private float star2;
    private float star3;
    private String boardStatus;
    private String boardTips;

    public Float getStageId() {
        return StageId;
    }

    public void setStageId(Float stageId) {
        StageId = stageId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getIsNewLevel() {
        return isNewLevel;
    }

    public void setIsNewLevel(String isNewLevel) {
        this.isNewLevel = isNewLevel;
    }

    public String getLvupLeft() {
        return lvupLeft;
    }

    public void setLvupLeft(String lvupLeft) {
        this.lvupLeft = lvupLeft;
    }

    public float getRows() {
        return rows;
    }

    public void setRows(float rows) {
        this.rows = rows;
    }

    public float getCilumns() {
        return cilumns;
    }

    public void setCilumns(float cilumns) {
        this.cilumns = cilumns;
    }

    public float getStar2() {
        return star2;
    }

    public void setStar2(float star2) {
        this.star2 = star2;
    }

    public float getStar3() {
        return star3;
    }

    public void setStar3(float star3) {
        this.star3 = star3;
    }

    public String getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(String boardStatus) {
        this.boardStatus = boardStatus;
    }

    public String getBoardTips() {
        return boardTips;
    }

    public void setBoardTips(String boardTips) {
        this.boardTips = boardTips;
    }
}
