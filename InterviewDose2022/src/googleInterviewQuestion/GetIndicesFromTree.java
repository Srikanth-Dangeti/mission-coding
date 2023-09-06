package googleInterviewQuestion;

/***
 *1.Y We're trying to index values stored in a tree structure. Each node in the tree node has three properties.
 * list. We'd like to assign an index to each value. Whenever a node has a False in its values, any children
 * it has will skip that inde the root node of the tree always has an index of O_N-1
 * We're trying to index values stored in a tree structure. Each node in the tree node has three properties: left,
 * right and values. Values is a boolean list. We'd like to assign an index to each value.
 * Whenever a node has a False in its values, any children it has will skip that index.
 * You can assume the root node of the tree always has an index of O. N-1
 * Imagine for instance a tree like. IT, T, F,
 * TI- root > indices. (0, 1, 2, 31 [T, F. TJ-root left.-indices: [0, 1. 3]
 * (T. FI - root. left left -> indices. (0, 3] (T, T, Fl - root right -> indices:
 * (0, 1. 31 We'd like to create a class which will be created
 * with the Root node of our tree, and can respond to queries
 * like getindices (node) and return the corresponding index array.
 *
 */



public class GetIndicesFromTree {
    public static void main(String[] args) {
        System.out.println("Main");
    }
}
