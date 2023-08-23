package googleInterviewQuestion.Monday;

public class CountTheSquaresInaDiagram {

    static class Node {
        float x, y;
        Node neighbourNodes[] = new Node[4];
    }

    public static int calculateNumberOfSquares(Node[] nodeList) {
        int numberOfSquares = 0;
        int left = 0, right = 1, up = 2, down = 3;

        for (Node topLeftVertex : nodeList) {
            Node topRightVertex = topLeftVertex.neighbourNodes[right];
            while (topRightVertex != null) {
                float lengthOfEdgeHorizontal = topRightVertex.x - topLeftVertex.x;
                Node bottomRightVertex = topRightVertex.neighbourNodes[down];

                while (bottomRightVertex != null) {
                    float lengthOfEdgeVerticalRight = topRightVertex.y - bottomRightVertex.y;
                    if (lengthOfEdgeVerticalRight <= lengthOfEdgeHorizontal) {
                        if (lengthOfEdgeVerticalRight == lengthOfEdgeHorizontal) {
                            Node bottomLeftVertex = bottomRightVertex.neighbourNodes[left];
                            while (bottomLeftVertex != null) {
                                float bottomEdgeHorizontalLength = bottomRightVertex.x - bottomLeftVertex.x;
                                if (bottomEdgeHorizontalLength <= lengthOfEdgeHorizontal) {
                                    if (bottomEdgeHorizontalLength == lengthOfEdgeHorizontal) {
                                        Node cyclicNode = bottomLeftVertex.neighbourNodes[up];
                                        while (cyclicNode != null) {
                                            float lengthOfEdgeVerticalLeft = cyclicNode.y - bottomLeftVertex.y;
                                            if (lengthOfEdgeVerticalLeft <= lengthOfEdgeHorizontal) {
                                                if (lengthOfEdgeVerticalLeft == lengthOfEdgeHorizontal) {
                                                    numberOfSquares++;
                                                }
                                                cyclicNode = bottomRightVertex.neighbourNodes[down];
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        return numberOfSquares;
    }

    public static void main(String[] args) {
        System.out.println("Testing the Code from here");
    }
}

