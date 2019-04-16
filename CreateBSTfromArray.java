
//google amazon
public class CreateBSTfromArray {

	public static void main(String[] args) {

		int a[] = { 2, 5, 6, 8, 9, 11, 23, 25 };
		Node mRoot = null;
		mRoot = BST(a, 0, a.length - 1);
		BST(mRoot);
	}

	public static Node BST(int[] aInput, int aStartPointer, int aEndPointer) {
		if (aStartPointer > aEndPointer) {
			return null;
		} else {
			int mMid = (aStartPointer + aEndPointer) / 2;
			Node mRoot = new Node(aInput[mMid]);
			mRoot.left = BST(aInput, aStartPointer, mMid - 1);
			mRoot.right = BST(aInput, mMid + 1, aEndPointer);

			return mRoot;
		}
	}

	private static Node BST(Node aRoot) {
		if (aRoot == null) {
			return null;
		}
		System.out.println(aRoot.value);
		BST(aRoot.left);// left

		BST(aRoot.right);// right

		return aRoot;

	}
}
