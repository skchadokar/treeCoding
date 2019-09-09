package com.amazon.linklist;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class TreeClass {
static int count=0;
	public static void main(String[] args) throws Exception {
		   int  l=0;
		Node node = new Node(3);
		node.left = new Node(1);
		node.left.left = new Node(2);
		//node.left.left.right = new Node(3);
	    node.left.right = new Node(31);
		node.right = new Node(11);
		node.right.left = new Node(13);
		//node.right.left.left = new Node(3);
		//node.right.left.right = new Node(4);
		node.right.right = new Node(14);
		TreeClss  tn = new TreeClss();
		//System.out.println("Sum=="+tn.sumNode(node));
		//System.out.println("sum of max path=="+tn.sumOfMaxNode(node));
		Map<Integer,String> m = new LinkedHashMap<>();
		//System.out.println("is Symetric=="+tn.isSymmetric(node.left,node.right));
		// tn.printNodeWithLvl(node,l,m,0);
		
		tn.LCS(node,13,14);
		
		for(Entry<Integer, String> map :m.entrySet()) {
		//	System.out.println(map.getValue());
		}
		
		
		
		// tn.printNodeWithVerticle(node,l,m);
		
		for(Entry<Integer, String> map :m.entrySet()) {
		//	System.out.println(map.getValue());
		}
	
		
	//	System.out.println("is unival tree:"+ tn.isUnivalTree(node));
		
		
	//	printPreNode(node);
		System.out.println();
		//printInNode(node);
		System.out.println();
	//	printPostNode(node);
	//	deleteNode(node,new Node(60));
	//	printPostNode(node);
	}

   private void LCS(Node node, int v1, int v2) {
	   List<Integer> pathtoRoot1 = new ArrayList<Integer>() ;
	   List<Integer> pathtoRoot2 = new ArrayList<Integer>() ;
	 
	   findPath(node,v1,pathtoRoot1);	
	   findPath(node,v2,pathtoRoot2);	
	   int i; 
       for (i = 0; i < pathtoRoot1.size() && i < pathtoRoot2.size(); i++) { 
           if (!pathtoRoot1.get(i).equals(pathtoRoot2.get(i))) 
               break; 
       } 
       System.out.println(pathtoRoot1.get(i-1)); 
	
	}

   private boolean findPath(Node root, int n, List<Integer> path) 
   { 
       if (root == null) return false; 
       path.add(root.value); 
       if (root.value == n)   return true; 
       if (root.left != null && findPath(root.left, n, path)) return true; 
       if (root.right != null && findPath(root.right, n, path)) return true; 
       path.remove(path.size()-1); 
       return false; 
   } 

private boolean isSymmetric(Node left,Node right) {
	   if(left ==null && right==null) {
		   return true;
	   }
	   if(left ==null && right !=null ||left !=null && right ==null || left.value!=right.value ) {
		   return false;
	   }
		return isSymmetric(left.left,left.right) && isSymmetric( right.left,right.right);
	}

private boolean isUnivalTree(Node node) {
		// TODO Auto-generated method stub
	   if(node==null) {
		   return true;
	   }
	   if(node.left!=null && node.right!=null) {
		   if(node.left.value==node.right.value && node.right.value==node.value) {
			   return true;
		   }
	   }
	 boolean	isleft = isUnivalTree( node.left);
	 boolean	isrigth= isUnivalTree( node.right);
	  return false;
	}

List<Integer> lvlList = new ArrayList();
private  void printNodeWithLvl(Node node,int l,Map<Integer,String> m,int lvl) {
	   if(node==null) {
		   return;
	   }
	  if(m.containsKey(lvl)) {
		  m.put(lvl, new StringBuilder(m.get(lvl)).append(node.value).toString());
	  }else {
		  m.put(lvl, node.value+"");
	  }
	  l++;
	  printNodeWithLvl( node.left,l,m,++lvl);
	  printNodeWithLvl(node.right,l,m,++lvl);
		
	}
   
   
   private  void printNodeWithVerticle(Node node,int l,Map<Integer,String> m) {
	   if(node==null) {
		   return;
	   }
	 
	  printNodeWithVerticle( node.left,l,m);
	
	 // System.out.println(node.value);
	  printNodeWithVerticle(node.right,l,m);
	  if(m.containsKey(l)) {
		  m.put(l, new StringBuilder(m.get(l)).append(node.value).toString());
	  }else {
		  m.put(l, node.value+"");
	  }
	  l++;
		
	}
   
int maxSum =Integer.MIN_VALUE;

	private Integer sumOfMaxNode(Node node) {
		int sum =0;
		maxSum= helper(node,sum);
	     return maxSum;
	}
     
	 int helper(Node root,int sum){
         if(root==null) {
			return 0;
		}
   
		int l = Math.max(maxSum,helper(root.left,sum)); 
		int r = Math.max(maxSum,helper(root.right,sum));  
	    sum = Math.max(sum,l+r+root.value);
		return Math.max(l,r)+root.value;
	 }
	private static void deleteNode(Node node,Node d) {
	
		if(node.value==d.value) {
			System.out.println(node.value);
			node = node.left;
			return;
		}
		if(node.value<d.value) {
			deleteNode(node.right,d);
		}else {
			deleteNode(node.right,d);
		}
		
	}
	
int sum =0;
Stack<Integer> sc = new Stack();
	private  int sumNode(Node node) {
		if(node==null) {
			return sum;
		}
	    sumNode(node.left);
	    sumNode(node.right);
	    System.out.println(node.value);	
		sum =  sum +node.value;
		return sum;
	}


	private static void printPreNode(Node node) {
		if(node ==null) {
			return ;
		}
		 System.out.print(node.value+" ");
		 printPreNode(node.left);
		 printPreNode(node.right);
	}
	
	private static void printInNode(Node node) {
		if(node ==null) {
			return ;
		}
		printInNode(node.left);
		 System.out.print(node.value+" ");
		 printInNode(node.right);
	}
	
	private static void printPostNode(Node node) {
		if(node ==null) {
			return ;
		}
		
		 printPostNode(node.left);
		 printPostNode(node.right);
		 System.out.print(node.value+" ");
	}
}
