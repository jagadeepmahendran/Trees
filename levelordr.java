import java.util.*;
class level{

    static  class node{
        int data;
        node left,right;
         node(int data)
          {
            this.data=data;
             right=left=null;
          }
      }
   static node root=null;
    static  void insert(int data)
       {
         if(root==null){
            root=new node(data);
            return;
          }
         Queue<node> q=new LinkedList<>();
          q.add(root);

            while(!q.isEmpty())
             {
               node t=q.peek();
               q.remove();
               if(t.left==null)
                     {
                       t.left=new node(data);
                       break;
                     }
                     else
                        q.add(t.left);
                  if(t.right==null)
                        {
                        t.right=new node(data);
                          break;
                        }
                    else
                    q.add(t.right);

             }

       }
   static void levelprint(node root)
     {
       Queue<node> q1=new LinkedList<>();
        q1.add(root);
         while(!q1.isEmpty())
          {
            node t=q1.peek();
             System.out.print(t.data+" ");
            q1.remove();
            if(t.left!=null)
               q1.add(t.left);
              if(t.right!=null)
                 q1.add(t.right);
          }

     }


  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
       int x;
      while(true)
       {  x=sc.nextInt();
         if(x==-1)
          break;
            insert(x);
       }
      //   inorder();
         levelprint(root);
      //   System.out.print(root.right.data);
  }
}
