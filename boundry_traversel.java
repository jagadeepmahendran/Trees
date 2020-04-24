import java.util.*;
class bound{
  static  class node{
     String data;
     node right,left;
    node(String data)
         {
           this.data=data;
           right=left=null;
         }
     }

      static node insert(node t,String s1[]){
             Queue<node> q=new LinkedList<>();
              t=new node(s1[0]);
              q.add(t);
              node root=q.peek();
              for(int i=1;i<s1.length;i++)
                 {
                         t=q.poll();
                   if(!s1[i].equals("N")&&t.left==null)
                       {
                         t.left=new node(s1[i]);
                         q.add(t.left);
                       }
                       i++;
                       if(i>=s1.length)
                          break;
                          if(!s1[i].equals("N")&&t.right==null)
                           {
                             t.right=new node(s1[i]);
                             q.add(t.right);
                           }
                 }
                  return root;
         }
        static  void preorder(node t){
         //  node t=root;
           if(t!=null)
            {
              System.out.print(t.data+" ");
              preorder(t.left);
              preorder(t.right);
            }
         }

           static void printleft(node t)
            {
              if(t==null)
                 return ;
                  if(t.left!=null){
                    System.out.print(t.data+" ");
                    printleft(t.left);
                  }
                    else if(t.right!=null)
                       {
                        System.out.print(t.data+" ");
                         printleft(t.left);
                       }


            }
            static void printright(node t)
             {
               if(t==null)
                return;
                 if(t.right!=null)
                     {  printright(t.right);
                       System.out.println(t.data+" ");
                     }
                     else if(t.left!=null)
                      {
                        printright(t.right);
                        System.out.print(t.data+" ");
                      }
             }
        static void printleaf(node t)
         {
           if(t==null)
            return;

            if(t.left==null&&t.right==null)
                System.out.print(t.data+" ");
                printleaf(t.left);
                printleaf(t.right);
         }

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
       node root=null;
        int t=Integer.parseInt(sc.nextLine());
          while(t-->0)
            {
              String s=sc.nextLine();
              String s1[]=s.split(" ");
              root=insert(root,s1);
   System.out.print("PRE_ORDER : ");
   preorder(root);
    System.out.println();
    System.out.println("Boundary elements are :");
       System.out.print(root.data+" ");
      printleft(root.left);
      printleaf(root);
      printright(root.right);
    }
  }
}
//is sum tree
// is bst tree
// Boundary
//ansester
//paths root to all leaf
//diameter of a tree
//height of tree
//level order insertionaa
//vertical traversal
