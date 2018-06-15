package main.june_18._7

class TreeNode(var value: Int, var left: TreeNode? = null, var right: TreeNode? = null)


fun initTree(): TreeNode {
    val grandFather = TreeNode(10)
    val father = TreeNode(9)
    val mother = TreeNode(20)
    val son = TreeNode(15)
    val daughter = TreeNode(35)
    grandFather.left = father
    grandFather.right = mother
    mother.left = son
    mother.right = daughter
    return grandFather
}

fun inTraversalTree(root: TreeNode?) {
    if (root != null) {
        inTraversalTree(root.left)
        println(root.value)
        inTraversalTree(root.right)
    }
}

//创建一个类表示根节点
data class TreeRoot(var treeRoot: TreeNode?)

//创建二叉树
fun createBinaryTree(root: TreeRoot, value: Int) {
//    若根节点为null，则以传入的值作为根节点
    if (root.treeRoot == null) {
        root.treeRoot = TreeNode(value)
    } else {
        var tempRoot = root.treeRoot
        while (tempRoot != null) {
//        新值小于当前节点，往左走
            if (value < tempRoot.value) {
//            若左边节点为空，直接挂载
                if (tempRoot.left == null) {
                    tempRoot.left = TreeNode(value)
                    return
//                若不为空，则到左边的树根去；
                } else {
                    tempRoot = tempRoot.left
                }
//                新值大于当前节点，往右走
            } else {
//                右节点为空，直接挂载
                if (tempRoot.right == null) {
                    tempRoot.right = TreeNode(value)
                    return
//                    右节点不为空，则到右节点去
                } else {
                    tempRoot = tempRoot.right
                }
            }
        }
    }
}

val array = arrayOf(3, 2, 1, 4, 5)

fun create(): TreeNode? {
    val root = TreeRoot(null)
    array.forEach {
        createBinaryTree(root, it)
    }
//    inTraversalTree(root.treeRoot)
    return root.treeRoot
}

//查找二叉树的最大值
fun getMax(node: TreeNode?): Int {
    if (node == null) {
        return -1
    }
    val leftNode = getMax(node.left)
    val rightNode = getMax(node.right)
    val currentValue = node.value
    return maxOf(leftNode, rightNode, currentValue)
}

fun main(args: Array<String>) {
    val root = create()
    println("最大节点值：${getMax(root)}")
}



