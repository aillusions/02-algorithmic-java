A Tree is just a restricted form of a Graph.

Trees have direction (parent / child relationships) and don't contain cycles. 
They fit with in the category of Directed Acyclic Graphs (or a DAG). 
So Trees are DAGs with the restriction that a child can only have one parent.

Singly linked list is a special case of a DAG


A binary tree is a linked data structure where each node points to two child nodes (at most). 
Binary Tree is a hierarchical data structure in which each node has zero, one, or at the most, two children
Each node contains a “left” pointer, a “right” pointer, and a data element. The “root” pointer represents the topmost node in the tree. 

----

BST - A binary tree is a Binary Search Tree  --
    if the key of the node:
    - is greater than all the nodes in its left subtree 
    - and is smaller than all the nodes in its right subtree
 
---- 
 
Graphviz - Graph Visualization Software 
 https://graphviz.gitlab.io/documentation/
 
 
----

BBST - balanced Binary Search Trees
 
B-Tree, AVL and Red-Black Tree -- are self-balancing trees

a B-tree is a self-balancing tree data structure that maintains sorted data and allows searches, 
sequential access, insertions, and deletions in logarithmic time. 
A B-tree is a self-balancing tree that is a variation on a binary search tree in that it allows for more than 2 child nodes. 

Red-Black Tree - underline structure in TreeSet


AVL - re-balancing with every modification, so it's not so good for insertions / removals but very good for search.
Red-Black tree is better for general use case
