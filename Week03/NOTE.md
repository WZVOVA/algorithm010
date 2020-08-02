# 学习笔记



#学号:G20200343060324
#姓名:吴振
#班级:2班
#小组:1组






# 本周学习总结

​	谈谈我对递归，分治和回溯的新理解。



以前总是认为递归很难理解，每次思考都是一层层嵌套到最底层，然后思绪就炸了，太难思考下去了，曾几何时想放弃这种方式。



这一周的训练彻底颠覆了我之前的想法，以前写递归自己都理解不通，但是理解递归之后，我发现用递归解决问题的方式太简单了，只要考虑当层与下一层的关系，就能完成大量以前手动实现栈的代码数，简短快是我对递归新的理解。



而为什么会有这种转变呢，我觉得最重要一点是理解数学归纳法，满足最简单的1，2情况，进而当n情况满足时，证明n+1也满足，这是理解递归的诀窍， 当我们能用数学归纳法证明时，可以理解当n满足时，n-1也满足，进而推出2,1也满足，而这就是递归的terminator.



递归的模板让我记忆深刻

1 terminator

2 处理当前逻辑，为下一层进行绑定

3 drill down , 进入下一层

4 还原状态，综合结果





本质上看，这也是分治，将一个问题，不断drill down ,下沉到另一个子问题的解决，当最后一个终结者解决后，整个过程在归并得到最终结果，这是一种先递后归的过程。



说到分治， 我先想到MapReduce，这是大数据三剑客之一， DFS,MapReduce,BigTable,  已解决超大规模网页排序和储存提供了方案。

MapReduce的核心就是分治，将大的问题拆解为n个子问题，n个子问题再拆解，最后terminator，问题解决，归并结果。感觉很像递归的模板。



的确如此，terminator就是最小问题的解决，返回， 处理逻辑包括预制数据，分解问题，drilldown 则是各个子问题的解决， 然后多了一个merge的过程，最后依然有个还原状态的步骤。





回溯

我觉得就好像是将递归的过程中，不满足的情况，进行切断，感觉理解不行。

但是从他的定义了解到是在一个巨大的解空间里面进行遍历，

每个解就像一棵树一样，从上往下解决，当一个解不满足时，则减掉这个分支，回溯到最近一个没有走过的解，直到找到最终的答案。



回溯还是要好好学啊，理解不太行。











## 递归模板

### `Python实现`

def recusion (level, param1, param2, ...)

​      # recursion terminator

​       if level > MAX_LEVEL :

​            process_result

​	    return

​      # process logic in current level

​	process (level, data...)

​      # drill down

​	self.recursion (level+1, p1, ...)	

​      # revert the current level status if need

### Java实现

public void recur (int level, int param) {

​        // terminator	 

​	if (level > MAX_LEVEL) {

​        	// process result

​		return;

​	}

​	// process current logic

​	process (level, param);

​	// drill down

​     	recur (level + 1, newParam);

​        // restore current status 

}

## 分治模板



### Python实现

def  divide_conquer (problem, param1, param2,  ...) :

​	# recursion terminator

​        if problem is None:

​		print_result

​		return	

​       # prepare data

​       data = prepare_data (problem)

​       subproblems	= split_problem(problem, data)

​       # conquer subproblems

​       subresult1 = self.divide_conquer(subproblems[0], p1, ...)

​       subresult2 = self.divide_conquer(subproblems[1], p1, ...)

​       subresult3 = self.divide_conquer(subproblems[2], p1, ...)

​       ...  	

​       # process and generate the final result

​	result = process_result(subresult1, subresult2, subresult, ...)	

​       # revert the level status

### Java实现



public void divideConquer(Problem problem, int param, int result) {

​	// recursion terminator

 	if (problem == null) {
​		// process result

​		return;

​	}

​	// prepare data

​	Type data = prepareDate(problem);

​	Problem[] subproblems = split_problems(problem, data);   

​        // conquer subproblems

​	divideConquer(subproblems[0], p1, result);

​	divideConquer(subproblems[1], p1, result);

​	divideConquer(subproblems[2], p1, result);

​	...	

​       // process and generate the final result

​	processResult (result);

​       // restore current states     

}











class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:

        result = []

        self.DFS([], [], [], n, result)

        return [["."*i + "Q" + "."*(n-i-1) for i in sol]for sol in result]

    # xy_dif是na, xy_sum是pie

    def DFS(self, queens, xy_dif, xy_sum, length, result):

        # 当前行

        p = len(queens)

        if p == length:

            result.append(queens)

            return

        

        for q in range(length):

            if q in queens or p-q in xy_dif or p+q in xy_sum:

                continue

            self.DFS(queens+[q], xy_dif+[p-q], xy_sum+[p+q], length, result) 



