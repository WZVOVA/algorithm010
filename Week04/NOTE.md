学习笔记



DFS模板                                                                                   

python写法                                                                                                Java模板

visited = set()                                      				        Set<Node>	visited = new HashSet();                                                     	

def dfs(node, visited):							        public void dfs(node, visted) {

​	if node in visited:   #terminator					      if (!visited.contains(node)) 

​		return                                                                               return;

​	visited.add(node)								       visted.add(node);										



​	# process                                     

​	for next_node in node.children():                                    for (Node child : node.children()) {

 		if next_node not in visited:                                 	    if (!visted.contains(child)) {

​			dfs(next_node, visited)						  dfs(child, visited)

​													    }

​                                                                                                        }

​                                                                                                    }

非递归写法, 使用栈来模拟递归，实现后进先出

def DFS(self, tree):                                                                 public void DFS(Node tree) {

​	if tree.root is None: 					                         if (tree == null)  return new int[0];

 		return []                                                                          Set<Node> visited = neHashSet();

​	visited, stack = [], [tree.root]                                               Stack stack = new Stack();

​											                 stack.push(tree);

​										                         while (!stack.isEmpty()) {

 												              Node node = stack.pop();					    			            				       	

​	while stack:                                                                                 visited.add(node);

​		node = stack.pop()                                                            process(node);

​		visited.add(node)							             for (Node child: node.children()) {

​												                   stack.push(child)		

​		process(node)							             }

​		nodes = generate_related_nodes(node)                  }

​		stack.push(nodes)                                                }



BFS模板

python                                                                                                                               Java

// 使用队列来保存

​	def bfs(tree):                                                                    public void bfs(Node tree) {

​		visited = set()								        Set<Node> visited = new HashSet();

​		queue = []								        Queue<Node> queue = new LinkedList();

​		queue.append(tree):							queue.offer(tree);

​		while queue:									while (!queue.isEmpty()) {

​			node = queue.pop()							Node node = queue.poll();

​			visited.add(node)								visited.add(node);

​			process(node)								process(node);

​			nodes = generate_related_nodes(node)			for (Node child : node.children()) {

​			queue.push(nodes)								queue.offer(child);

​														}

​													}

​												}

二分查找模板

python																Java

left, right = 0, len(array) - 1							int left = 0, mid = 0, right  = array.length - 1;

while left < right:									while (left < right)  {

​	mid = left + (right - left) >> 1						mid = left + (right - left) >>1;					  	

​	if array[mid] == target:           						if (array[mid] == target) {

​		return mid										return mid;

​	elif array[mid] < target:							} else if (array[mid] < target) {

​		left = mid + 1										left = ++mid;

`	else:											} else {

​		right = mid -1										right = --mid;

​													}

​												}







