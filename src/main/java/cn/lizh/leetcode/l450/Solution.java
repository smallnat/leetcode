package cn.lizh.leetcode.l450;

public class Solution {
    // 关键是递归
    // 所有的和树相关的基本上都需要递归。
    // 解题方法，将所有可能列举出来，边界情况先处理；然后处理复杂逻辑的（一般来说边界条件时处理会比较简单，很多可以直接返回）
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) { // 根节点为null，直接返回null
            return null;
        }

        // 利用递归，如果不是删除根节点，那就是从左/右子树中删除某个节点，最终会递归到删除某颗树的根节点
        if (root.val < key) {
            // 从右子树中删除节点，并将root.right重新指向删除后的右子树（的根节点）
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            // 同上面右子树的逻辑一样
            root.left = deleteNode(root.left, key);
            return root;
        }

        // 以下为最终删除的逻辑，删除当前节点
        // 分为：1.左右子树均为空，那当前节点就是叶子节点，直接删除，返回null就可以。
        //      2.左子树为空，右子树有值。直接返回右子树。
        //      3.同2
        //      4.左右子树都不为空--见后面的分析
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // 都不为空：1.左子树最右节点替代当前节点的位置 2.右子树最左节点替代当前节点的位置
        // 这里选方案1
        // 找到左子树中最右节点 leftNode
        TreeNode leftNode = root.left;
        while (leftNode.right != null) {
            leftNode = leftNode.right;
        }
        // 左子树为删除了那个最右节点的平衡二叉树
        root.left = deleteNode(root.left, leftNode.val);  // 这里的递归调用，不是很习惯，一下子想不到
        // 使用leftNode替换根节点
        leftNode.left = root.left;
        leftNode.right = root.right;
        return leftNode;
    }
}
