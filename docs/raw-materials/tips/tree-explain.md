## README

Tree: 
Node - a single point of a tree
Edge - line, which connects two distinct nodes
Root - top node of the tree, which has no parent
Parent - a node, other than the root, which is connected to other successor nodes
Child - a node, other than the root, which is connected to predecessor
Leaf - a node without children
Path - a sequence of nodes and edges connecting a node with a descendant
Path Length - number of nodes in the path - 1
Ancestor - the top parent node of the path
Descendant - the bottom child node of the path
Siblings - nodes, which have the same parent
Subtree - a node in a tree with all of its proper descendants, if any
Node Height - the number of edges on the longest downward path between that node and a leaf
Tree Height - the number of edges on the longest downward path between the root and a leaf (root height)
Depth (Level) - the path length between the root and the current node
Ordered Tree - tree in which nodes has the children ordered
Labeled Tree - tree in which a label or value is associated with each node of the tree
Expression Tree - tree which specifies the association of an expression's operands and its operators in a uniform way, regardless of whether the association is required by the placement of parentheses in the expression or by the precedence and associativity rules for the operators involved
Branching Factor - maximum number of children a node can have
Pre order - a form of tree traversal, where the action is called firstly on the current node, and then the pre order function is called again recursively on each of the subtree from left to right
Post order - a form of tree traversal, where the post order function is called recursively on each subtree from left to right and then the action is called