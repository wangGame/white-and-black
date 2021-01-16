# 黑往白来

模仿游戏黑往白来完成了最核心的部分。数据处理时通过游戏解包得到的，仅仅作为学习游戏使用。

## 实现方式

每次点击一个块，改变相邻块的颜色，直到游戏的块都变为黑色结束。

```java
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
            for (BlackActor actor : actors) {
                if (actor.getImageColor() == Constant.WHITE){
                    return;
                }
            }
            showPassPanel();
        }

        private void showPassPanel() {
            
        }
    };
```

核心代码的思路，写一个回调方法，添加到每个块上面，每次点击执行这个方法，检测过关的方式通过每次点击之后循环所有的块，查看有没有白块，没了，那也就过关了。

这种游戏数据比较少循环是可以的，如果想改进，那就游戏开始的时候，维护一个全局变量，每次颜色发生 改变的时候，改变数据的个数。每次点击之后，判断数目是不是等于总的数目（白就减去，黑就加1）

## 其他

了解更多游戏核心写法[点击链接去查看更多](https://github.com/wangGame/)

