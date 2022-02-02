# wordle-master
解决 [Wordle](https://www.powerlanguage.co.uk/wordle/) 和 [WordleGame](https://wordlegame.org) 等英文猜词游戏。
## 使用方法
1. ```git clone git@github.com:Craftsman98/wordle-master.git```
2. 运行
3. 在Wordle中输入第一个单词(默认第一个单词是`abort`，会显示在console中。可在代码中修改)
4. 将Wordle中的判定结果输入到console中。
   1. 0表示不包含改字母，即灰色。
   2. 1表示包含该字母，但是位置不正确，即黄色。
   3. 2表示包含该字母且在正确的位置，即绿色。
5. 在console输出的结果中选择一个单词输入Wordle中，并在console中输入该词的序号。
6. 重复4-5步，直至找到正确答案。