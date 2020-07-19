学习笔记

动态规划的理解

从递归 ->分治-> 回溯->  动态规划

每一个阶段的学习依赖于底层的掌握；

理解了递归，是使用自我相似性的策略来处理同样小规模的子问题。

分治是将复杂的问题拆解成更小的子问题。

回溯是在分治过程中，对不可行的路径减去，回到待选的方案。

动态规划，





复习一下递归模板

recur(int level, int param) {

// terminator

if (level > Max) {	

​	return;

}

// 处理当前逻辑

processLogic(level, param)

// drill down

recur(level+1, newParam);

// restore current status

}







说下学习动态规划的感受

基本逻辑按照三步走

1 分解成子问题      problem(n1,n2,n....) = subproblem(n1',n2',n3'..) + subproblem(n1'',n2'',n3'') + k(n1) 



2 定义状态数组  dp[n1,n2,n3..]



3 DP方程  dp[n1,n2,n3...] =    Function(dp[n1+1,n2+1...], dp[n1+2,n2+2...],dp[n1+3,n2+3..])





可惜实际运用起来没有那么容易，分解问题，找到适合的递归状态数组，DP方程都需要很多实践以及细节处理。



DP的自底向下的解决方案是手动完成递归调用栈，用for循环来实现每一次子结果的存储。



核心逻辑还是分解问题，寻找到递归联系，找到终止条件，建立对应的数据模型存储每一次的最优子结果，减少重复的计算。 

